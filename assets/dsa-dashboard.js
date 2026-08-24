/**
 * DSA 500 progress — home mini-bar + full page list (dsa.html).
 */
(function () {
  const CURRICULUM_URL = 'assets/dsa-curriculum.json';
  const PROGRESS_URL = 'assets/dsa-progress.json';

  const DIFF_CLASS = {
    Easy: 'diff-easy',
    Medium: 'diff-medium',
    Hard: 'diff-hard',
  };

  function isExactLeetcodeUrl(url) {
    return Boolean(url && url.includes('leetcode.com/problems/'));
  }

  const LC_ICON_SVG = `<svg class="dsa-lc-icon-svg" viewBox="0 0 24 24" width="16" height="16" fill="none" stroke="currentColor" stroke-width="2" aria-hidden="true"><path d="M18 13v6a2 2 0 01-2 2H5a2 2 0 01-2-2V8a2 2 0 012-2h6M15 3h6v6M10 14L21 3" stroke-linecap="round" stroke-linejoin="round"/></svg>`;

  let curriculum = null;
  let completedSet = new Set();

  async function loadData() {
    const [curRes, progRes] = await Promise.all([
      fetch(CURRICULUM_URL),
      fetch(PROGRESS_URL),
    ]);
    if (!curRes.ok) throw new Error('Could not load DSA curriculum');
    curriculum = await curRes.json();
    const progress = progRes.ok ? await progRes.json() : { completed: [] };
    completedSet = new Set(progress.completed || []);
  }

  function stats() {
    let total = 0;
    let done = 0;

    for (const section of curriculum.sections) {
      for (const pattern of section.patterns) {
        for (const p of pattern.problems) {
          total += 1;
          if (completedSet.has(p.id)) done += 1;
        }
      }
    }

    const pct = total ? (done / total) * 100 : 0;
    return { total, done, pct };
  }

  function updateHeader() {
    const { total, done, pct } = stats();
    const fill = document.getElementById('dsaProgressFill');
    const percentEl = document.getElementById('dsaProgressPercent');
    const subLeft = document.getElementById('dsaProgressSubLeft');
    const subRight = document.getElementById('dsaProgressSubRight');
    const panelCount = document.getElementById('dsaPanelCount');

    if (percentEl) percentEl.textContent = `${pct.toFixed(1)}% Complete`;
    if (subLeft) subLeft.textContent = `${done} Solved`;
    if (subRight) subRight.textContent = `${curriculum.sections.length} Topics • ${total} Problems`;
    if (panelCount) panelCount.textContent = `${done} / ${total} solved`;
    if (fill) {
      requestAnimationFrame(() => {
        setTimeout(() => {
          fill.style.width = `${pct}%`;
        }, 250);
      });
    }
  }

  function renderPanel() {
    const body = document.getElementById('dsaPanelBody');
    if (!body || !curriculum) return;
    body.innerHTML = '';

    for (const section of curriculum.sections) {
      const secDone = section.patterns.reduce(
        (n, pat) => n + pat.problems.filter((p) => completedSet.has(p.id)).length,
        0
      );
      const secTotal = section.patterns.reduce((n, pat) => n + pat.problems.length, 0);

      const secEl = document.createElement('details');
      secEl.className = 'dsa-section';
      secEl.innerHTML = `
        <summary class="dsa-section-summary">
          <span class="dsa-section-title">Section ${section.num}: ${section.name}</span>
          <span class="dsa-section-meta">Q${section.qStart}–Q${section.qEnd} · ${secDone}/${secTotal}</span>
        </summary>
        <div class="dsa-section-body"></div>
      `;

      const secBody = secEl.querySelector('.dsa-section-body');

      for (const pattern of section.patterns) {
        const patDone = pattern.problems.filter((p) => completedSet.has(p.id)).length;
        const patTotal = pattern.problems.length;

        const patEl = document.createElement('details');
        patEl.className = 'dsa-pattern';
        patEl.innerHTML = `
          <summary class="dsa-pattern-summary">
            <span class="dsa-pattern-title">${pattern.num} ${pattern.name}</span>
            <span class="dsa-pattern-meta">${patDone}/${patTotal}</span>
          </summary>
          <div class="dsa-pattern-body">
            ${pattern.description ? `<p class="dsa-pattern-desc">${pattern.description}</p>` : ''}
            <ul class="dsa-problem-list"></ul>
          </div>
        `;

        const list = patEl.querySelector('.dsa-problem-list');
        for (const problem of pattern.problems) {
          const isDone = completedSet.has(problem.id);
          const li = document.createElement('li');
          li.className = `dsa-problem${isDone ? ' done' : ''}`;
          const diffClass = DIFF_CLASS[problem.difficulty] || 'diff-medium';
          const lcLink = isExactLeetcodeUrl(problem.url)
            ? `<a href="${problem.url}" target="_blank" rel="noopener noreferrer" class="dsa-lc-icon" title="Open on LeetCode" aria-label="Open ${problem.title} on LeetCode">${LC_ICON_SVG}</a>`
            : '';
          li.innerHTML = `
            <span class="dsa-problem-check" aria-hidden="true">${isDone ? '✓' : '○'}</span>
            <span class="dsa-problem-num">Q${problem.num}</span>
            <span class="dsa-problem-title">${problem.title}</span>
            ${lcLink}
            <span class="dsa-diff ${diffClass}">${problem.difficulty}</span>
          `;
          list.appendChild(li);
        }

        secBody.appendChild(patEl);
      }

      body.appendChild(secEl);
    }
  }

  async function init() {
    const mode = document.body.dataset.dsaMode || 'home';
    const box = document.getElementById('dsaProgressBox');
    if (!box && mode === 'home') return;

    try {
      await loadData();
      updateHeader();
      if (mode === 'page') renderPanel();
    } catch (err) {
      console.error(err);
      const percentEl = document.getElementById('dsaProgressPercent');
      if (percentEl) percentEl.textContent = 'Unavailable';
    }
  }

  document.addEventListener('DOMContentLoaded', init);
})();
