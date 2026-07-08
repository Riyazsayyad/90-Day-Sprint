# Java Iterator instruction track

The user requested a lesson on the Java `Iterator` interface from an interview perspective (via `/teach Java Iterator`), continuing the study of Java collection internals. This covers Iterator's design origin, cursor mechanisms, API internals (hasNext, next, remove), ConcurrentModificationException safety, time complexities, ArrayList/LinkedList internal representations, and common interview questions.

**Evidence:** Explicit user request for `/teach Teach me Java Iterator from an interview perspective.`

**Implications:** Ground the lesson in the internal cursor indexing logic (ArrayList's integer pointer vs. LinkedList's Node reference pointer), detail the `modCount` fail-fast validation checks that guard against concurrent modification, and analyze standard interview scenarios.
