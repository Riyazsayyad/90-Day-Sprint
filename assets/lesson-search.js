(function () {
  const MIN_QUERY = 2;
  const MAX_RESULTS = 12;
  const DEBOUNCE_MS = 120;

  let index = null;
  let loadPromise = null;
  let debounceTimer = null;
  let activeIndex = -1;

  function assetBase() {
    const path = window.location.pathname.replace(/\\/g, "/");
    if (path.includes("/lessons/") || path.includes("/exercises/") || path.includes("/reference/")) {
      return "../assets/";
    }
    return "assets/";
  }

  function loadIndex() {
    if (index) return Promise.resolve(index);
    if (loadPromise) return loadPromise;
    loadPromise = fetch(`${assetBase()}lesson-search-index.json`)
      .then((res) => {
        if (!res.ok) throw new Error(`Search index HTTP ${res.status}`);
        return res.json();
      })
      .then((data) => {
        index = data.lessons || [];
        return index;
      })
      .catch((err) => {
        console.error("Lesson search index failed to load:", err);
        index = [];
        return index;
      });
    return loadPromise;
  }

  function normalize(value) {
    return value.toLowerCase().trim();
  }

  function termsFromQuery(query) {
    return normalize(query).split(/\s+/).filter(Boolean);
  }

  function makeSnippet(text, query) {
    const haystack = text.toLowerCase();
    const needle = normalize(query);
    const hit = needle.length ? haystack.indexOf(needle.split(/\s+/)[0]) : -1;
    if (hit === -1) {
      return text.slice(0, 120) + (text.length > 120 ? "…" : "");
    }
    const start = Math.max(0, hit - 50);
    const end = Math.min(text.length, hit + needle.length + 70);
    let snippet = text.slice(start, end).trim();
    if (start > 0) snippet = "…" + snippet;
    if (end < text.length) snippet += "…";
    return snippet;
  }

  function scoreLesson(lesson, query, queryTerms) {
    const title = normalize(lesson.title);
    const moduleName = normalize(lesson.module);
    const body = normalize(lesson.text);
    const haystack = `${title} ${moduleName} ${body}`;

    let score = 0;
    if (title.includes(normalize(query))) score += 120;
    queryTerms.forEach((term) => {
      if (title.includes(term)) score += 30;
      if (moduleName.includes(term)) score += 12;
      if (body.includes(term)) score += 4;
    });
    return score;
  }

  function searchLessons(query) {
    if (!index) return [];
    const queryTerms = termsFromQuery(query);
    if (queryTerms.length === 0) return [];

    return index
      .map((lesson) => {
        const haystack = normalize(`${lesson.title} ${lesson.module} ${lesson.text}`);
        const matches = queryTerms.every((term) => haystack.includes(term));
        if (!matches) return null;
        return {
          lesson,
          score: scoreLesson(lesson, query, queryTerms),
          snippet: makeSnippet(lesson.text, query),
        };
      })
      .filter(Boolean)
      .sort((a, b) => b.score - a.score || a.lesson.title.localeCompare(b.lesson.title))
      .slice(0, MAX_RESULTS);
  }

  function highlightText(text, query) {
    const firstTerm = termsFromQuery(query)[0];
    if (!firstTerm) return escapeHtml(text);
    const re = new RegExp(`(${escapeRegExp(firstTerm)})`, "ig");
    return escapeHtml(text).replace(re, "<mark>$1</mark>");
  }

  function escapeHtml(value) {
    return value
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;");
  }

  function escapeRegExp(value) {
    return value.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
  }

  function renderResults(results, query, listEl) {
    listEl.innerHTML = "";
    activeIndex = -1;

    if (!query || query.trim().length < MIN_QUERY) {
      listEl.hidden = true;
      return;
    }

    if (!results.length) {
      listEl.innerHTML = `<p class="lesson-search-empty">No lessons match "<strong>${escapeHtml(query.trim())}</strong>"</p>`;
      listEl.hidden = false;
      return;
    }

    const frag = document.createDocumentFragment();
    results.forEach((result, idx) => {
      const { lesson, snippet } = result;
      const item = document.createElement("a");
      item.href = lesson.href;
      item.className = "lesson-search-item";
      item.role = "option";
      item.id = `lesson-search-option-${idx}`;
      item.dataset.index = String(idx);
      item.innerHTML = `
        <span class="lesson-search-item-title">${highlightText(lesson.title, query)}</span>
        <span class="lesson-search-item-meta">M${lesson.moduleNum} · ${escapeHtml(lesson.module)}${lesson.kind === "exercise" ? " · Exercise" : ""}</span>
        <span class="lesson-search-item-snippet">${highlightText(snippet, query)}</span>
      `;
      frag.appendChild(item);
    });
    listEl.appendChild(frag);
    listEl.hidden = false;
  }

  function setActiveItem(listEl, nextIndex) {
    const items = [...listEl.querySelectorAll(".lesson-search-item")];
    if (!items.length) {
      activeIndex = -1;
      return;
    }
    activeIndex = Math.max(0, Math.min(nextIndex, items.length - 1));
    items.forEach((item, idx) => {
      item.classList.toggle("is-active", idx === activeIndex);
      if (idx === activeIndex) item.setAttribute("aria-selected", "true");
      else item.removeAttribute("aria-selected");
    });
    items[activeIndex].scrollIntoView({ block: "nearest" });
  }

  function initRoot(root) {
    const input = root.querySelector(".lesson-search-input");
    const listEl = root.querySelector(".lesson-search-results");
    if (!input || !listEl) return;

    const runSearch = () => {
      const query = input.value;
      if (query.trim().length < MIN_QUERY) {
        listEl.hidden = true;
        listEl.innerHTML = "";
        input.setAttribute("aria-expanded", "false");
        return;
      }
      const results = searchLessons(query);
      renderResults(results, query, listEl);
      input.setAttribute("aria-expanded", String(!listEl.hidden));
    };

    input.addEventListener("input", () => {
      clearTimeout(debounceTimer);
      debounceTimer = setTimeout(runSearch, DEBOUNCE_MS);
    });

    input.addEventListener("focus", () => {
      if (input.value.trim().length >= MIN_QUERY) runSearch();
    });

    input.addEventListener("keydown", (event) => {
      const items = [...listEl.querySelectorAll(".lesson-search-item")];
      if (event.key === "ArrowDown") {
        event.preventDefault();
        if (listEl.hidden) runSearch();
        setActiveItem(listEl, activeIndex + 1);
      } else if (event.key === "ArrowUp") {
        event.preventDefault();
        setActiveItem(listEl, activeIndex - 1);
      } else if (event.key === "Enter" && activeIndex >= 0 && items[activeIndex]) {
        event.preventDefault();
        items[activeIndex].click();
      } else if (event.key === "Escape") {
        listEl.hidden = true;
        input.setAttribute("aria-expanded", "false");
        input.blur();
      }
    });

    document.addEventListener("click", (event) => {
      if (!root.contains(event.target)) {
        listEl.hidden = true;
        input.setAttribute("aria-expanded", "false");
      }
    });

    document.addEventListener("keydown", (event) => {
      if (event.key === "/" && !isTypingTarget(event.target)) {
        event.preventDefault();
        input.focus();
      }
    });
  }

  function isTypingTarget(target) {
    if (!(target instanceof HTMLElement)) return false;
    const tag = target.tagName;
    return tag === "INPUT" || tag === "TEXTAREA" || tag === "SELECT" || target.isContentEditable;
  }

  function init() {
    loadIndex().then(() => {
      document.querySelectorAll("[data-lesson-search]").forEach(initRoot);
    });
  }

  if (document.readyState === "loading") {
    document.addEventListener("DOMContentLoaded", init);
  } else {
    init();
  }
})();
