# Stream Collectors Deep Dive

The user requested a lesson on Module 02 - Streams API - Section 04: Collectors Deep Dive. This lesson covers: why Collectors exist (mutable reduction vs reduce), Collector architecture (Supplier, Accumulator, Combiner, Finisher, Characteristics), common collectors (toList, toSet, toCollection, toMap, joining, counting, summarizingInt, averaging, maxBy, minBy), grouping & partitioning, downstream collectors, custom collectors (Collector.of), collector characteristics, enterprise best practices, and common interview traps.

**Evidence:** Explicit user request: `/teach Module: 02 - Streams API Section: 04 - Collectors Deep Dive`

**Implications:** Explain mutable reduction vs immutable reduction (collect vs reduce). Detail the 5 components of a Collector. Explain groupingBy, groupingByConcurrent, and partitioningBy. Cover downstream collectors (mapping, filtering, flatMapping, collectingAndThen, teeing). Walk through custom collectors. Describe characteristics (CONCURRENT, UNORDERED, IDENTITY_FINISH). Highlight key interview traps like toMap duplicate keys and groupingByConcurrent performance characteristics.
