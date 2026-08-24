"""Inject theme-init.js and theme.js into all site HTML pages."""
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
INIT_SNIPPETS = [
    '<script src="assets/theme-init.js"></script>',
    '<script src="../assets/theme-init.js"></script>',
]
THEME_JS_SNIPPETS = [
    '<script src="assets/theme.js" defer></script>',
    '<script src="../assets/theme.js" defer></script>',
]


def asset_prefix(content: str) -> str:
    if 'href="../assets/' in content or 'src="../assets/' in content:
        return "../assets"
    return "assets"


def inject_file(path: Path) -> bool:
    text = path.read_text(encoding="utf-8")
    if "theme-init.js" in text and "theme.js" in text:
        return False

    prefix = asset_prefix(text)
    init_line = f'<script src="{prefix}/theme-init.js"></script>'
    theme_line = f'<script src="{prefix}/theme.js" defer></script>'
    changed = False

    if "theme-init.js" not in text:
        if "<head>" in text:
            text = text.replace("<head>", f"<head>\n  {init_line}", 1)
            changed = True

    if "theme.js" not in text:
        if "</body>" in text:
            text = text.replace("</body>", f"  {theme_line}\n</body>", 1)
            changed = True

    if changed:
        path.write_text(text, encoding="utf-8")
    return changed


def main():
    count = 0
    for html in ROOT.rglob("*.html"):
        if inject_file(html):
            count += 1
            print("updated", html.relative_to(ROOT))
    print(f"Done — {count} files updated")


if __name__ == "__main__":
    main()
