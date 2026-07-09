(function() {
  const lessons = [
    { num: '01', file: '0001-what-is-a-functional-interface.html', title: 'What Is a Functional Interface?', meta: '5 min read &bull; Core Java' },
    { num: '02', file: '0002-lambda-expressions.html', title: 'Lambda Expressions', meta: '6 min read &bull; Functional Java' },
    { num: '03', file: '0003-predicate-function-consumer-supplier.html', title: 'Predicate, Function, Consumer, & Supplier', meta: '8 min read &bull; Utility interfaces' },
    { num: '04', file: '0004-hashmap-buckets-and-put.html', title: 'HashMap Internals: Buckets & put()', meta: '10 min read &bull; Map Structures' },
    { num: '05', file: '0005-resize-and-load-factor.html', title: 'HashMap Internals: Resize & Load Factor', meta: '7 min read &bull; Scaling Maps' },
    { num: '06', file: '0006-hashmap-treeify.html', title: 'HashMap Internals: Treeify Threshold', meta: '8 min read &bull; Red-Black Trees' },
    { num: '07', file: '0007-arraylist-internals.html', title: 'ArrayList Internals & Resizing', meta: '12 min read &bull; Lists' },
    { num: '08', file: '0008-linkedlist-internals.html', title: 'LinkedList Internals & Deque', meta: '10 min read &bull; Lists & Queues' },
    { num: '09', file: '0009-hashset-internals.html', title: 'HashSet Internals & HashMap Backing', meta: '6 min read &bull; Sets' },
    { num: '10', file: '0010-treeset-internals.html', title: 'TreeSet Internals & Red-Black Tree', meta: '11 min read &bull; Sorted Sets' },
    { num: '11', file: '0011-priorityqueue-internals.html', title: 'PriorityQueue Internals & Binary Heap', meta: '14 min read &bull; Heaps' },
    { num: '12', file: '0012-comparable-vs-comparator.html', title: 'Comparable vs. Comparator', meta: '6 min read &bull; Sorting Contracts' },
    { num: '13', file: '0013-collections-utility.html', title: 'The Collections Utility Class', meta: '6 min read &bull; Static Utilities' },
    { num: '14', file: '0014-java-iterator.html', title: 'Java Iterator Internals', meta: '8 min read &bull; Traversals' },
    { num: '15', file: '0015-java-listiterator.html', title: 'Java ListIterator Internals', meta: '8 min read &bull; Traversals' },
    { num: '16', file: '0016-failfast-failsafe.html', title: 'Fail-Fast vs. Fail-Safe Iteration', meta: '8 min read &bull; Traversals' }
  ];

  function init() {
    // Prevent double initialization
    if (document.getElementById('lessonTray')) return;

    // Detect current file from URL
    const pathParts = window.location.pathname.split('/');
    let currentFile = pathParts[pathParts.length - 1] || '0001-what-is-a-functional-interface.html';

    // 1. Create and inject backdrop
    const backdrop = document.createElement('div');
    backdrop.className = 'lesson-tray-backdrop';
    backdrop.id = 'lessonTrayBackdrop';
    document.body.appendChild(backdrop);

    // 2. Create and inject toggle button
    const toggleBtn = document.createElement('button');
    toggleBtn.className = 'lesson-tray-toggle';
    toggleBtn.id = 'lessonTrayToggle';
    toggleBtn.setAttribute('aria-label', 'Open curriculum tray');
    toggleBtn.innerHTML = `
      <svg viewBox="0 0 24 24" width="16" height="16" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
        <line x1="3" y1="12" x2="21" y2="12"></line>
        <line x1="3" y1="6" x2="21" y2="6"></line>
        <line x1="3" y1="18" x2="21" y2="18"></line>
      </svg>
      <span>Lessons</span>
    `;
    document.body.appendChild(toggleBtn);

    // 3. Create and inject tray container
    const tray = document.createElement('div');
    tray.className = 'lesson-tray';
    tray.id = 'lessonTray';

    // Header structure
    const header = document.createElement('div');
    header.className = 'lesson-tray-header';
    header.innerHTML = `
      <div class="lesson-tray-title-group">
        <h2>Collections Internals</h2>
        <p>Module 1 &bull; 16 Lessons</p>
      </div>
      <button class="lesson-tray-close" id="lessonTrayClose" aria-label="Close tray">
        <svg viewBox="0 0 24 24">
          <path d="M18 6L6 18M6 6l12 12" stroke-linecap="round" stroke-linejoin="round"/>
        </svg>
      </button>
    `;
    tray.appendChild(header);

    // Content container
    const content = document.createElement('div');
    content.className = 'lesson-tray-content';
    
    const list = document.createElement('ul');
    list.className = 'lesson-tray-list';

    // Build the list items
    let activeItem = null;
    lessons.forEach(lesson => {
      const li = document.createElement('li');
      const isActive = currentFile === lesson.file;
      
      const link = document.createElement('a');
      link.href = lesson.file;
      link.className = 'lesson-tray-item' + (isActive ? ' active' : '');
      link.innerHTML = `
        <span class="lesson-tray-num">${lesson.num}</span>
        <div class="lesson-tray-info">
          <span class="lesson-tray-item-title">${lesson.title}</span>
          <span class="lesson-tray-item-meta">${lesson.meta}</span>
        </div>
      `;

      if (isActive) {
        activeItem = link;
      }

      li.appendChild(link);
      list.appendChild(li);
    });

    content.appendChild(list);
    tray.appendChild(content);
    document.body.appendChild(tray);

    // 4. Attach Event Listeners
    const openTray = () => {
      tray.classList.add('open');
      backdrop.classList.add('open');
      document.body.classList.add('lesson-tray-open');
      
      // Auto-scroll active item into view when drawer opens
      if (activeItem) {
        setTimeout(() => {
          activeItem.scrollIntoView({ behavior: 'smooth', block: 'nearest' });
        }, 100);
      }
    };

    const closeTray = () => {
      tray.classList.remove('open');
      backdrop.classList.remove('open');
      document.body.classList.remove('lesson-tray-open');
    };

    toggleBtn.addEventListener('click', openTray);
    
    const closeBtn = document.getElementById('lessonTrayClose');
    if (closeBtn) closeBtn.addEventListener('click', closeTray);
    backdrop.addEventListener('click', closeTray);

    // Close on ESC key
    window.addEventListener('keydown', (e) => {
      if (e.key === 'Escape' || e.key === 'Esc') {
        closeTray();
      }
    });
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }
})();
