# HashSet internals instruction track

The user requested a lesson on HashSet internals (via `/teach HashSet`), pivoting from List collections back to hash-based structures. This builds on previous lessons about HashMap buckets, resizing, and treeification.

**Evidence:** Explicit user request for `/teach HashSet` detailing HashMap backing, equals/hashCode, duplicate rejection, and complexities.

**Implications:** Leverage the user's prior knowledge of HashMap internals (buckets, collision resolution) to explain how HashSet delegates all major operations to a backing HashMap. Deepen understanding of equals() and hashCode() contracts for uniqueness checks.
