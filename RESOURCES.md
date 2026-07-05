# ArrayList Internals — Resources

## Knowledge

- [Oracle: `ArrayList` javadoc](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/ArrayList.html)
  Authoritative: capacity, growth strategy, performance guarantees for size/isEmpty/get/set/iterator/add. Use for: performance and structural invariants.
- [Baeldung: Guide to ArrayList in Java](https://www.baeldung.com/java-arraylist)
  Basics of creation, addition, retrieval, capacity control, and internal array resizing. Use for: standard API usages and growth concepts.
- [OpenJDK ArrayList source code](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/ArrayList.java)
  Direct reference for capacity calculation (`newCapacity = oldCapacity + (oldCapacity >> 1)`) and `System.arraycopy` usage. Use for: verification of growth formulas and internal fields.

## Wisdom (Communities)

- [Stack Overflow — java-arraylist tag](https://stackoverflow.com/questions/tagged/arraylist+java)
  Edge cases, resizing costs, performance comparison of ArrayList vs LinkedList. Use for: structural disputes or specific usage performance issues.
- [r/java](https://reddit.com/r/java)
  General discussion. Use for: real-world collection choices and performance benchmarks.

---

<details>
<summary>Previous topic: HashMap Internals</summary>

See archived resources in git history or prior RESOURCES.md entries for HashMap buckets, resizing, and treeification.
</details>

<details>
<summary>Previous topic: Functional Interfaces</summary>

See archived resources in git history or prior RESOURCES.md entries for lambdas and `java.util.function`.
</details>
