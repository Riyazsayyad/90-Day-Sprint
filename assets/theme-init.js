(function () {
  var stored = localStorage.getItem('bmw-theme');
  var theme = stored;
  if (!theme) {
    theme = window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches
      ? 'dark'
      : 'light';
  }
  if (theme !== 'dark') theme = 'light';
  document.documentElement.setAttribute('data-theme', theme);
})();
