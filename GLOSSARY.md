# Java Collections Glossary

Terms for Java collections internals in this workspace. Definitions tighten as lessons progress.

## HashMap Terms

**Bucket**:
One slot in the `table` array. An index where entries whose keys hash to the same value may be stored.
_Avoid_: slot, bin (acceptable but prefer bucket in lessons)

**Collision**:
When two different keys produce the same bucket index. Resolved by chaining (linked list or tree), not by rejecting the put.
_Avoid_: duplicate, clash

**Load factor**:
The fraction of capacity allowed to fill before resize. Default `0.75f`. Threshold = capacity × load factor.
_Avoid_: fill ratio

**Rehash / resize**:
When `size > threshold`, capacity doubles and every entry is moved to a new bucket index.
_Avoid_: reindex (use only when describing the algorithm step)

**Spread hash**:
The processed hash stored in each Node: `h ^ (h >>> 16)`. Distributes bits before index calculation.
_Avoid_: final hash, mixed hash

**Treeify**:
Converting a bucket's linked list to a red-black tree when chain length exceeds 8 and table capacity ≥ 64 (Java 8+).
_Avoid_: tree conversion

## ArrayList Terms

**Backing Array**:
The underlying primitive array (`Object[]`) used to store the elements of an `ArrayList`.
_Avoid_: storage array, internal buffer

**Capacity**:
The length of the backing array, representing the maximum number of elements the list can hold before growing.
_Avoid_: limit, max size

**Size**:
The actual number of elements currently stored in the `ArrayList`.
_Avoid_: count, length

**Growth Factor**:
The multiplier (1.5x in JDK) by which the capacity of the backing array is expanded when it becomes full.
_Avoid_: expansion rate, multiplier

**Random Access**:
Retrieving or updating an element at a specific index in constant `O(1)` time.
_Avoid_: direct indexing, direct lookup

## LinkedList Terms

**Node**:
A simple object wrapper storing an element along with reference pointers (`prev` and `next`) to adjacent objects in a list.
_Avoid_: item box, element block

**Pointer / Reference**:
A memory address reference variable (`next` or `prev`) pointing to another `Node` object.
_Avoid_: link address, joint

**Doubly Linked List**:
A linear collection of nodes where each node links to both its predecessor and its successor.
_Avoid_: bidirectional chain, two-way list

**Traversal**:
The process of visiting each node in sequence from one end of a list to search for or access a specific element.
_Avoid_: scanning, walking

## HashSet Terms

**HashSet**:
A collection that stores unique elements, backed internally by a `HashMap`.
_Avoid_: hash list, unique list

**Dummy Value (PRESENT)**:
A static sentinel `Object` instance used as the value for every key in the internal `HashMap` since `HashSet` only tracks keys (elements).
_Avoid_: placeholder item, blank value

**equals()**:
A method used to compare elements for equality within a bucket to identify duplicates.
_Avoid_: same comparison, checking identity

**hashCode()**:
A method that returns an integer hash representing the element, used to determine its bucket index in the backing hash table.
_Avoid_: hash number, slot code

## TreeSet Terms

**TreeSet**:
A collection that stores unique elements in a sorted order, backed internally by a `TreeMap`.
_Avoid_: tree list, sorted list

**Red-Black Tree**:
A self-balancing binary search tree structure that ensures logarithmic `O(log n)` time complexity for primary operations.
_Avoid_: balanced graph, sorted node web

**Comparable**:
A Java interface defining the natural ordering of a class via the `compareTo()` method.
_Avoid_: natural sorter, value ranker

**Comparator**:
A Java interface defining custom sorting logic via the `compare()` method, passed to the collection at initialization.
_Avoid_: custom sorter, external ranker

**compareTo()**:
A method that compares the current object with another object, returning a negative integer, zero, or a positive integer.
_Avoid_: rank method, size difference

## PriorityQueue Terms

**PriorityQueue**:
An unbounded queue based on a priority heap, where elements are ordered according to their natural ordering or a custom comparator.
_Avoid_: heap list, rank queue

**Binary Heap**:
A complete binary tree stored inside a contiguous array, satisfying the heap property where each parent is either <= (min-heap) or >= (max-heap) its children.
_Avoid_: heap layout, balanced queue array

**Sift-Up (Bubble Up)**:
The operation of restoring the heap property by traversing up from a newly inserted leaf to the root, swapping elements that violate the heap order.
_Avoid_: float up, swap up

**Sift-Down (Bubble Down)**:
The operation of restoring the heap property by traversing down from the root to a leaf, swapping the parent with its smaller/larger child.
_Avoid_: sink down, sift down

**Heapify**:
The O(n) process of building a valid binary heap structure from an arbitrary, unsorted array of elements.
_Avoid_: heap creation, array sort




