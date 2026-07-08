document.addEventListener('DOMContentLoaded', () => {
  // Animate global progress bar
  const progressFill = document.getElementById('progressFill');
  if (progressFill) {
    // 1 of 8 modules = 12.5%
    setTimeout(() => {
      progressFill.style.width = '12.5%';
    }, 200);
  }

  // Drawer Elements
  const collectionsCard = document.getElementById('collectionsCard');
  const drawer = document.getElementById('lessonDrawer');
  const backdrop = document.getElementById('drawerBackdrop');
  const closeBtn = document.getElementById('closeDrawerBtn');

  // Open Drawer Function
  const openDrawer = () => {
    drawer.classList.add('open');
    backdrop.classList.add('open');
    document.body.style.overflow = 'hidden'; // Prevent main page scroll when drawer open
  };

  // Close Drawer Function
  const closeDrawer = () => {
    drawer.classList.remove('open');
    backdrop.classList.remove('open');
    document.body.style.overflow = '';
  };

  // Click active card to open
  if (collectionsCard) {
    collectionsCard.addEventListener('click', (e) => {
      // Avoid opening drawer if user clicked a direct lesson link inside card (if any exist)
      if (e.target.closest('a')) return;
      openDrawer();
    });
  }

  // Close triggers
  if (closeBtn) closeBtn.addEventListener('click', closeDrawer);
  if (backdrop) backdrop.addEventListener('click', closeDrawer);

  // Esc key listener to close drawer
  window.addEventListener('keydown', (e) => {
    if (e.key === 'Escape' || e.key === 'Esc') {
      closeDrawer();
    }
  });

  // Toast System for Locked Cards
  const lockedCards = document.querySelectorAll('.module-card.locked');
  const toast = document.getElementById('toast');
  const toastText = document.getElementById('toastText');
  let toastTimeout;

  const showToast = (moduleName) => {
    if (!toast || !toastText) return;
    
    // Clear any active timeout
    clearTimeout(toastTimeout);
    
    toastText.textContent = `"${moduleName}" will unlock as you progress. Stay focused on Collections!`;
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
      showToast(moduleTitle);
    });
  });
});
