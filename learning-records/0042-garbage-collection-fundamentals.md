# Garbage collection fundamentals (Module 04 Section 03)

User requested Module 04 Section 03 from Senior Backend interview perspective. Scope: why GC exists, GC roots (stacks/statics/JNI/monitors), reference strengths with collector timing, mark/sweep/compact/copy, STW vs concurrent, generational hypothesis, minor vs major/full GC, safepoints, retention bugs (static collections, ThreadLocal preview, premature promotion), p99 vs throughput framing, MCQs + reasoning + cheat sheet. Builds on oop-0005, jvm-0002, concurrency-0002. Excluded G1/ZGC comparison (S04), flag cookbook (S05), heap dump (S08), JMM deep dive (cross-link concurrency-0003 only).

**Evidence:** `/teach` request Sep 15, 2026.

**Implications:** Lesson `jvm-0003-garbage-collection-fundamentals.html` + reference written. Module 04 now 3/8. User read + notes same day. Next: S04 collector comparison.
