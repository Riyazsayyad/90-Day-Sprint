# Project-Scoped Rules for Riyazsayyad/90-Day-Sprint

This document outlines workspace-specific rules for AI coding assistants working in this repository.

## Lesson Curriculum Indexing

Whenever a new lesson is added, modified, or reordered in the project, agents MUST ensure the lesson list is updated in all the following indexing locations:

1. **Dashboard Home Page ([index.html](file:///c:/Riyaz/Study/Learn/index.html)):** Update the static curriculum cards, progress counts (e.g., `X / Y Lessons`), and lesson lists.
2. **Lessons Tray Configuration ([lesson-tray.js](file:///c:/Riyaz/Study/Learn/assets/lesson-tray.js)):** Add the lesson object to the `lessons` array with its correct lesson number, path, title, and metadata.
3. **Lesson Navigation ([lessons/](file:///c:/Riyaz/Study/Learn/lessons/) HTML pages):** Update the next/prev links in the HTML `<nav class="lesson-nav">` bars to maintain a sequential chain between lessons, and ensure every navigation bar contains a link back to the Dashboard Home Page (`<a href="../index.html">🏠 Home</a>`).
