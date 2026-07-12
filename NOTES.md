# Teaching Notes

## Session 1 (2026-07-02)
- User invoked `/teach functional interface in java`
- Mission drafted but not yet confirmed — need: why they're learning, prior Java/lambda experience, success criteria beyond defaults.

## Session 2 (2026-07-02)
- User invoked `/teach Lambda Expressions` — natural follow-on from Lesson 1.
- Lesson 2 created: syntax, expression vs block, target typing, retrieval practice.
- User asked about `()` and type inference — clarified target typing (see LR-0001).

## Session 3 (2026-07-02)
- User invoked `/teach Predicate, Function, Consumer, Supplier`.
- Lesson 3 created: four core interfaces + Stream pipeline mapping.

## Session 4 (2026-07-04)
- User invoked `/teach hashmap internals` — new track, mission draft updated.
- Lesson 4: buckets, spread hash, index, put/get, collisions.
- GLOSSARY.md started for HashMap terms.

## Session 5 (2026-07-04)
- User started Lesson 5: resize, load factor, threshold, rehash cost.

## Session 6 (2026-07-05)
- User invoked `/teach Lesson 6 — Treeification`.
- Lesson 6 created: O(n) collision degradation, Red-Black Trees (`TreeNode`), trigger conditions (`TREEIFY_THRESHOLD = 8`, `MIN_TREEIFY_CAPACITY = 64`), untreeify threshold (`UNTREEIFY_THRESHOLD = 6` to avoid thrashing), and Poisson distribution context.

## Session 7 (2026-07-05)
- User shifted topic to ArrayList internals (via `/teach 1. ArrayList`).
- Mission.md, Resources.md, and Glossary.md updated for the new track.
- Lesson 7 created: Backing array (`Object[] elementData`), capacity vs size, growth strategy (1.5x capacity), random access memory addressing math, and insertion/deletion element shifting costs.
- Interactive JavaScript-based simulator built inside the lesson to animate array resizing and shifting elements left/right.

## Session 8 (2026-07-05)
- User requested lesson on LinkedList internals (via `/teach 2. LinkedList`).
- Mission.md, Resources.md, and Glossary.md updated to encompass both ArrayList and LinkedList under a unified "Java List Internals" track.
- Lesson 8 created: Doubly linked list Node structure (`item`, `next`, `prev` references), O(n) random access, O(1) link modifications once reference is known, and bidirectional search optimization.
- Interactive JavaScript doubly linked list simulator built inside the lesson, animating pointer traversals and node insertions.

## Session 9 (2026-07-08)
- User invoked `/teach Comparable vs Comparator.`
- Lesson 12 created: Comparable (compareTo) vs Comparator (compare), returning values, and TreeSet duplicate handling (comparison equals zero vs Object.equals()).

## Session 10 (2026-07-08)
- User invoked `/teach Collections Utility`.
- Lesson 13 created: java.util.Collections static utilities, unmodifiable/synchronized/checked wrappers, and sentinel empty collections.

## Session 11 (2026-07-08)
- User invoked `/teach Teach me Java Iterator from an interview perspective.`
- Lesson 14 created: Java Iterator design, cursor internals (index pointer vs node reference), fail-fast checks (modCount), iterator.remove() vs collection.remove(), and interview guide.

## Session 12 (2026-07-08)
- User invoked `/teach Teach me Java ListIterator from an interview perspective.`
- Lesson 15 created: ListIterator bi-directional traversal, cursor placement gap visualizer, add/remove/set state validation details, and interview questions.

## Session 13 (2026-07-08)
- User invoked `/teach Fail-Fast vs Fail-Safe iterators in Java from an interview perspective.`
- Lesson 16 created: Fail-Fast vs Fail-Safe design, ConcurrentModificationException internals (modCount/expectedModCount), best-effort boundaries, CopyOnWriteArrayList snapshot iteration, and ConcurrentHashMap bucket iteration.

## Session 14 (2026-07-10)
- Completed Module 01: Collections Internals.
- Activated Module 00: OOP Fundamentals to begin the OOP track.

