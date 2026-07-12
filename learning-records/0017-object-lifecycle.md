# Object Lifecycle & Reference Types instruction track

The user requested a lesson on "Object Lifecycle in Java" from an interview and software engineering perspective (via `/teach Object Lifecycle in Java`). This covers the entire lifecycle from class loading to GC sweeps, memory allocation mechanics (including TLABs, zeroing out, header Mark/Klass setup), GC Root sets and reachability tracking, finalize() deprecation (safety risks, finalizer attacks, single-threaded locks, timing bottlenecks), object resurrection constraints (run-once restriction), and reference type strengths (Strong, Soft, Weak, Phantom references).

**Evidence:** Explicit user request: `/teach Teach me "Object Lifecycle in Java" from an interview and software engineering perspective.`

**Implications:** Bridge constructor details into instance usage and GC collection phases. Establish the difference between stack variable lifetimes (bound to frame pops) and heap objects (reclaimed asynchronously via reachability tracing). Introduce referencing types (Soft, Weak, Phantom) to lay foundations for caching and clean system implementations.
