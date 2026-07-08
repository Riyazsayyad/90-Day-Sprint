# Java ListIterator instruction track

The user requested a lesson on the Java `ListIterator` interface from an interview perspective (via `/teach Java ListIterator`), continuing the study of Java collection internals. This covers ListIterator's design extensions over Iterator, bi-directional traversal (forward/backward), cursor placement visualization, add/remove/set state rules, OpenJDK inner class implementations, and common interview questions.

**Evidence:** Explicit user request for `/teach Teach me Java ListIterator from an interview perspective.`

**Implications:** Ground the lesson in the index-addressing gaps where the cursor lies *between* elements. Explain why calling `add()` resets `lastRet = -1` to prevent consecutive `remove()` or `set()` operations, and compare the `ArrayList.ListItr` and `LinkedList.ListItr` classes.
