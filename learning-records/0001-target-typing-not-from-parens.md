# Target typing is not inferred from `()`

The user asked whether empty parentheses `()` in a lambda tell Java which class or interface to use. They do not — `()` only means zero parameters. The compiler resolves the lambda against the **target type** (the variable type, method parameter, or cast on the left). Without a target, a zero-arg lambda does not compile. This misconception is worth revisiting when teaching `Supplier` and `Runnable`.

**Evidence:** Follow-up question after Lesson 2 on lambda syntax.

**Implications:** Lesson 3 explicitly contrasts `Supplier<T>` (() → T) with `Runnable` (() → void) using the same `()` syntax but different targets. Do not assume they grasp target typing until they can explain a concrete assignment line.
