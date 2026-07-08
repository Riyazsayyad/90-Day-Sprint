# Comparable vs Comparator instruction track

The user requested a lesson on Comparable vs Comparator internals (via `/teach Comparable vs Comparator.`), continuing the study of Java collection internals. This introduces natural vs external ordering, compareTo vs compare contracts, and TreeSet's key duplicate rejection mechanics based on comparison value 0.

**Evidence:** Explicit user request for `/teach Comparable vs Comparator.`

**Implications:** Compare the two interfaces, clarify when to use each, outline the comparison contract (negative/zero/positive), and highlight the crucial TreeSet comparison uniqueness rule (not using equals()).
