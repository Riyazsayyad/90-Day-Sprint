# Teaching Notes

## Session 1 (2026-07-02)
- User invoked `/teach functional interface in java`
- Mission drafted but not yet confirmed — need: why they're learning, prior Java/lambda experience, success criteria beyond defaults.

## Session 2 (2026-07-02)
- User invoked `/teach Lambda Expressions` — natural follow-on from Lesson 1.
- Lesson 2 created: syntax, expression vs block, target typing, retrieval practice.
- User asked about `()` and type inference — clarified target typing (see LR-0001).

## Session 3 (2026-07-02)
- User invoked `/teach Predicate, Function, Consumer, Supplier`.
- Lesson 3 created: four core interfaces + Stream pipeline mapping.

## Session 4 (2026-07-04)
- User invoked `/teach hashmap internals` — new track, mission draft updated.
- Lesson 4: buckets, spread hash, index, put/get, collisions.
- GLOSSARY.md started for HashMap terms.

## Session 5 (2026-07-04)
- User started Lesson 5: resize, load factor, threshold, rehash cost.

## Session 6 (2026-07-05)
- User invoked `/teach Lesson 6 — Treeification`.
- Lesson 6 created: O(n) collision degradation, Red-Black Trees (`TreeNode`), trigger conditions (`TREEIFY_THRESHOLD = 8`, `MIN_TREEIFY_CAPACITY = 64`), untreeify threshold (`UNTREEIFY_THRESHOLD = 6` to avoid thrashing), and Poisson distribution context.

## Session 7 (2026-07-05)
- User shifted topic to ArrayList internals (via `/teach 1. ArrayList`).
- Mission.md, Resources.md, and Glossary.md updated for the new track.
- Lesson 7 created: Backing array (`Object[] elementData`), capacity vs size, growth strategy (1.5x capacity), random access memory addressing math, and insertion/deletion element shifting costs.
- Interactive JavaScript-based simulator built inside the lesson to animate array resizing and shifting elements left/right.

## Session 8 (2026-07-05)
- User requested lesson on LinkedList internals (via `/teach 2. LinkedList`).
- Mission.md, Resources.md, and Glossary.md updated to encompass both ArrayList and LinkedList under a unified "Java List Internals" track.
- Lesson 8 created: Doubly linked list Node structure (`item`, `next`, `prev` references), O(n) random access, O(1) link modifications once reference is known, and bidirectional search optimization.
- Interactive JavaScript doubly linked list simulator built inside the lesson, animating pointer traversals and node insertions.
