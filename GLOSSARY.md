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

## Core Java & OOP Terms

**Procedural Programming**:
A programming paradigm centered around procedures or sequences of instructions, separating data structures from the functions that mutate them.
_Avoid_: functional code (different paradigm)

**Object-Oriented Programming (OOP)**:
A programming paradigm that bundles data (attributes) and logic (methods) into self-contained entities called objects.
_Avoid_: object-based design

**Encapsulation**:
The mechanism of binding data and methods together while restricting direct access to the object's inner state (using private variables and public interfaces).
_Avoid_: safety grouping

**Abstraction**:
The design process of hiding implementation details and exposing only the essential features of a system.
_Avoid_: conceptualizing

**Inheritance**:
A mechanism where a new class inherits properties and behaviors from an existing class, establishing an "IS-A" taxonomy.
_Avoid_: copying code, cloning classes

**Polymorphism**:
The ability for a single interface or reference type to represent different underlying forms (dynamic dispatch at runtime).
_Avoid_: multi-methoding

**Dynamic Dispatch**:
The runtime process by which the JVM resolves which implementation of an overridden method to execute based on the actual object type.
_Avoid_: late binding (acceptable but prefer dynamic dispatch)

**Global State**:
State variables accessible across the entire application namespace, introducing severe mutation side-effects and testing difficulties.
_Avoid_: public memory

**Class**:
A compile-time template or layout schema defining the instance variables and method signatures for objects. In JVM memory, loaded classes exist as java.lang.Class metadata objects in the Metaspace.
_Avoid_: object type (prefer class template/schema)

**Object**:
A concrete entity allocated on the Heap containing instance state data and an object header (Mark/Klass words) linking back to its loaded class definition in Metaspace.
_Avoid_: instance reference (reference variable points to the object, object is the heap allocation)

**Instantiation**:
The runtime process of allocating memory on the Heap for a new object using 'new', setting default field values, writing the header, and running the constructor.
_Avoid_: object creation (creation is fine, but instantiation is more technically precise)

**Reference Variable**:
A variable declared on the Stack (or stored inside another object) that holds the heap memory address reference of an object.
_Avoid_: handle, memory variable

**Class Loading**:
The dynamic process by which the JVM loads class byte streams from disk, links/verifies them, and initializes class-level static structures in Metaspace once.
_Avoid_: instantiation (distinct phase occurring before instantiation)

**Stack**:
A thread-confined, LIFO (Last-In-First-Out) memory region managed automatically by the JVM to store execution stack frames, primitive local variables, and object reference addresses.
_Avoid_: heap memory, global memory

**Heap**:
A globally shared memory region managed by the JVM that houses all object allocations, arrays, and instance variables. Governed by the Garbage Collector.
_Avoid_: thread stack, stack space

**Stack Frame**:
A block of memory pushed onto a thread's stack for each method invocation, storing the method's local variable array, operand stack, and frame execution metadata. Popped automatically on method return.
_Avoid_: execution loop, thread block

**Escape Analysis**:
A JIT compiler optimization technique that checks if an object's scope is confined to its declaring method. If it does not escape, the JIT allocates fields directly on the Stack (Scalar Replacement) to bypass heap and GC overhead.
_Avoid_: scope escape, leak detection

**StackOverflowError (SOE)**:
A JVM error thrown when a thread exhausts its allocated stack space, typically caused by infinite or deeply nested recursive method calls.
_Avoid_: out of memory, stack crash

**OutOfMemoryError (OOM)**:
A JVM error thrown when the Heap space is exhausted and the Garbage Collector cannot reclaim enough memory to allocate new objects.
_Avoid_: stack overflow, memory runout

**Constructor**:
A special initialization block in a class with no return type, executed during object instantiation to populate state variables and establish invariants.
_Avoid_: instance creator, initializer method

**Default Constructor**:
A no-argument, empty-bodied constructor automatically generated by the compiler at compile time if and only if no other constructor is defined in the class.
_Avoid_: implicit initializer

**Constructor Chaining**:
The process of invoking one constructor from another constructor within the same class (using this()) or from a parent class (using super()) as the first execution statement.
_Avoid_: nested constructors

