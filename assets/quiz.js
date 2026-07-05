/**
 * Simple quiz widget — one question, immediate feedback.
 * All answer buttons should be equal length (no formatting clues).
 */
function initQuiz(containerId, messages) {
  const container = document.getElementById(containerId);
  if (!container) return;

  const feedback = container.querySelector('.quiz-feedback');
  const buttons = container.querySelectorAll('button[data-answer]');

  buttons.forEach((btn) => {
    btn.addEventListener('click', () => {
      if (container.dataset.answered) return;
      container.dataset.answered = 'true';

      const isCorrect = btn.dataset.answer === 'correct';
      btn.classList.add(isCorrect ? 'correct' : 'incorrect');

      if (!isCorrect) {
        const correctBtn = container.querySelector('[data-answer="correct"]');
        if (correctBtn) correctBtn.classList.add('correct');
      }

      feedback.textContent = isCorrect ? messages.correct : messages.wrong;
      buttons.forEach((b) => { b.disabled = true; });
    });
  });
}
