# Mission: Concurrency & Threads

## Why
You are aiming for Senior Backend / SWE II roles where production services must handle many overlapping requests safely. Parallel streams already showed data parallelism; you now need the thread, lock, and memory-model foundations that power Spring executors, async workflows, and virtual threads — so you can reason about races, pool sizing, and interview scenarios under load.

## Success looks like
- Explain process vs thread, concurrency vs parallelism, and `start()` vs `run()` with JVM-level precision.
- Read a thread dump: map `Thread.State` values to real wait/block causes.
- Choose executors over raw threads; justify bounded pools and rejection policies.
- Reason about shared-heap races and when `synchronized` / `Lock` / `volatile` / JMM rules apply.
- Frame CompletableFuture and virtual-thread designs in production terms (I/O-bound vs CPU-bound).

## Constraints
- Build on Module 00 (stack/heap) and Module 02 (parallel streams / commonPool).
- Prefer Oracle docs + OpenJDK contracts over blog folklore.
- Interview + enterprise framing first; toy demos second.

## Out of scope (for now)
- Full distributed systems (Kafka, Kubernetes) — later modules.
- Deep GC tuning — Module 04.
- Writing production Spring config — Module 05 (after concurrency primitives).

---

<details>
<summary>Previous mission: Core Java & OOP (completed)</summary>

Lessons `oop-0001`–`oop-0015` and related references remain in this workspace.
</details>

<details>
<summary>Previous mission: Java Collection Internals (completed)</summary>

Lessons 7–16 and related references remain in this workspace.
</details>

<details>
<summary>Previous mission: HashMap Internals in Java (completed)</summary>

Lessons 4–6 and related references remain in this workspace.
</details>

<details>
<summary>Previous mission: Functional Interfaces in Java (completed)</summary>

Lessons 1–3 and related references remain in this workspace.
</details>
