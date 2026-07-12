document.addEventListener('DOMContentLoaded', () => {
  // Animate global progress bar
  const progressFill = document.getElementById('progressFill');
  if (progressFill) {
    // 1 of 11 modules = 9.1%
    setTimeout(() => {
      progressFill.style.width = '9.1%';
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

  const closeAllDrawers = () => {
    closeDrawer();
    closeOopDrawer();
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

  // Close triggers
  if (closeBtn) closeBtn.addEventListener('click', closeDrawer);
  if (closeOopBtn) closeOopBtn.addEventListener('click', closeOopDrawer);
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
