document.addEventListener('DOMContentLoaded', () => {
  // Animate global progress bar
  const progressFill = document.getElementById('progressFill');
  if (progressFill) {
    // 5 of 11 modules = 45.5%
    setTimeout(() => {
      progressFill.style.width = '45.5%';
    }, 200);
  }

  // Drawer Elements for Collections (Module 1)
  const collectionsCard = document.getElementById('collectionsCard');
  const drawer = document.getElementById('lessonDrawer');
  const backdrop = document.getElementById('drawerBackdrop');
  const closeBtn = document.getElementById('closeDrawerBtn');

  // Drawer Elements for OOP (Module 0)
  const oopCard = document.getElementById('oopCard');
  const oopDrawer = document.getElementById('oopDrawer');
  const closeOopBtn = document.getElementById('closeOopDrawerBtn');

  // Drawer Elements for Streams (Module 2)
  const streamsCard = document.getElementById('streamsCard');
  const streamsDrawer = document.getElementById('streamsDrawer');
  const closeStreamsBtn = document.getElementById('closeStreamsDrawerBtn');

  // Drawer Elements for Concurrency (Module 3)
  const concurrencyCard = document.getElementById('concurrencyCard');
  const concurrencyDrawer = document.getElementById('concurrencyDrawer');
  const closeConcurrencyBtn = document.getElementById('closeConcurrencyDrawerBtn');

  // Drawer Elements for JVM (Module 4)
  const jvmCard = document.getElementById('jvmCard');
  const jvmDrawer = document.getElementById('jvmDrawer');
  const closeJvmBtn = document.getElementById('closeJvmDrawerBtn');

  // Open / Close Drawer Functions for Collections
  const openDrawer = () => {
    drawer.classList.add('open');
    backdrop.classList.add('open');
    document.body.style.overflow = 'hidden';
  };

  const closeDrawer = () => {
    drawer.classList.remove('open');
    backdrop.classList.remove('open');
    document.body.style.overflow = '';
  };

  // Open / Close Drawer Functions for OOP
  const openOopDrawer = () => {
    if (oopDrawer) oopDrawer.classList.add('open');
    if (backdrop) backdrop.classList.add('open');
    document.body.style.overflow = 'hidden';
  };

  const closeOopDrawer = () => {
    if (oopDrawer) oopDrawer.classList.remove('open');
    if (backdrop) backdrop.classList.remove('open');
    document.body.style.overflow = '';
  };

  // Open / Close Drawer Functions for Streams
  const openStreamsDrawer = () => {
    if (streamsDrawer) streamsDrawer.classList.add('open');
    if (backdrop) backdrop.classList.add('open');
    document.body.style.overflow = 'hidden';
  };

  const closeStreamsDrawer = () => {
    if (streamsDrawer) streamsDrawer.classList.remove('open');
    if (backdrop) backdrop.classList.remove('open');
    document.body.style.overflow = '';
  };

  const openConcurrencyDrawer = () => {
    if (concurrencyDrawer) concurrencyDrawer.classList.add('open');
    if (backdrop) backdrop.classList.add('open');
    document.body.style.overflow = 'hidden';
  };

  const closeConcurrencyDrawer = () => {
    if (concurrencyDrawer) concurrencyDrawer.classList.remove('open');
    if (backdrop) backdrop.classList.remove('open');
    document.body.style.overflow = '';
  };

  const openJvmDrawer = () => {
    if (jvmDrawer) jvmDrawer.classList.add('open');
    if (backdrop) backdrop.classList.add('open');
    document.body.style.overflow = 'hidden';
  };

  const closeJvmDrawer = () => {
    if (jvmDrawer) jvmDrawer.classList.remove('open');
    if (backdrop) backdrop.classList.remove('open');
    document.body.style.overflow = '';
  };

  const closeAllDrawers = () => {
    closeDrawer();
    closeOopDrawer();
    closeStreamsDrawer();
    closeConcurrencyDrawer();
    closeJvmDrawer();
  };

  // Click active cards to open
  if (collectionsCard) {
    collectionsCard.addEventListener('click', (e) => {
      if (e.target.closest('a')) return;
      openDrawer();
    });
  }

  if (oopCard) {
    oopCard.addEventListener('click', (e) => {
      if (e.target.closest('a')) return;
      openOopDrawer();
    });
  }

  if (streamsCard) {
    streamsCard.addEventListener('click', (e) => {
      if (e.target.closest('a')) return;
      openStreamsDrawer();
    });
  }

  if (concurrencyCard) {
    concurrencyCard.addEventListener('click', (e) => {
      if (e.target.closest('a')) return;
      openConcurrencyDrawer();
    });
  }

  if (jvmCard) {
    jvmCard.addEventListener('click', (e) => {
      if (e.target.closest('a')) return;
      openJvmDrawer();
    });
  }

  // Close triggers
  if (closeBtn) closeBtn.addEventListener('click', closeDrawer);
  if (closeOopBtn) closeOopBtn.addEventListener('click', closeOopDrawer);
  if (closeStreamsBtn) closeStreamsBtn.addEventListener('click', closeStreamsDrawer);
  if (closeConcurrencyBtn) closeConcurrencyBtn.addEventListener('click', closeConcurrencyDrawer);
  if (closeJvmBtn) closeJvmBtn.addEventListener('click', closeJvmDrawer);
  if (backdrop) backdrop.addEventListener('click', closeAllDrawers);

  // Esc key listener to close drawer
  window.addEventListener('keydown', (e) => {
    if (e.key === 'Escape' || e.key === 'Esc') {
      closeAllDrawers();
    }
  });

  // Toast System for Locked Modules
  const lockedCards = document.querySelectorAll('.module-card.locked');
  const toast = document.getElementById('toast');
  const toastText = document.getElementById('toastText');
  let toastTimeout;

  const showToast = (message) => {
    if (!toast || !toastText) return;
    
    // Clear any active timeout
    clearTimeout(toastTimeout);
    
    toastText.textContent = message;
    toast.classList.add('show');
    
    toastTimeout = setTimeout(() => {
      toast.classList.remove('show');
    }, 3500);
  };

  // Attach click listeners to locked cards
  lockedCards.forEach(card => {
    card.addEventListener('click', () => {
      const titleEl = card.querySelector('.card-title');
      const moduleTitle = titleEl ? titleEl.textContent : 'Upcoming Module';
      showToast(`"${moduleTitle}" will unlock as you progress. Stay focused on your active modules!`);
    });
  });
});
