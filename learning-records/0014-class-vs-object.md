# Class vs. Object instruction track

The user requested a lesson on "Class vs Object" from an interview and software engineering perspective (via `/teach Class vs Object`). This covers why Java needs classes, class loading metadata representation in Metaspace (java.lang.Class), object physical memory layouts on the Heap (Mark Word, Klass Word, Instance Data, Padding), the mechanics of the 'new' keyword, references vs. objects, class layout sharing, and real-world analogies.

**Evidence:** Explicit user request: `Teach me "Class vs Object" from an interview and software engineering perspective.`

**Implications:** Ground the distinction between class metadata in Metaspace and dynamic instance allocation on Heap. Emphasize that reference variables are just address placeholders on the stack pointing to objects on the heap. Detail the object header structure to prepare the user for stack/heap memory tracing.
