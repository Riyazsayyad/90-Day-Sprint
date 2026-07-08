# Java Fail-Fast vs Fail-Safe instruction track

The user requested a lesson on Java `Fail-Fast vs Fail-Safe Iterators` from an interview perspective (via `/teach Fail-Fast vs Fail-Safe`), continuing the study of Java collection internals. This covers ConcurrentModificationException triggers, modCount/expectedModCount internals, why fail-fast is "best-effort", CopyOnWriteArrayList snapshot iteration, ConcurrentHashMap weakly-consistent iterators, and engineering trade-offs.

**Evidence:** Explicit user request for `/teach Fail-Fast vs Fail-Safe iterators in Java from an interview perspective.`

**Implications:** Detail the structural vs non-structural modifications (i.e. changing element values via setters does not increment modCount). Clarify the memory and synchronization visibility issues that make fail-fast "best-effort" in multithreaded environments, and detail CopyOnWriteArrayList array copying overhead.
