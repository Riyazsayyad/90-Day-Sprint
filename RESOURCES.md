# Riyaz Study Sprint — Resources

## Knowledge

- [Oracle: Object-Oriented Programming Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
  Authoritative tutorial covering the foundations: objects, classes, inheritance, interfaces, and packages.
- [Oracle: Controlling Access to Class Members](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
  Official guide on access modifiers (private, default, protected, public) and package boundaries.
- [Joshua Bloch: Effective Java](https://www.oreilly.com/library/view/effective-java/9780134686097/)
  Authoritative guidance on encapsulation and immutability. Focus on Item 15 (Minimize accessibility) and Item 50 (Defensive copying).
- [Oracle: Inheritance and Subclasses](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
  Official guide covering class hierarchies, overriding, hiding, super keyword, and Object methods.
- [Oracle: Polymorphism](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
  Official guide covering runtime polymorphism, method dispatch, and object reference mechanics.
- [Bjarne Stroustrup: What is Object-Oriented Programming?](https://www.stroustrup.com/whatis.pdf)
  Core theoretical foundations: defining classes, inheritance hierarchies, and dynamic binding from a system architecture perspective.


- [Oracle: `ArrayList` javadoc](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/ArrayList.html)
  Authoritative: capacity, growth strategy, performance guarantees for size/isEmpty/get/set/iterator/add. Use for: performance and structural invariants.
- [Oracle: `LinkedList` javadoc](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/LinkedList.html)
  Authoritative: bidirectional search, Deque methods, and complexity metrics. Use for: API usage and node specifications.
- [Oracle: `HashSet` javadoc](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/HashSet.html)
  Authoritative: HashSet API specification, contract of unique elements, and time complexity. Use for: API invariants and performance guarantees.
- [Oracle: `TreeSet` javadoc](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/TreeSet.html)
  Authoritative: TreeSet specification, sorted ordering guarantees, range query operations, and logarithmic time complexities. Use for: API behaviors and interface invariants.
- [Oracle: `PriorityQueue` javadoc](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/PriorityQueue.html)
  Authoritative: PriorityQueue specifications, complete binary heap properties, ordering logic, and time complexities. Use for: API behaviors and interface invariants.
- [Baeldung: Guide to ArrayList in Java](https://www.baeldung.com/java-arraylist)
  Basics of creation, addition, retrieval, capacity control, and internal array resizing. Use for: standard API usages and growth concepts.
- [Baeldung: Guide to LinkedList in Java](https://www.baeldung.com/java-linkedlist)
  Basic structures, node linking logic, queue methods, and collection properties. Use for: comparison profiles.
- [Baeldung: Guide to HashSet in Java](https://www.baeldung.com/java-hashset)
  Basic features, HashMap backing delegation, performance, and custom objects. Use for: quick introduction.
- [Baeldung: Guide to TreeSet in Java](https://www.baeldung.com/java-tree-set)
  Basic properties, sorting with Comparable and Comparator, range queries, and usage scenarios. Use for: sorting guide and examples.
- [Baeldung: Guide to the Java PriorityQueue](https://www.baeldung.com/java-priority-queue)
  Overview of PriorityQueue, Min-Heap/Max-Heap constructions, standard operations, and custom sorting. Use for: usage guide and examples.
- [OpenJDK ArrayList source code](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/ArrayList.java)
  Direct reference for capacity calculation (`newCapacity = oldCapacity + (oldCapacity >> 1)`) and `System.arraycopy` usage. Use for: verification of growth formulas and internal fields.
- [OpenJDK LinkedList source code](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/LinkedList.java)
  Direct reference for internal `Node` class structure, bidirectional lookup index checks, and pointer link/unlink code. Use for: traversal verification.
- [OpenJDK HashSet source code](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/HashSet.java)
  Direct reference for constructors backing HashMap, add/remove/contains delegation, and PRESENT dummy object. Use for: code verification.
- [OpenJDK TreeSet source code](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/TreeSet.java)
  Direct reference for constructors wrapping TreeMap, Comparable cast validations, and key search logic. Use for: code verification.
- [OpenJDK PriorityQueue source code](https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/PriorityQueue.java)
  Direct reference for backing array representation, siftUp and siftDown implementations, and bottom-up heapify. Use for: code verification.

## Wisdom (Communities)

- [Stack Overflow — OOP tag](https://stackoverflow.com/questions/tagged/oop)
  Architectural patterns, encapsulation boundaries, polymorphism questions, and design tradeoffs.
- [Stack Overflow — java-arraylist tag](https://stackoverflow.com/questions/tagged/arraylist+java)
  Edge cases, resizing costs, performance comparison of ArrayList vs LinkedList. Use for: structural disputes or specific usage performance issues.
- [Stack Overflow — java-linkedlist tag](https://stackoverflow.com/questions/tagged/linkedlist+java)
  Edge cases, iterator performance, memory overhead disputes, and queue usages. Use for: specific list structure differences.
- [Stack Overflow — java-hashset tag](https://stackoverflow.com/questions/tagged/hashset+java)
  Edge cases, custom key hashCode/equals bugs, and iteration overhead. Use for: troubleshooting.
- [Stack Overflow — java-treeset tag](https://stackoverflow.com/questions/tagged/treeset+java)
  Common bugs with comparator mismatch, compareTo inconsistency with equals, and duplicate set exclusions. Use for: debugging.
- [Stack Overflow — java-priorityqueue tag](https://stackoverflow.com/questions/tagged/priority-queue+java)
  Edge cases, mutable objects priority update bugs, comparator issues, and iterator unordered pitfalls. Use for: debugging.
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