## Session 15 (2026-07-11)
- User invoked `/teach Teach me "Why Object-Oriented Programming?" from an interview and software engineering perspective.`
- Lesson 1 (Why OOP) created (as oop-0001.html): Procedural pitfalls (global state, coupling), OOP core pillars (encapsulation, abstraction, inheritance, polymorphism), Java-specific choices (safety, JVM, java.lang.Object root), payments OCP integration example, primitive type performance compromises, and dynamic dispatch.

## Session 16 (2026-07-11)
- User invoked `/teach Class vs Object`
- Lesson 2 (Class vs Object) created (as oop-0002.html): Class load schema metadata in Metaspace (java.lang.Class), Object memory layout in Heap (Mark Word, Klass Word, instance data, padding), new keyword allocation mechanics, reference variables on stack, and analogies (schema/row, recipe/cake).

## Session 17 (2026-07-11)
- User requested lessons in every new module to start numbering from 1 (instead of continuation). Renamed OOP lessons to `oop-0001-...` and `oop-0002-...`.
- User requested adding Modules 06 (Databases & Persistence) and 07 (Performance Engineering) to the dashboard. Shifted subsequent locked modules to Modules 08, 09, 10. Updated progress tracker calculation to reflect 1 of 11 modules completed (9.1% progress).

## Session 18 (2026-07-11)
- User invoked `/teach Java Memory Model: Stack vs Heap`
- Lesson 3 (Stack vs Heap) created (as oop-0003.html): Stack (thread-bound LIFO, primitives, reference pointers) vs. Heap (shared objects, instance variables), execution stack frames (local variable arrays, operand stack, frame data), local vs. instance variable scopes, new keyword memory trace, GC eligibility, StackOverflow vs OOM, and JIT Escape Analysis.

## Session 19 (2026-07-11)
- Reorganized curriculum based on user's new list of 11 modules (Modules 00 to 10).
- Renamed Module 00 from "OOP Fundamentals" to "Core Java & OOP" (updated index.html, lesson-tray.js, MISSION.md, GLOSSARY.md).
- Inserted new Module 02: "Streams API".
- Shifted subsequent locked modules: Concurrency to 03, JVM & Memory to 04, Spring Boot to 05.
- Merged the two database modules into Module 06: "Databases & Persistence (SQL + Hibernate)".
- Kept Performance Engineering as Module 07, and shifted Distributed Systems, System Design, AI Engineering to Modules 08, 09, 10.

## Session 20 (2026-07-12)
- User invoked `/teach Constructors in Java`
- Lesson 4 (Constructors) created (as oop-0004.html): Invariant safety, compiler default generator, overloading, chaining via this() and super() rules, execution sequence (loading vs initialization), static vs instance initializer blocks, private constructor usages, and non-overriding constraints.

## Session 21 (2026-07-12)
- User invoked `/teach Object Lifecycle in Java`
- Lesson 5 (Object Lifecycle) created (as oop-0005-object-lifecycle.html): Instantiation steps, GC Root sets, reachability tracing, finalize() deprecation hazards (security finalizer attacks, slow performance loops), resurrection constraints, and reference strengths (Strong, Soft, Weak, Phantom).

## Session 22 (2026-07-12)
- User invoked `/teach Teach me "Encapsulation in Java" from an interview and software engineering perspective.`
- Lesson 6 (Encapsulation) created (as oop-0006-encapsulation.html): Bundling vs. information hiding, access modifiers, mutable state leaks and defensive copying, immutability requirements, Tell Don't Ask principle, DDD Aggregates vs. DTOs, and interview questions.

## Session 23 (2026-07-12)
- User invoked `/teach Teach me "Inheritance in Java" from an interview and software engineering perspective.`
- Lesson 7 (Inheritance) created (as oop-0007-inheritance.html): Code reuse, IS-A contract, constructor chaining and compiler super() rules, overriding contracts, dynamic method dispatch, single inheritance, the Diamond Problem, and vtable lookups.

## Session 24 (2026-07-13)
- User invoked `/teach Teach me "Polymorphism in Java" from an interview and software engineering perspective.`
- Lesson 8 (Polymorphism) created (as oop-0008-polymorphism.html): Early vs late binding, overloading vs overriding differences, upcasting and downcasting, traditional vs modern instanceof pattern matching, framework dependencies (DI / Template Method), and vtable mechanics.
