# Mission: Java Collection Internals (Lists, Hash, Trees, and Heaps)

## Why
You want to understand how standard Java collection implementations (Lists, HashMap, HashSet, TreeSet, and PriorityQueue) work under the hood. Specifically, you want to learn about backing arrays, node structures, lookup/update costs, hashing, sorting, tree structures, binary heaps, duplicate handling, and design tradeoffs.

## Success looks like
- Explain the physical and logical difference between capacity and size in ArrayList
- Describe the ArrayList growth strategy (1.5x scaling) and resizing costs
- Detail the LinkedList node wrapper structure (`item`, `next`, `prev` references)
- Reason about time complexities: why array index lookup is O(1) while linked list indexing is O(n)
- Explain why node link modifications are O(1) when a reference is known, contrasting with array element shifting
- Compare memory overhead and cache locality differences between arrays and link chains
- Explain how HashSet uses a backing HashMap where elements are keys and a dummy object (`PRESENT`) is the value
- Explain how duplicates are rejected during HashSet.add() based on map.put() return values
- Detail the `equals()` and `hashCode()` contract for element uniqueness in hash-based collections
- Analyze average and worst-case time complexities of HashSet operations (add, remove, contains)
- Explain how TreeSet uses a backing TreeMap with elements stored as keys in a Red-Black Tree
- Describe Comparable vs Comparator ordering contracts and how TreeSet uniqueness relies on comparison result `0` instead of `equals()`
- Reason about the O(log n) time complexity of TreeSet search and insertion operations
- Explain how PriorityQueue is backed by a binary heap array representation of a complete binary tree
- Calculate array indices for a node's left child (`2i + 1`), right child (`2i + 2`), and parent (`(i-1)/2`)
- Detail the sift-up and sift-down mechanics to restore heap property on insertion and extraction
- Analyze time complexities for PriorityQueue operations: peek (`O(1)`), offer/poll (`O(log n)`), and heapify (`O(n)`)

## Constraints
- Focus on ArrayList, LinkedList, HashMap, HashSet, TreeSet, and PriorityQueue implementation details in the modern JDK
- Deep-dive into memory layouts, pointers, hashing, trees, binary heaps, and complexity analyses

## Out of scope
- Other specialized collections (like CopyOnWriteArrayList, Vector, or concurrent queues)
- Writing a custom list/set/map class from scratch

---

<details>
<summary>Previous mission: HashMap Internals in Java (paused)</summary>

Lessons 4–6 and related references remain in this workspace. Resume anytime with `/teach` on that topic.
</details>

<details>
<summary>Previous mission: Functional Interfaces in Java (paused)</summary>

Lessons 1–3 and related references remain in this workspace. Resume anytime with `/teach` on that topic.
</details>
