# java.lang.Object equals() and hashCode() contracts instruction track

The user requested a lesson on `equals()` and `hashCode()` from an interview and software engineering perspective (via `/teach Teach me equals() and hashCode() in Java from an interview and software engineering perspective.`). This covers: why Object provides these methods, difference between == and equals(), default implementations, General contracts for equals (reflexive, symmetric, transitive, consistent, non-null) and hashCode, HashMap internal storage lookup flow (hash guard check then equals evaluation), consequences of one-sided overrides, performance hazards of hash collisions, hazards of mutable keys in collections, best practices using java.util.Objects utility, IDE vs Lombok vs manual generation, Record types default behavior, and framework integrations (Spring, Hibernate).

**Evidence:** Explicit user request: `/teach Teach me equals() and hashCode() in Java from an interview and software engineering perspective.`

**Implications:** Explain the mathematical contract details that prevent collection bugs. Show how HashMap checks hashCode first (integer check) and equals second. Clarify the danger of mutable keys leading to memory leaks. Address Hibernate unpersisted identity issues, and show records compiler auto-generation behavior.
