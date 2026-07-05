# Mission: ArrayList Internals in Java

## Why
_Draft — please confirm or revise._ You want to understand how `ArrayList` works under the hood — backing array, capacity vs size, growth strategy, and the performance trade-offs of random access versus insertions/deletions. This is key for writing efficient Java collections code and clearing system design/interview hurdles.

## Success looks like
- Explain the difference between capacity and size of an ArrayList
- Describe the growth strategy (1.5x expansion, array copy) and when it triggers
- Reason about why random access (indexing) is an O(1) operation based on memory addressing
- Explain the cost (O(n) shifting) of insertions and deletions at arbitrary indices vs O(1) amortized at the end

## Constraints
- Focus on `ArrayList` implementation details in modern JDK
- Deep-dive into memory layout and complexity analysis

## Out of scope
- Other list implementations (like `LinkedList` or `Vector`) except for high-level comparison
- Writing a full custom list class from scratch

---

<details>
<summary>Previous mission: HashMap Internals in Java (paused)</summary>

Lessons 4–6 and related references remain in this workspace. Resume anytime with `/teach` on that topic.
</details>

<details>
<summary>Previous mission: Functional Interfaces in Java (paused)</summary>

Lessons 1–3 and related references remain in this workspace. Resume anytime with `/teach` on that topic.
</details>
