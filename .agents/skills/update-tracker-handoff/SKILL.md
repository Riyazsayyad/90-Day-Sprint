---
name: update-tracker-handoff
description: >-
  End-of-day Project BMW handoff. Summarizes the chat, updates tracker/handoff
  files for low-context new chats. Use when closing a study day, before ending
  chat, or when the user says day close, handoff, or update tracker handoff.
argument-hint: "What will the next session focus on?"
disable-model-invocation: true
---

# Update Tracker Handoff

Run at **end of study day** so the next chat can `@tracker/handoff/handoff.md` with minimal context.

## Steps

1. **Read and follow** [.agents/skills/handoff/SKILL.md](../handoff/SKILL.md) — summarize the conversation; save a copy to the OS temp directory (not the workspace). Redact PII (salary, debt, personal goals). Reference paths instead of duplicating lesson HTML or long diffs.

2. **Replace** `tracker/handoff/handoff.md` with a session handoff using this structure:
   - Purpose + canonical standing state pointer (`tracker/mentor_handoff.md`)
   - Session summary table (what was completed)
   - Current position (day, module, next lesson — sync from `mentor_handoff.md` / `04_study_progress.md`)
   - Open gaps / revision items (reference `revision.md`, not full lists)
   - Artifacts table (paths only)
   - Agent preferences (brief)
   - Suggested skills
   - New chat starter block (`@tracker/handoff/handoff.md` + `@tracker/mentor_handoff.md`)

3. **Update** `tracker/handoff.md` index — set **Latest session handoff** link to `handoff/handoff.md` with today's date.

4. **Do not commit or push** `tracker/` — local only, PII, `.gitignore`.

5. If the user also asked to push repo changes, commit **non-tracker** artifacts only (lessons, exercises, skills, learning-records).

## Arguments

If the user passes arguments (e.g. "LeetCode tomorrow, Module 03 next"), tailor **Current position** and **New chat starter** in `tracker/handoff/handoff.md`.
