# Heap regions, TLAB & object layout (Module 04 Section 02)

User requested Module 04 Section 02 from Senior Backend interview perspective. Scope: generational heap (Eden/Survivor/Old), object promotion journey, TLAB mechanism, object layout (Mark/Klass/fields/padding), compressed oops/class pointers, array vs plain objects, UseCompressedOops when it matters, false sharing preview, enterprise Young vs Old GC framing, MCQs + reasoning + cheat sheet. Builds on jvm-0001, oop-0002, oop-0005, oop-0010. Excluded full GC algorithms (S03), collector pick (S04), Metaspace (S06), escape analysis detail (S07).

**Evidence:** `/teach` request Sep 15, 2026.

**Implications:** Lesson `jvm-0002-heap-regions-tlab-object-layout.html` + reference written. Module 04 now 2/8. User read + notes same day. Next: S03 GC fundamentals.
