# Core Java & OOP final keyword, immutability, and JVM JIT optimizations track

The user requested a lesson on the `final` keyword in Java from an interview and software engineering perspective (via `/teach Teach me "final" in Java from an interview and software engineering perspective...`). This covers: why final was introduced, different usages (variables, methods, classes, parameters), reference invariance vs. object immutability, blank final initialization rules, differences between final, static, and static final, compile-time constants (CTC) and constant inlining, String's final/immutable nature, JIT optimizations (devirtualization, method inlining, constant folding), framework design impact (Spring Boot constructor injection, Records), interview questions, and coding exercises.

**Evidence:** Explicit user request: `/teach Teach me "final" in Java from an interview and software engineering perspective.`

**Implications:** Detail compiler definite assignment analysis for blank finals. Contrast final references with immutable collections. Describe constant inlining bytecode mechanics and the clean-build hazard. Explain how the JIT uses devirtualization and profiling to inline final methods for performance. Suggest constructor injection over field injection for robust framework APIs.