**Static Initializer**:
A static block (static { ... }) inside a class that runs once when the class class loader loads it into memory, used to initialize class-level static constants.
_Avoid_: class initializer

**Instance Initializer**:
An anonymous block ({ ... }) inside a class that runs immediately after the superclass constructor returns and before the child constructor body executes during instantiation.
_Avoid_: object block

**GC Roots**:
Special objects that are directly accessible outside the heap (such as local stack variables, active static variables, and JNI handles), serving as the starting set for garbage collection reachability tracing.
_Avoid_: GC starting points

**Reachability**:
The state of an object indicating whether it can be accessed by tracing a path of active references starting from any GC Root. Unreachable objects are eligible for reclamation.
_Avoid_: reference status

**finalize**:
A deprecated method defined in java.lang.Object historically intended for post-mortem resource cleanup prior to garbage collection, now deprecated due to latency, security, and execution bugs.
_Avoid_: cleanup function, destructure method

**Strong Reference**:
The default type of reference in Java, preventing the garbage collector from reclaiming the referent as long as a reference path exists from any GC Root.
_Avoid_: hard link

**Soft Reference**:
A memory-sensitive reference (java.lang.ref.SoftReference) that is cleared by the garbage collector only when the JVM is running critically low on heap space and is about to throw an OutOfMemoryError.
_Avoid_: cached link

**Weak Reference**:
A reference (java.lang.ref.WeakReference) that is eagerly cleared by the garbage collector during the next collection cycle, regardless of memory capacity.
_Avoid_: loose link

**Phantom Reference**:
A reference (java.lang.ref.PhantomReference) whose referent is already finalized, yielding null on get(). Combined with ReferenceQueue to schedule post-mortem resource cleanup safely.
_Avoid_: shadow link

## Encapsulation Terms

**Encapsulation**:
The bundling of state (data) and behavior (methods) that operate on that state into a single cohesive unit (a Class).
_Avoid_: information hiding (which is access restriction, not grouping)

**Information Hiding (Data Hiding)**:
The practice of restricting access to the internal details and implementation structures of an object, enforced via access modifiers.
_Avoid_: encapsulation (which is bundling, not access restriction)

**Invariant**:
A condition or rule that must always hold true for an object throughout its entire lifecycle to ensure it remains in a valid state.
_Avoid_: integrity constraint

**Tell, Don't Ask**:
A design principle advising that you should command an object to perform actions rather than querying its internal state to make decisions externally.
_Avoid_: getter queries

**Defensive Copying**:
The practice of creating duplicates of mutable input parameters or internal fields to prevent external clients from modifying private state.
_Avoid_: instance cloning

## Inheritance Terms

**Inheritance**:
A mechanism where a new class (subclass) is derived from an existing class (superclass), inheriting its fields and methods.
_Avoid_: implementation cloning

**Method Overriding**:
Redefining a superclass method in a subclass with the exact same name, arguments, and return type.
_Avoid_: method overloading, method hiding

**Dynamic Method Dispatch**:
A mechanism where a call to an overridden method is resolved at runtime based on the actual heap object type, enabling runtime polymorphism.
_Avoid_: static dispatch

**vtable (Virtual Method Table)**:
An internal JVM table structures mapped to each class in Metaspace, storing pointers to virtual method addresses for O(1) resolution.
_Avoid_: lookup hashmap

**Diamond Problem**:
The ambiguity conflict arising when a class inherits different implementations of the same method from multiple parents.
_Avoid_: multiple definition error

## Polymorphism Terms

**Polymorphism**:
The ability of different classes to respond uniquely to the same method invocation, enabling uniform treatment of varied types.
_Avoid_: multiple forms wrapper

**Upcasting**:
Casting a subclass reference to a superclass type (implicit and always safe).
_Avoid_: parent assignment casting

**Downcasting**:
Casting a superclass reference back to a subclass type (explicit and unsafe without checks).
_Avoid_: type forcing

**Pattern Matching (for instanceof)**:
A language feature (Java 16+) that automatically binds a cast variable to a scope if the type check succeeds, eliminating explicit casting boilerplates.
_Avoid_: smart casting












