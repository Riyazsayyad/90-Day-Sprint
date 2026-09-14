---
name: update-tracker-handoff
description: >-
  Project BMW handoff + memory kick-start. End-of-day: infer from chat + tracker,
  write tracker/handoff. New chat / first message: read handoff + mentor memory
  and orient — do not rely on empty chat. Use when closing a study day, starting
  a fresh chat with memory, or when the user invokes /update-tracker-handoff.
disable-model-invocation: true
---

# Update Tracker Handoff

User invokes **`/update-tracker-handoff`** — **no arguments required**.

Pick the mode from **chat position**, not from user wording.

## Mode A — Kick-start (new chat / first message)

**When:** This is the **first user message** in the chat, **or** the user opened a **new chat** and `/update-tracker-handoff` is their opener (no prior study context in this thread).

**Do not** infer session work from this chat — there is none. **Do not ask** what to put in the handoff.

**Read (in order):**
1. `tracker/handoff/handoff.md` — latest session summary + new-chat starter
2. `tracker/mentor_handoff.md` — standing day / module / next lesson
3. `tracker/04_study_progress.md` — section completion
4. `tracker/Progress.md` — scoreboard + journal (if day status unclear)
5. `tracker/Memory.md` + `tracker/10_implicit_preferences.md` — goals, tone, prefs (skim)

**Do:**
- Greet as Coach; **orient** in caveman ultra: day, module, last study, open day status, next action
- Surface 2–3 open gaps from handoff / `revision.md` if relevant
- Point to `@tracker/handoff/handoff.md` + `@tracker/mentor_handoff.md` for continuity
- **Only rewrite** `tracker/handoff/handoff.md` if tracker files clearly **newer** than handoff (e.g. journal entries after handoff date) — then refresh from tracker, not from empty chat

**Do not:** Run end-of-day write from blank chat. Do not questionnaire.

**Done message:** Orient summary + one-line next action. Mention handoff refresh only if you actually updated it.

---

## Mode B — Session close (active chat)

**When:** Chat already has study activity this thread (lessons, tracker edits, mocks, push, grill, etc.).

**Do not ask** what to put in the handoff. **Infer everything** from:

1. **This chat** — taught, solved, reviewed, committed, pushed, gaps, next plans (even casual)
2. **Tracker standing state** — read before writing:
   - `tracker/mentor_handoff.md`
   - `tracker/04_study_progress.md`
   - `tracker/Progress.md` (if day/scoreboard changed this session)
3. **Repo artifacts** — git status, recent commits, new/modified lesson paths

Merge chat + tracker into one handoff. Arguments, if present, **override** only — never required.

### Steps (session close)

1. **Gather context** (silent):
   - Scan full conversation for completed work, scores, mistakes, next-session intent
   - Read `tracker/mentor_handoff.md`, `tracker/04_study_progress.md`
   - Optionally `tracker/revision.md`, `07_technical_weaknesses.md` if weaknesses came up

2. **Follow** [.agents/skills/handoff/SKILL.md](../handoff/SKILL.md) — temp-dir copy (OS temp). Redact PII. Reference paths; no lesson HTML dumps.

3. **Replace** `tracker/handoff/handoff.md` with:
   - Purpose + pointer to `tracker/mentor_handoff.md`
   - Session summary table (from **chat**, not boilerplate)
   - Current position (day/module — sync tracker + chat next plans)
   - Open gaps (mock/review in chat or `revision.md`)
   - Artifacts table (paths only)
   - Agent preferences (brief, stable)
   - Suggested skills
   - New chat starter (`@tracker/handoff/handoff.md` + `@tracker/mentor_handoff.md` + inferred next action)

4. **Update** `tracker/handoff.md` index — latest date + one-line hint from chat.

5. **Do not commit or push** `tracker/` — local only, PII, `.gitignore`.

6. Push repo only if user asked in the same message or chat ended with unpushed lesson work.

## Optional arguments

Text after the command = **override** for next-session focus. If omitted, chat inference wins in Mode B; tracker + handoff wins in Mode A.

## Done message (brief)

- **Mode A:** Orient + next action (one line). Handoff path if refreshed.
- **Mode B:** Handoff updated, temp copy path, inferred next session (one line). No questionnaire.
