# PriorityQueue internals instruction track

The user requested a lesson on PriorityQueue internals (via `/teach PriorityQueue`), continuing the study of Java collection internals. This introduces binary heap algorithms, array-backed binary tree models, and sift-up/sift-down operations.

**Evidence:** Explicit user request for `/teach PriorityQueue` covering Binary Heap, Min Heap, Max Heap via custom comparator, and complexities.

**Implications:** Ground the lesson in the index-addressing math of binary heaps inside flat arrays. Connect this to ArrayList's contiguous memory layouts, and contrast the $O(\log n)$ balanced tree height guarantees of heaps with Red-Black Trees.
