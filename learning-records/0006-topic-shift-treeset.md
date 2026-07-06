# TreeSet internals instruction track

The user requested a lesson on TreeSet internals (via `/teach TreeSet`), continuing the study of Set collections. This builds on the HashSet backing concept, contrasting hash-based sets with tree-based sorted sets.

**Evidence:** Explicit user request for `/teach TreeSet` detailing Red-Black Trees, ordering, Comparable vs Comparator, and complexities.

**Implications:** Explain how TreeSet delegates to a backing TreeMap containing a Red-Black Tree. Focus heavily on how duplicate rejection is determined by the return value of tree operations, which rely on compareTo() or compare() returning 0, rather than equals() or hashCode().
