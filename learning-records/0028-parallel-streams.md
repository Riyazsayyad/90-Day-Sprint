# Parallel Streams (Module 02 Section 05)

User requested lesson on Parallel Streams from Senior Backend Engineer interview perspective. Scope: why parallel exists (parallelism vs concurrency, data parallelism), enabling parallelism (`parallel()`, `sequential()`, `parallelStream()`), execution model (commonPool, work-stealing, trySplit, default parallelism, custom pools), ordering (`forEach` vs `forEachOrdered`, `findFirst` vs `findAny`, `unordered()`), statelessness/thread safety, performance reality, enterprise hazards, best practices, interview traps. Explicitly excluded deep Stream Internals and full Collectors re-teach.

**Evidence:** Explicit `/teach` request for Module 02 Section 05.

**Implications:** Next section is Stream Internals (Sink chain, AbstractPipeline, Spliterator deep-dive). User has collectors foundation for CONCURRENT collectors reference. Future concurrency module can cross-link commonPool starvation.
