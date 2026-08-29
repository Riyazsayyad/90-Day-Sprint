"""Build full-text lesson search index from lesson-tray.js + HTML lesson files."""
import json
import re
import sys
from html.parser import HTMLParser
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
TRAY = ROOT / "assets" / "lesson-tray.js"
OUT = ROOT / "assets" / "lesson-search-index.json"

LESSON_RE = re.compile(
    r"\{\s*num:\s*'([^']+)',\s*file:\s*'([^']+)',\s*title:\s*'([^']+)',\s*"
    r"meta:\s*'([^']+)',\s*module:\s*'([^']+)',\s*moduleNum:\s*'([^']+)'"
    r"(?:,\s*kind:\s*'([^']+)')?"
)


class TextExtractor(HTMLParser):
    def __init__(self) -> None:
        super().__init__()
        self.parts: list[str] = []
        self._skip_depth = 0

    def handle_starttag(self, tag: str, attrs) -> None:
        if tag in ("script", "style"):
            self._skip_depth += 1

    def handle_endtag(self, tag: str) -> None:
        if tag in ("script", "style") and self._skip_depth:
            self._skip_depth -= 1

    def handle_data(self, data: str) -> None:
        if self._skip_depth:
            return
        text = re.sub(r"\s+", " ", data).strip()
        if text:
            self.parts.append(text)


def html_to_text(path: Path) -> str:
    raw = path.read_text(encoding="utf-8")
    start = raw.lower().find("<body")
    end = raw.lower().rfind("</body>")
    chunk = raw[start:end] if start != -1 and end != -1 else raw
    parser = TextExtractor()
    parser.feed(chunk)
    return " ".join(parser.parts)


def parse_tray() -> list[dict]:
    source = TRAY.read_text(encoding="utf-8")
    entries = []
    for match in LESSON_RE.finditer(source):
        num, file, title, meta, module, module_num, kind = match.groups()
        entries.append(
            {
                "num": num,
                "file": file,
                "title": title,
                "meta": meta,
                "module": module,
                "moduleNum": module_num,
                "kind": kind or "lesson",
            }
        )
    return entries


def lesson_path(entry: dict) -> Path:
    if entry.get("kind") == "exercise":
        return ROOT / "exercises" / entry["file"]
    return ROOT / "lessons" / entry["file"]


def public_href(entry: dict) -> str:
    if entry.get("kind") == "exercise":
        return f"exercises/{entry['file']}"
    return f"lessons/{entry['file']}"


def main() -> int:
    if not TRAY.exists():
        print(f"Missing {TRAY}", file=sys.stderr)
        return 1

    lessons = []
    for entry in parse_tray():
        path = lesson_path(entry)
        if not path.exists():
            print(f"Warning: missing {path}", file=sys.stderr)
            continue
        text = html_to_text(path)
        lessons.append(
            {
                **entry,
                "href": public_href(entry),
                "text": text,
            }
        )

    OUT.write_text(
        json.dumps({"generatedAt": __import__("datetime").date.today().isoformat(), "lessons": lessons}, ensure_ascii=False),
        encoding="utf-8",
    )
    print(f"Wrote {len(lessons)} lessons to {OUT}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
