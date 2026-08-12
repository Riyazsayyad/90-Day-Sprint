# volatile & Java Memory Model (Module 03 Section 03)

User requested Module 03 Section 03: volatile & Java Memory Model from Senior Backend interview perspective. Scope: why synchronized isn't always enough, CPU cache/reordering preview, JMM contract, happens-before rules (monitor, volatile, start/join, transitivity), volatile visibility/ordering vs lack of compound atomicity, volatile vs synchronized trade-offs, long/double torn reads, final fields safe publication preview, broken vs correct DCL, safe publication idioms, classic bugs (shutdown flag, stale config), enterprise framing (flags, config, metrics). Cross-links concurrency-0002. Explicitly excluded ReentrantLock/Condition (S04), executors (S05), concurrent collections (S06), CompletableFuture/virtual threads, formal JSR-133 proof depth.

**Evidence:** Explicit `/teach` request for Module 03 Section 03.

**Implications:** Next section is explicit locks (ReentrantLock, ReadWriteLock, Condition). User should finish S02 read + grill happens-before/DCL before S04. AtomicInteger/LongAdder foreshadowed for counters.
