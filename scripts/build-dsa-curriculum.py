"""Parse DSA_Questions_and_Patterns_500.pdf into assets/dsa-curriculum.json."""
import json
import re
import sys
from pathlib import Path

try:
    from pypdf import PdfReader
except ImportError:
    print("Install pypdf: pip install pypdf", file=sys.stderr)
    sys.exit(1)

PDF = Path(r"c:\Riyaz\Risky-Downloads\DSA_Questions_and_Patterns_500.pdf")
OUT = Path(__file__).resolve().parent.parent / "assets" / "dsa-curriculum.json"

PROBLEM_RE = re.compile(
    r"^(\d+)\.\s+(.+?)\s+\[(Easy|Medium|Hard)\]\s*$"
)
SECTION_RE = re.compile(
    r"Section\s+(\d+):\s+(.+?)\s+\(Q(\d+)\s*[–\-—]\s*Q(\d+)\)"
)
SUBSECTION_RE = re.compile(r"^(\d+)\.(\d+)\s+(.+)$")
PATTERN_INLINE_RE = re.compile(r"^(\d+)\.(\d+)\s+(.+?)\s+Pattern:\s+(.+)$")



def normalize_line(line: str) -> str:
    line = re.sub(r"\s+", " ", line).strip()
    return line


def extract_text() -> str:
    reader = PdfReader(str(PDF))
    raw = " ".join((p.extract_text() or "") for p in reader.pages)
    # PDF often inserts newlines between tokens
    raw = raw.replace("\n", " ")
    raw = re.sub(r"\s+", " ", raw)
    # Restore breaks before structural tokens
    raw = re.sub(r"\s+(Section\s+\d+:)", r"\n\1", raw)
    raw = re.sub(r"\s+(\d+\.\d+\s+)", r"\n\1", raw)
    raw = re.sub(r"\s+(\d+\.\s+[A-Z])", r"\n\1", raw)
    return raw


def parse(text: str) -> dict:
    sections = []
    current_section = None
    current_pattern = None

    for raw_line in text.splitlines():
        line = normalize_line(raw_line)
        if not line or line.startswith("--") or "Appendix" in line:
            continue
        if line.startswith("Closing Remarks"):
            break

        m_sec = SECTION_RE.match(line)
        if m_sec:
            current_section = {
                "id": f"section-{m_sec.group(1)}",
                "num": int(m_sec.group(1)),
                "name": m_sec.group(2).strip(),
                "qStart": int(m_sec.group(3)),
                "qEnd": int(m_sec.group(4)),
                "patterns": [],
            }
            sections.append(current_section)
            current_pattern = None
            continue

        m_sub = SUBSECTION_RE.match(line)
        if m_sub and current_section is not None:
            name = m_sub.group(3).strip()
            desc = ""
            m_inline = PATTERN_INLINE_RE.match(line)
            if m_inline:
                name = m_inline.group(3).strip()
                desc = m_inline.group(4).strip()
            current_pattern = {
                "id": f"{current_section['id']}-{m_sub.group(1)}-{m_sub.group(2)}",
                "num": f"{m_sub.group(1)}.{m_sub.group(2)}",
                "name": name.split(" Pattern:")[0].strip(),
                "description": desc or (name.split(" Pattern:", 1)[1].strip() if " Pattern:" in name else ""),
                "problems": [],
            }
            if " Pattern:" in name and not desc:
                parts = name.split(" Pattern:", 1)
                current_pattern["name"] = parts[0].strip()
                current_pattern["description"] = parts[1].strip()
            current_section["patterns"].append(current_pattern)
            continue

        m_pat = re.match(r"^Pattern:\s+(.+)$", line, re.I)
        if m_pat and current_pattern is not None:
            current_pattern["description"] = m_pat.group(1).strip()
            continue

        m_prob = PROBLEM_RE.match(line)
        if m_prob and current_pattern is not None:
            num = int(m_prob.group(1))
            title = m_prob.group(2).strip()
            diff = m_prob.group(3)
            current_pattern["problems"].append(
                {
                    "id": f"q{num}",
                    "num": num,
                    "title": title,
                    "difficulty": diff,
                    "leetcode": None,
                    "url": None,
                }
            )

    total = 0
    for sec in sections:
        for pat in sec["patterns"]:
            for p in pat["problems"]:
                total += 1

    return {
        "title": "DSA Questions + Patterns",
        "source": "DSA_Questions_and_Patterns_500.pdf",
        "totalProblems": total,
        "sections": sections,
    }


def main():
    if not PDF.exists():
        print(f"PDF not found: {PDF}", file=sys.stderr)
        sys.exit(1)
    data = parse(extract_text())
    OUT.parent.mkdir(parents=True, exist_ok=True)
    OUT.write_text(json.dumps(data, indent=2, ensure_ascii=False), encoding="utf-8")
    print(f"Wrote {data['totalProblems']} problems to {OUT}")


if __name__ == "__main__":
    main()
