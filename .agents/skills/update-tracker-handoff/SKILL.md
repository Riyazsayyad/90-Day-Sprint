---
name: update-tracker-handoff
description: >-
  End-of-day Project BMW handoff. Infers session context from the chat and
  tracker files, updates tracker/handoff for low-context new chats. Use when
  closing a study day, before ending chat, or when the user invokes
  /update-tracker-handoff with no arguments.
disable-model-invocation: true
---

# Update Tracker Handoff

Run at **end of study day**. User invokes **`/update-tracker-handoff`** — **no arguments required**.

## Zero-args rule (default)

**Do not ask** what to put in the handoff. **Infer everything** from:

1. **This chat** — what was taught, solved, reviewed, committed, pushed, gaps clarified, user's stated next plans (even casual: "I'll do LeetCode tonight", "Module 03 tomorrow").
2. **Tracker standing state** — read before writing:
   - `tracker/mentor_handoff.md`
   - `tracker/04_study_progress.md`
   - `tracker/Progress.md` (if day/scoreboard changed this session)
3. **Repo artifacts** — git status, recent commits, new/modified lesson/exercise paths from the session.

Merge chat + tracker into one handoff. Arguments, if present, **override** only — never required.

## Steps

1. **Gather context** (silent — no user prompts):
   - Scan full conversation for completed work, scores, mistakes, next-session intent.
   - Read `tracker/mentor_handoff.md`, `tracker/04_study_progress.md`.
   - Optionally read `tracker/revision.md`, `07_technical_weaknesses.md` if weaknesses came up in chat.

2. **Follow** [.agents/skills/handoff/SKILL.md](../handoff/SKILL.md) — write temp-dir copy (OS temp, not workspace). Redact PII. Reference paths; no lesson HTML dumps.

3. **Replace** `tracker/handoff/handoff.md` with:
   - Purpose + pointer to `tracker/mentor_handoff.md`
   - Session summary table (from **chat**, not generic boilerplate)
   - Current position (day/module — sync tracker + chat next plans)
   - Open gaps (from mock/review in chat or `revision.md`)
   - Artifacts table (paths only)
   - Agent preferences (brief, stable)
   - Suggested skills
   - New chat starter (`@tracker/handoff/handoff.md` + `@tracker/mentor_handoff.md` + inferred next action)

4. **Update** `tracker/handoff.md` index — latest date + one-line session hint from chat.

5. **Do not commit or push** `tracker/` — local only, PII, `.gitignore`.

6. Push repo only if user asked in the same message or chat clearly ended with unpushed lesson/exercise work.

## Optional arguments

Only if user passes text after the command — treat as **override** for next-session focus. If omitted, **chat inference wins**.

## Done message (brief)

Confirm: handoff updated, temp copy path, inferred next session (one line). No questionnaire.
