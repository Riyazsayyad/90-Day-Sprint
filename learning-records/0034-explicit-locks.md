# Explicit locks (Module 03 Section 04)

User requested Module 03 Section 04: Explicit Locks from Senior Backend interview perspective. Scope: why Lock exists beyond synchronized, Lock contract + happens-before, ReentrantLock fairness/tryLock barging, ReadWriteLock downgrade vs upgrade deadlock, StampedLock optimistic validate (not reentrant), Condition vs wait/notify, liveness/tryLock backoff, enterprise picks. Cross-links concurrency-0002 and concurrency-0003. Explicitly excluded executors (S05), concurrent collections/atomics (S06), CompletableFuture/virtual threads, lock-free/AQS internals, StampedLock bit layout.

**Evidence:** Explicit `/teach` request for Module 03 Section 04.

**Implications:** Next section is executors / thread pools (S05). User may write notes now (deferred until after L04). Grill S02–S04 (Conditions, RW upgrade, StampedLock validate, barging tryLock) before S05.
