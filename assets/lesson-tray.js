(function() {
  const lessons = [
    // Module 00: Core Java & OOP
    { num: '01', file: 'oop-0001-why-object-oriented-programming.html', title: 'Why Object-Oriented Programming?', meta: '10 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '02', file: 'oop-0002-class-vs-object.html', title: 'Class vs. Object', meta: '10 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '03', file: 'oop-0003-stack-vs-heap.html', title: 'Stack vs. Heap Memory Layout', meta: '10 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '04', file: 'oop-0004-constructors.html', title: 'Constructors in Java', meta: '10 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '05', file: 'oop-0005-object-lifecycle.html', title: 'Object Lifecycle in Java', meta: '10 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '06', file: 'oop-0006-encapsulation.html', title: 'Encapsulation in Java', meta: '12 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '07', file: 'oop-0007-inheritance.html', title: 'Inheritance in Java', meta: '12 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '08', file: 'oop-0008-polymorphism.html', title: 'Polymorphism in Java', meta: '12 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '09', file: 'oop-0009-abstraction.html', title: 'Abstraction in Java', meta: '12 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '10', file: 'oop-0010-object-class.html', title: 'java.lang.Object Root Class', meta: '15 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '11', file: 'oop-0011-equals-hashcode.html', title: 'equals() & hashCode() Contracts', meta: '25 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '12', file: 'oop-0012-to-string.html', title: 'toString() Invariants & Security', meta: '20 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '13', file: 'oop-0013-this-super.html', title: 'this & super Keywords', meta: '25 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '14', file: 'oop-0014-static.html', title: 'The static Keyword', meta: '30 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    { num: '15', file: 'oop-0015-final.html', title: 'The final Keyword', meta: '35 min read &bull; OOP Basics', module: 'Core Java & OOP', moduleNum: '00' },
    
    
    // Module 01: Collections Internals
    { num: '01', file: '0001-what-is-a-functional-interface.html', title: 'What Is a Functional Interface?', meta: '5 min read &bull; Core Java', module: 'Collections Internals', moduleNum: '01' },
    { num: '02', file: '0002-lambda-expressions.html', title: 'Lambda Expressions', meta: '6 min read &bull; Functional Java', module: 'Collections Internals', moduleNum: '01' },
    { num: '03', file: '0003-predicate-function-consumer-supplier.html', title: 'Predicate, Function, Consumer, & Supplier', meta: '8 min read &bull; Utility interfaces', module: 'Collections Internals', moduleNum: '01' },
    { num: '04', file: '0004-hashmap-buckets-and-put.html', title: 'HashMap Internals: Buckets & put()', meta: '10 min read &bull; Map Structures', module: 'Collections Internals', moduleNum: '01' },
    { num: '05', file: '0005-resize-and-load-factor.html', title: 'HashMap Internals: Resize & Load Factor', meta: '7 min read &bull; Scaling Maps', module: 'Collections Internals', moduleNum: '01' },
    { num: '06', file: '0006-hashmap-treeify.html', title: 'HashMap Internals: Treeify Threshold', meta: '8 min read &bull; Red-Black Trees', module: 'Collections Internals', moduleNum: '01' },
    { num: '07', file: '0007-arraylist-internals.html', title: 'ArrayList Internals & Resizing', meta: '12 min read &bull; Lists', module: 'Collections Internals', moduleNum: '01' },
    { num: '08', file: '0008-linkedlist-internals.html', title: 'LinkedList Internals & Deque', meta: '10 min read &bull; Lists & Queues', module: 'Collections Internals', moduleNum: '01' },
    { num: '09', file: '0009-hashset-internals.html', title: 'HashSet Internals & HashMap Backing', meta: '6 min read &bull; Sets', module: 'Collections Internals', moduleNum: '01' },
    { num: '10', file: '0010-treeset-internals.html', title: 'TreeSet Internals & Red-Black Tree', meta: '11 min read &bull; Sorted Sets', module: 'Collections Internals', moduleNum: '01' },
    { num: '11', file: '0011-priorityqueue-internals.html', title: 'PriorityQueue Internals & Binary Heap', meta: '14 min read &bull; Heaps', module: 'Collections Internals', moduleNum: '01' },
    { num: '12', file: '0012-comparable-vs-comparator.html', title: 'Comparable vs. Comparator', meta: '6 min read &bull; Sorting Contracts', module: 'Collections Internals', moduleNum: '01' },
    { num: '13', file: '0013-collections-utility.html', title: 'The Collections Utility Class', meta: '6 min read &bull; Static Utilities', module: 'Collections Internals', moduleNum: '01' },
    { num: '14', file: '0014-java-iterator.html', title: 'Java Iterator Internals', meta: '8 min read &bull; Traversals', module: 'Collections Internals', moduleNum: '01' },
    { num: '15', file: '0015-java-listiterator.html', title: 'Java ListIterator Internals', meta: '8 min read &bull; Traversals', module: 'Collections Internals', moduleNum: '01' },
    { num: '16', file: '0016-failfast-failsafe.html', title: 'Fail-Fast vs. Fail-Safe Iteration', meta: '8 min read &bull; Traversals', module: 'Collections Internals', moduleNum: '01' },

    // Module 02: Streams API
    { num: '01', file: 'streams-0001-stream-fundamentals.html', title: 'Stream Fundamentals', meta: '25 min read &bull; Streams API', module: 'Streams API', moduleNum: '02' },
    { num: '02', file: 'streams-0002-intermediate-operations.html', title: 'Intermediate Operations', meta: '15 min read &bull; Streams API', module: 'Streams API', moduleNum: '02' },
    { num: '03', file: 'streams-0003-terminal-operations.html', title: 'Terminal Operations', meta: '15 min read &bull; Streams API', module: 'Streams API', moduleNum: '02' },
    { num: '04', file: 'streams-0004-collectors-deep-dive.html', title: 'Collectors Deep Dive', meta: '20 min read &bull; Streams API', module: 'Streams API', moduleNum: '02' },
    { num: '05', file: 'streams-0005-parallel-streams.html', title: 'Parallel Streams', meta: '20 min read &bull; Streams API', module: 'Streams API', moduleNum: '02' },
    { num: '06', file: 'streams-0006-stream-internals.html', title: 'Stream Internals', meta: '25 min read &bull; Streams API', module: 'Streams API', moduleNum: '02' },
    { num: 'Ex', file: 'streams-capstone-exercise.html', title: 'Capstone Exercise', meta: '18 scenarios &bull; Coding', module: 'Streams API', moduleNum: '02', kind: 'exercise' },

    // Module 03: Concurrency & Threads
    { num: '01', file: 'concurrency-0001-thread-fundamentals.html', title: 'Thread Fundamentals & Lifecycle', meta: '25 min read &bull; Concurrency', module: 'Concurrency & Threads', moduleNum: '03' },
    { num: '02', file: 'concurrency-0002-synchronization-monitors.html', title: 'Synchronization & Monitors', meta: '28 min read &bull; Concurrency', module: 'Concurrency & Threads', moduleNum: '03' },
    { num: '03', file: 'concurrency-0003-volatile-java-memory-model.html', title: 'volatile & Java Memory Model', meta: '30 min read &bull; Concurrency', module: 'Concurrency & Threads', moduleNum: '03' },
    { num: '04', file: 'concurrency-0004-explicit-locks.html', title: 'Explicit Locks', meta: '35 min read &bull; Concurrency', module: 'Concurrency & Threads', moduleNum: '03' },
    { num: '05', file: 'concurrency-0005-executors.html', title: 'Executors & Thread Pools', meta: '40 min read &bull; Concurrency', module: 'Concurrency & Threads', moduleNum: '03' },
    { num: '06', file: 'concurrency-0006-concurrent-collections-atomics.html', title: 'Concurrent Collections & Atomics', meta: '38 min read &bull; Concurrency', module: 'Concurrency & Threads', moduleNum: '03' },
    { num: '07', file: 'concurrency-0007-completable-future.html', title: 'CompletableFuture', meta: '40 min read &bull; Concurrency', module: 'Concurrency & Threads', moduleNum: '03' },
    { num: '08', file: 'concurrency-0008-virtual-threads.html', title: 'Virtual Threads', meta: '35 min read &bull; Concurrency', module: 'Concurrency & Threads', moduleNum: '03' },
    { num: 'Ex', file: 'concurrency-capstone-exercise.html', title: 'Capstone Exercise', meta: '16 scenarios &bull; Coding', module: 'Concurrency & Threads', moduleNum: '03', kind: 'exercise' },

    // Module 04: JVM & Memory Management
    { num: '01', file: 'jvm-0001-jvm-runtime-architecture.html', title: 'JVM Runtime Architecture & Memory Areas', meta: '30 min read &bull; JVM & Memory', module: 'JVM & Memory Management', moduleNum: '04' },
    { num: '02', file: 'jvm-0002-heap-regions-tlab-object-layout.html', title: 'Heap Regions, TLAB & Object Layout', meta: '35 min read &bull; JVM & Memory', module: 'JVM & Memory Management', moduleNum: '04' },
    { num: '03', file: 'jvm-0003-garbage-collection-fundamentals.html', title: 'Garbage Collection Fundamentals', meta: '35 min read &bull; JVM & Memory', module: 'JVM & Memory Management', moduleNum: '04' },
    { num: '04', file: 'jvm-0004-garbage-collectors-selection.html', title: 'Garbage Collectors & Selection', meta: '35 min read &bull; JVM & Memory', module: 'JVM & Memory Management', moduleNum: '04' },
    { num: '05', file: 'jvm-0005-jvm-flags-gc-logging-tuning.html', title: 'JVM Flags, GC Logging & Tuning', meta: '35 min read &bull; JVM & Memory', module: 'JVM & Memory Management', moduleNum: '04' },
    { num: '06', file: 'jvm-0006-class-loading-metaspace-classloader-leaks.html', title: 'Class Loading, Metaspace & Classloader Leaks', meta: '35 min read &bull; JVM & Memory', module: 'JVM & Memory Management', moduleNum: '04' },
    { num: '07', file: 'jvm-0007-jit-compilation-runtime-optimizations.html', title: 'JIT Compilation & Runtime Optimizations', meta: '35 min read &bull; JVM & Memory', module: 'JVM & Memory Management', moduleNum: '04' },
    { num: '08', file: 'jvm-0008-diagnostics-profiling-memory-leaks.html', title: 'Diagnostics, Profiling & Memory Leaks', meta: '40 min read &bull; JVM & Memory', module: 'JVM & Memory Management', moduleNum: '04' },
    { num: 'Ex', file: 'jvm-capstone-exercise.html', title: 'Capstone Exercise', meta: '16 scenarios &bull; Coding', module: 'JVM & Memory Management', moduleNum: '04', kind: 'exercise' }
  ];


  function init() {
    // Prevent double initialization
    if (document.getElementById('lessonTray')) return;

    // Detect current file from URL
    const pathParts = window.location.pathname.split('/');
    let currentFile = pathParts[pathParts.length - 1] || 'oop-0001-why-object-oriented-programming.html';

    // Find the active lesson object to identify its module
    const activeLesson = lessons.find(l => l.file === currentFile || currentFile.endsWith('/' + l.file)) || lessons[0];
    const currentModule = activeLesson.module;
    const currentModuleNum = activeLesson.moduleNum;

    // Filter lessons belonging to the active module
    const moduleLessons = lessons.filter(l => l.module === currentModule);

    const lessonCount = moduleLessons.filter(l => l.kind !== 'exercise').length;
    const exerciseCount = moduleLessons.filter(l => l.kind === 'exercise').length;
    const countLabel = exerciseCount > 0
      ? `${lessonCount} Lessons &bull; ${exerciseCount} Exercise`
      : `${moduleLessons.length} ${moduleLessons.length === 1 ? 'Lesson' : 'Lessons'}`;

    // Detect page context for correct relative links
    const inExercises = window.location.pathname.includes('/exercises/');

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
        <h2>${currentModule}</h2>
        <p>Module ${currentModuleNum} &bull; ${countLabel}</p>
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
    moduleLessons.forEach(lesson => {
      const li = document.createElement('li');
      const lessonHref = lesson.kind === 'exercise'
        ? (inExercises ? lesson.file : '../exercises/' + lesson.file)
        : (inExercises ? '../lessons/' + lesson.file : lesson.file);
      const isActive = currentFile === lesson.file || currentFile.endsWith('/' + lesson.file);
      
      const link = document.createElement('a');
      link.href = lessonHref;
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

    // 5. Create and inject scroll-up button
    const scrollUpBtn = document.createElement('button');
    scrollUpBtn.className = 'scroll-up-btn';
    scrollUpBtn.id = 'scrollUpBtn';
    scrollUpBtn.setAttribute('aria-label', 'Scroll to top');
    scrollUpBtn.innerHTML = `
      <svg viewBox="0 0 24 24" width="20" height="20" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round">
        <polyline points="18 15 12 9 6 15"></polyline>
      </svg>
    `;
    document.body.appendChild(scrollUpBtn);

    const handleScroll = () => {
      const scrollTop = window.scrollY || window.pageYOffset || document.documentElement.scrollTop;
      if (scrollTop > 300) {
        scrollUpBtn.classList.add('visible');
      } else {
        scrollUpBtn.classList.remove('visible');
      }
    };

    window.addEventListener('scroll', handleScroll);

    scrollUpBtn.addEventListener('click', () => {
      window.scrollTo({ top: 0, behavior: 'smooth' });
    });

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
