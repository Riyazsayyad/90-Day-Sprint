# Synchronization & Monitors (Module 03 Section 02)

User requested Module 03 Section 02: Synchronization & Monitors from Senior Backend interview perspective. Scope: why sync exists (data races, lost updates, check-then-act), critical sections, JVM monitor model (intrinsic lock, Entry vs Wait set, Mark Word biased/thin/fat preview), synchronized methods vs blocks and lock object choice, reentrancy, wait/notify/notifyAll rules, IllegalMonitorStateException, atomicity vs visibility preview, classic bugs (counter, wrong lock, string literal, I/O under lock), when synchronized vs java.util.concurrent, enterprise Spring/cache framing, MCQs + reasoning exercises. Cross-links concurrency-0001 and oop-0010. Explicitly excluded volatile/JMM deep dive (S03), explicit locks (S04), executors (S05), concurrent collections / CF / virtual threads.

**Evidence:** Explicit `/teach` request for Module 03 Section 02.

**Implications:** Next section is volatile + Java Memory Model (happens-before, visibility without full locking). User can now explain BLOCKED vs WAITING with monitor semantics. Grill race trace and producer-consumer guarded block before S03.
