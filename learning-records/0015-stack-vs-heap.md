# Stack vs. Heap memory layout instruction track

The user requested a lesson on "Java Memory Model: Stack vs Heap" from an interview and software engineering perspective (via `/teach Java Memory Model: Stack vs Heap`). This covers JVM memory separation motivations, Stack (LIFO thread-bound, primitives, reference pointers) vs. Heap (shared objects, instance variables), execution stack frames (local variable arrays, operand stack, frame data), local vs. instance variables, new keyword allocation trace, object lifetime and GC eligibility, StackOverflowError vs. OutOfMemoryError, and JIT Escape Analysis (scalar replacement).

**Evidence:** Explicit user request: `Teach me "Java Memory Model: Stack vs Heap" from an interview and software engineering perspective.`

**Implications:** Bridge the gap between reference variable boundaries and heap payloads. Detail stack frame mechanics to show how methods execute. Introduce escape analysis to show JIT compilation optimizations that override default heap layouts, paving the way for advanced garbage collection discussions.
