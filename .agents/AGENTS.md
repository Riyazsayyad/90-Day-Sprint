# Project-Scoped Rules for Riyazsayyad/90-Day-Sprint

This document outlines workspace-specific rules for AI coding assistants working in this repository.

## Lesson Curriculum Indexing

Whenever a new lesson is added, modified, or reordered in the project, agents MUST ensure the lesson list is updated in all the following indexing locations:

1. **Dashboard Home Page ([index.html](file:///c:/Riyaz/Study/Learn/index.html)):** Update the static curriculum cards, progress counts (e.g., `X / Y Lessons`), and lesson lists.
2. **Lessons Tray Configuration ([lesson-tray.js](file:///c:/Riyaz/Study/Learn/assets/lesson-tray.js)):** Add the lesson object to the `lessons` array with its correct lesson number, path, title, and metadata.
3. **Lesson Navigation ([lessons/](file:///c:/Riyaz/Study/Learn/lessons/) HTML pages):** Update the next/prev links in the HTML `<nav class="lesson-nav">` bars to maintain a sequential chain between lessons, and ensure every navigation bar contains a link back to the Dashboard Home Page (`<a href="../index.html">🏠 Home</a>`).

## Study Tracker Maintenance

To ensure the user's progress is consistently and accurately tracked throughout the 90-Day Sprint (Project BMW), agents MUST maintain and update the files in the [tracker/](file:///c:/Riyaz/Study/Learn/tracker/) directory.

### Maintenance Events & Update Rules

Whenever study activities occur, the agent must update the corresponding tracker files:

#### 1. Daily Progress & Lesson Completion
* **Files to Update:**
  * [Progress.md](file:///c:/Riyaz/Study/Learn/tracker/Progress.md)
  * [04_study_progress.md](file:///c:/Riyaz/Study/Learn/tracker/04_study_progress.md)
  * [mentor_handoff.md](file:///c:/Riyaz/Study/Learn/tracker/mentor_handoff.md)
* **Actions:**
  * In [Progress.md](file:///c:/Riyaz/Study/Learn/tracker/Progress.md), increment the **Current Day** (and update the `% complete`), update the **Scoreboard** counts (🟢 Green, 🟡 Yellow, 🔴 Red), update the module progress bars if a module status changes, and append a new line to the **Daily Streak Journal** detailing the day's study activity and status indicator.
  * In [04_study_progress.md](file:///c:/Riyaz/Study/Learn/tracker/04_study_progress.md), update the `Current State` status summaries.
  * In [mentor_handoff.md](file:///c:/Riyaz/Study/Learn/tracker/mentor_handoff.md), update the current Day, Current Module, Current/Next Lesson, and align Strengths/Weaknesses based on performance.

#### 2. Mock or Real-World Interviews
* **Files to Update:**
  * [interview_log.md](file:///c:/Riyaz/Study/Learn/tracker/interview_log.md)
  * [05_interview_history.md](file:///c:/Riyaz/Study/Learn/tracker/05_interview_history.md)
  * [mentor_handoff.md](file:///c:/Riyaz/Study/Learn/tracker/mentor_handoff.md)
* **Actions:**
  * Fill out the template in [interview_log.md](file:///c:/Riyaz/Study/Learn/tracker/interview_log.md) or append a new interview section at the top of the history.
  * Add the mock interview result and score (e.g., `Score X/10`) to [05_interview_history.md](file:///c:/Riyaz/Study/Learn/tracker/05_interview_history.md).
  * Update [mentor_handoff.md](file:///c:/Riyaz/Study/Learn/tracker/mentor_handoff.md) with the **Recent Interview** score, status, and specific mistakes identified.

#### 3. DSA Problem Solving
* **Files to Update:**
  * [Progress.md](file:///c:/Riyaz/Study/Learn/tracker/Progress.md)
  * [04_study_progress.md](file:///c:/Riyaz/Study/Learn/tracker/04_study_progress.md)
* **Actions:**
  * In [Progress.md](file:///c:/Riyaz/Study/Learn/tracker/Progress.md), add the solved LeetCode problem link under the correct topic in the **DSA (LeetCode) Completed** section.
  * In [04_study_progress.md](file:///c:/Riyaz/Study/Learn/tracker/04_study_progress.md), update the completed patterns list and the problem count if applicable.

#### 4. Discovered Weaknesses, Strengths, or Mistakes
* **Files to Update:**
  * [07_technical_weaknesses.md](file:///c:/Riyaz/Study/Learn/tracker/07_technical_weaknesses.md) (and Areas for Focus in [Memory.md](file:///c:/Riyaz/Study/Learn/tracker/Memory.md))
  * [06_technical_strengths.md](file:///c:/Riyaz/Study/Learn/tracker/06_technical_strengths.md)
  * [08_recurring_mistakes.md](file:///c:/Riyaz/Study/Learn/tracker/08_recurring_mistakes.md)
  * [revision.md](file:///c:/Riyaz/Study/Learn/tracker/revision.md)
* **Actions:**
  * Add new conceptual blind spots or coding mistakes to [07_technical_weaknesses.md](file:///c:/Riyaz/Study/Learn/tracker/07_technical_weaknesses.md) and [08_recurring_mistakes.md](file:///c:/Riyaz/Study/Learn/tracker/08_recurring_mistakes.md) as they are observed.
  * Add topics that need spaced repetition to the priority tables in [revision.md](file:///c:/Riyaz/Study/Learn/tracker/revision.md).

#### 5. Goal or Preference Adjustments
* **Files to Update:**
  * [01_long_term_goals.md](file:///c:/Riyaz/Study/Learn/tracker/01_long_term_goals.md)
  * [10_implicit_preferences.md](file:///c:/Riyaz/Study/Learn/tracker/10_implicit_preferences.md)
  * [Memory.md](file:///c:/Riyaz/Study/Learn/tracker/Memory.md)
* **Actions:**
  * If the user adjusts career, finance, or study preferences, update these files to reflect the latest profile information.

