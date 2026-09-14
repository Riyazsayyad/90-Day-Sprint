import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Module 04 — JVM &amp; Memory Management Capstone Exercise
 * <p>
 * Copy into IntelliJ / java-interview-lab. Requires JUnit Jupiter 5.x.
 * Diagnostic + small fix scenarios — maps to jvm-0001 … jvm-0008.
 * </p>
 */
public class JvmCapstoneExercise {

    // -------------------------------------------------------------------------
    // EXERCISE 01 — OOM message → pool (S01, S05)
    // -------------------------------------------------------------------------

    /**
     * Given OOM message, return pool id: {@code heap}, {@code metaspace}, {@code direct}, {@code native_thread}.
     */
    static String exercise01_oomPool(String message) {
        // TODO: map message substring to pool
        throw new UnsupportedOperationException("TODO: exercise01_oomPool");
    }

    @Test
    void test01_metaspaceOom() {
        assertEquals("metaspace", exercise01_oomPool("OutOfMemoryError: Metaspace"));
    }

    @Test
    void test01_directOom() {
        assertEquals("direct", exercise01_oomPool("OutOfMemoryError: Direct buffer memory"));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 02 — GC log reclaim percent (S05)
    // -------------------------------------------------------------------------

    /**
     * Parse {@code beforeM}, {@code afterM}, {@code capacityM} from a GC line.
     * Return percent of capacity still used after GC (0–100 integer).
     */
    static int exercise02_heapUsedPercentAfterGc(int beforeM, int afterM, int capacityM) {
        // TODO: return (afterM * 100) / capacityM
        throw new UnsupportedOperationException("TODO: exercise02_heapUsedPercentAfterGc");
    }

    @Test
    void test02_gcReclaim() {
        assertEquals(93, exercise02_heapUsedPercentAfterGc(950, 948, 1024));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 03 — First diagnostic tool (S08)
    // -------------------------------------------------------------------------

    /**
     * {@code symptom}: {@code deadlock}, {@code heap_growth}, {@code high_cpu}, {@code metaspace}.
     * Return tool: {@code thread_dump}, {@code heap_dump}, {@code cpu_profile}, {@code classloader_review}.
     */
    static String exercise03_firstTool(String symptom) {
        // TODO
        throw new UnsupportedOperationException("TODO: exercise03_firstTool");
    }

    @Test
    void test03_deadlockTool() {
        assertEquals("thread_dump", exercise03_firstTool("deadlock"));
    }

    @Test
    void test03_heapGrowthTool() {
        assertEquals("heap_dump", exercise03_firstTool("heap_growth"));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 04 — Container Xmx headroom (S01, S05)
    // -------------------------------------------------------------------------

    /**
     * {@code containerLimitMb} cgroup limit. Return recommended max {@code -Xmx} mb (50% rule).
     */
    static int exercise04_recommendedXmxMb(int containerLimitMb) {
        // TODO: return containerLimitMb / 2
        throw new UnsupportedOperationException("TODO: exercise04_recommendedXmxMb");
    }

    @Test
    void test04_xmxHeadroom() {
        assertEquals(1024, exercise04_recommendedXmxMb(2048));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 05 — Collector pick (S04)
    // -------------------------------------------------------------------------

    /**
     * {@code profile}: {@code batch_throughput}, {@code api_latency}, {@code tiny_heap}.
     * Return: {@code parallel}, {@code zgc}, {@code g1}.
     */
    static String exercise05_pickCollector(String profile) {
        // TODO
        throw new UnsupportedOperationException("TODO: exercise05_pickCollector");
    }

    @Test
    void test05_batchParallel() {
        assertEquals("parallel", exercise05_pickCollector("batch_throughput"));
    }

    @Test
    void test05_apiZgc() {
        assertEquals("zgc", exercise05_pickCollector("api_latency_large_heap"));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 06 — Fix ThreadLocal leak (S06, S08)
    // -------------------------------------------------------------------------

    private static final ThreadLocal<Map<String, String>> REQUEST_CTX = ThreadLocal.withInitial(ConcurrentHashMap::new);

    /**
     * Simulate request filter: set context, run work, then clean up so pool thread does not retain leak.
     */
    static void exercise06_runRequestWithContext(Runnable work) {
        // TODO: set dummy entry, run work, REQUEST_CTX.remove() in finally
        throw new UnsupportedOperationException("TODO: exercise06_runRequestWithContext");
    }

    @Test
    void test06_threadLocalRemoved() {
        exercise06_runRequestWithContext(() -> REQUEST_CTX.get().put("trace", "1"));
        exercise06_runRequestWithContext(() ->
                assertEquals(false, REQUEST_CTX.get().containsKey("trace")));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 07 — Static cache bound (S03, S08)
    // -------------------------------------------------------------------------

    private static final Map<String, byte[]> UNBOUNDED = new ConcurrentHashMap<>();

    /**
     * Replace unbounded put with bounded cache: max {@code maxEntries} keys; evict oldest key when over limit.
     * For capstone simplicity: when size would exceed max, remove arbitrary first key from keySet iterator.
     */
    static int exercise07_putBoundedCache(String key, byte[] value, int maxEntries) {
        // TODO: put into UNBOUNDED; while size > maxEntries remove first key from iterator
        throw new UnsupportedOperationException("TODO: exercise07_putBoundedCache");
    }

    @Test
    void test07_cacheBounded() {
        UNBOUNDED.clear();
        for (int i = 0; i < 100; i++) {
            exercise07_putBoundedCache("k" + i, new byte[10], 10);
        }
        assertEquals(10, exercise07_putBoundedCache("final", new byte[1], 10));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 08 — JIT warmup phrase (S07)
    // -------------------------------------------------------------------------

    /**
     * p99 high first 10 min after deploy, GC normal. Return interview phrase.
     * Expected: {@code "jit warmup"} (case insensitive match in test).
     */
    static String exercise08_postDeployLatencyCause() {
        // TODO: return "jit warmup"
        throw new UnsupportedOperationException("TODO: exercise08_postDeployLatencyCause");
    }

    @Test
    void test08_jitWarmup() {
        assertEquals("jit warmup", exercise08_postDeployLatencyCause().toLowerCase());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 09 — forName initializes? (S06)
    // -------------------------------------------------------------------------

    /**
     * Return {@code true} if API triggers class initialization by default.
     */
    static boolean exercise09_triggersClinit(String api) {
        // TODO: "Class.forName" -> true, "ClassLoader.loadClass" -> false
        throw new UnsupportedOperationException("TODO: exercise09_triggersClinit");
    }

    @Test
    void test09_forNameInit() {
        assertEquals(true, exercise09_triggersClinit("Class.forName"));
    }

    @Test
    void test09_loadClassNoInit() {
        assertEquals(false, exercise09_triggersClinit("ClassLoader.loadClass"));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 10 — Object layout empty size (S02)
    // -------------------------------------------------------------------------

    /**
     * Typical empty object bytes on 64-bit HotSpot with compressed oops (interview answer).
     */
    static int exercise10_emptyObjectBytesTypical() {
        // TODO: return 16
        throw new UnsupportedOperationException("TODO: exercise10_emptyObjectBytesTypical");
    }

    @Test
    void test10_emptyObjectSize() {
        assertEquals(16, exercise10_emptyObjectBytesTypical());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 11 — TLAB purpose (S02)
    // -------------------------------------------------------------------------

    static String exercise11_tlabPurpose() {
        // TODO: return "avoid eden lock" (exact phrase for test)
        throw new UnsupportedOperationException("TODO: exercise11_tlabPurpose");
    }

    @Test
    void test11_tlab() {
        assertEquals("avoid eden lock", exercise11_tlabPurpose());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 12 — Raise Xmx fixes Metaspace? (S05, S06)
    // -------------------------------------------------------------------------

    static boolean exercise12_willRaisingXmxFixMetaspaceOom() {
        // TODO: return false
        throw new UnsupportedOperationException("TODO: exercise12_willRaisingXmxFixMetaspaceOom");
    }

    @Test
    void test12_metaspaceNotHeap() {
        assertEquals(false, exercise12_willRaisingXmxFixMetaspaceOom());
    }
}
