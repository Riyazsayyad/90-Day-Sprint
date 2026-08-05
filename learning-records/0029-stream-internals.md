# Stream Internals (Module 02 Section 06 — Capstone)

User requested Module 02 Section 06: Stream Internals from Senior Backend Engineer interview perspective. Scope: why internals matter (compiled pipelines, lazy runtime), AbstractPipeline architecture (head/stateless/stateful, evaluate paths), Spliterator contract and characteristics, Sink chain deep dive (wrapSink, fusion, barriers), StreamOpFlag/StreamShape, parallel node trees (opEvaluateParallel), source wrappers and edge cases (flatMap, concat, onClose, CME), JVM allocation/JIT, Module 02 synthesis and interview traps. Explicitly excluded re-teaching Collectors API and Parallel Streams usage — reference only.

**Evidence:** Explicit `/teach` request for Module 02 Section 06.

**Implications:** Module 02 Streams API curriculum complete (6/6 lessons). Next module is Concurrency & Threads — can cross-link ForkJoinPool/commonPool from parallel internals. User has full execution-engine mental model for senior interviews.
