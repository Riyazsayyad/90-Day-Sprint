import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Module 03 — Concurrency &amp; Threads Capstone Exercise
 * <p>
 * Copy into IntelliJ / java-interview-lab. Requires JUnit Jupiter 5.x.
 * Java 21+ recommended (Exercises 15–16 use virtual threads).
 * </p>
 * <p>
 * Each {@code TODO} maps to lessons concurrency-0001 … concurrency-0008.
 * Implement until all tests pass.
 * </p>
 */
public class ConcurrencyCapstoneExercise {

    // -------------------------------------------------------------------------
    // EXERCISE 01 — Lost update race (S01 + S06 atomics)
    // -------------------------------------------------------------------------

    /**
     * Scenario: {@code threads} workers each increment a shared counter {@code timesEach} times.
     * Plain {@code int} races — fix with {@link AtomicInteger}.
     * <p>Expected: {@code threads * timesEach} exactly.</p>
     */
    static int exercise01_atomicCounter(int threads, int timesEach) throws InterruptedException {
        // TODO: AtomicInteger, latch, ExecutorService or Thread.start/join
        throw new UnsupportedOperationException("TODO: exercise01_atomicCounter");
    }

    @Test
    void test01_atomicCounter() throws InterruptedException {
        assertEquals(10_000, exercise01_atomicCounter(10, 1_000));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 02 — volatile visibility vs atomicity (S03)
    // -------------------------------------------------------------------------

    /**
     * Scenario: interview trap — {@code volatile} on a field. What does it guarantee?
     * <p>Return exact phrase: {@code "visibility not atomicity"}</p>
     */
    static String exercise02_volatileGuarantees() {
        // TODO: return the correct interview phrase (no code execution needed)
        throw new UnsupportedOperationException("TODO: exercise02_volatileGuarantees");
    }

    @Test
    void test02_volatileGuarantees() {
        assertEquals("visibility not atomicity", exercise02_volatileGuarantees());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 03 — Check-then-act race on HashMap (S02 + S06)
    // -------------------------------------------------------------------------

    /**
     * Scenario: two threads lazy-load key {@code "k"} into a plain {@code HashMap} without sync.
     * Return how many times the loader ran (expect &gt; 1 — demonstrates the bug).
     */
    static int exercise03_unsafeLazyLoadPutCount() throws InterruptedException {
        Map<String, String> cache = new java.util.HashMap<>();
        AtomicInteger loadCount = new AtomicInteger();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(2);

        Runnable task = () -> {
            try {
                start.await();
                if (!cache.containsKey("k")) {
                    loadCount.incrementAndGet();
                    cache.put("k", "v");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                done.countDown();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        start.countDown();
        done.await(5, TimeUnit.SECONDS);

        // TODO: return loadCount.get() — do NOT fix the race; expose it
        throw new UnsupportedOperationException("TODO: exercise03_unsafeLazyLoadPutCount");
    }

    @Test
    void test03_unsafeLazyLoadPutCount() throws InterruptedException {
        assertTrue(exercise03_unsafeLazyLoadPutCount() > 1, "race should double-load without sync");
    }

    // -------------------------------------------------------------------------
    // EXERCISE 04 — CHM computeIfAbsent fixes lazy load (S06)
    // -------------------------------------------------------------------------

    /**
     * Scenario: same two-thread lazy load, but {@link ConcurrentHashMap#computeIfAbsent}.
     * <p>Expected loader invocations: {@code 1}</p>
     */
    static int exercise04_chmComputeIfAbsentLoadCount() throws InterruptedException {
        ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
        AtomicInteger loadCount = new AtomicInteger();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(2);

        Runnable task = () -> {
            try {
                start.await();
                // TODO: cache.computeIfAbsent("k", key -> { loadCount.incrementAndGet(); return "v"; });
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                done.countDown();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        start.countDown();
        done.await(5, TimeUnit.SECONDS);

        throw new UnsupportedOperationException("TODO: exercise04_chmComputeIfAbsentLoadCount");
    }

    @Test
    void test04_chmComputeIfAbsentLoadCount() throws InterruptedException {
        assertEquals(1, exercise04_chmComputeIfAbsentLoadCount());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 05 — ReentrantLock tryLock skip (S04)
    // -------------------------------------------------------------------------

    /**
     * Scenario: metrics increment — if lock busy, skip sample (return {@code -1}), else increment and return new value.
     */
    static int exercise05_tryLockIncrementOrSkip(ReentrantLock lock, AtomicInteger metric) {
        // TODO: tryLock in try/finally — unlock only if acquired
        throw new UnsupportedOperationException("TODO: exercise05_tryLockIncrementOrSkip");
    }

    @Test
    void test05_tryLockIncrementOrSkip() {
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger metric = new AtomicInteger(0);
        assertEquals(1, exercise05_tryLockIncrementOrSkip(lock, metric));
        lock.lock();
        try {
            assertEquals(-1, exercise05_tryLockIncrementOrSkip(lock, metric));
        } finally {
            lock.unlock();
        }
        assertEquals(1, metric.get());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 06 — ThreadPoolExecutor AbortPolicy (S05)
    // -------------------------------------------------------------------------

    /**
     * Scenario: core=1, max=1, queue capacity 1 — submit 3 tasks, third rejects.
     * Return {@code true} if third {@code execute} throws {@link RejectedExecutionException}.
     */
    static boolean exercise06_abortPolicyRejects() throws InterruptedException {
        // TODO: build ThreadPoolExecutor with ArrayBlockingQueue(1), AbortPolicy, submit 3 blocking tasks
        throw new UnsupportedOperationException("TODO: exercise06_abortPolicyRejects");
    }

    @Test
    void test06_abortPolicyRejects() throws InterruptedException {
        assertTrue(exercise06_abortPolicyRejects());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 07 — BlockingQueue handoff (S05 + S06)
    // -------------------------------------------------------------------------

    /**
     * Scenario: producer {@code put}s values 1..n; consumer {@code take}s and sums.
     * <p>Expected sum: {@code n*(n+1)/2}</p>
     */
    static int exercise07_blockingQueueSum(int n) throws InterruptedException {
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(n);
        // TODO: producer thread put 1..n, consumer thread take until n items, return sum
        throw new UnsupportedOperationException("TODO: exercise07_blockingQueueSum");
    }

    @Test
    void test07_blockingQueueSum() throws InterruptedException {
        assertEquals(55, exercise07_blockingQueueSum(10));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 08 — CompletableFuture thenCompose (S07)
    // -------------------------------------------------------------------------

    /**
     * Scenario: load user id, then async load orders for that user — flat pipeline.
     * <p>Expected orders: {@code List.of("o1", "o2")}</p>
     */
    static List<String> exercise08_thenComposePipeline(int userId) {
        // TODO: supplyAsync user -> thenCompose to orders CF; join at end
        throw new UnsupportedOperationException("TODO: exercise08_thenComposePipeline");
    }

    @Test
    void test08_thenComposePipeline() {
        assertEquals(List.of("o1", "o2"), exercise08_thenComposePipeline(42));
    }

    // Stub clients for Ex 08–12
    static int loadUserId(int id) {
        return id;
    }

    static CompletableFuture<List<String>> loadOrdersAsync(int userId) {
        return CompletableFuture.completedFuture(List.of("o1", "o2"));
    }

    static CompletableFuture<Integer> fetchServiceA() {
        return CompletableFuture.completedFuture(10);
    }

    static CompletableFuture<Integer> fetchServiceB() {
        return CompletableFuture.completedFuture(20);
    }

    static CompletableFuture<Integer> fetchServiceC() {
        return CompletableFuture.completedFuture(30);
    }

    // -------------------------------------------------------------------------
    // EXERCISE 09 — exceptionally fallback (S07)
    // -------------------------------------------------------------------------

    /**
     * Scenario: failing CF returns fallback price {@code 0} via {@code exceptionally}.
     */
    static int exercise09_exceptionallyFallback() {
        CompletableFuture<Integer> failing = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("pricing down");
        });
        // TODO: exceptionally return 0, join
        throw new UnsupportedOperationException("TODO: exercise09_exceptionallyFallback");
    }

    @Test
    void test09_exceptionallyFallback() {
        assertEquals(0, exercise09_exceptionallyFallback());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 10 — allOf fan-in (S07)
    // -------------------------------------------------------------------------

    /**
     * Scenario: parallel fetch A,B,C — sum results when all complete.
     * <p>Expected: {@code 60}</p>
     */
    static int exercise10_allOfSum() {
        // TODO: CompletableFuture.allOf + join each
        throw new UnsupportedOperationException("TODO: exercise10_allOfSum");
    }

    @Test
    void test10_allOfSum() {
        assertEquals(60, exercise10_allOfSum());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 11 — join unwrap CompletionException (S07)
    // -------------------------------------------------------------------------

    /**
     * Scenario: failed CF — {@code join()} throws {@link CompletionException}.
     * Return root cause message.
     */
    static String exercise11_joinRootCauseMessage() {
        CompletableFuture<Void> f = CompletableFuture.runAsync(() -> {
            throw new IllegalStateException("downstream");
        });
        // TODO: join in try/catch CompletionException, return getCause().getMessage()
        throw new UnsupportedOperationException("TODO: exercise11_joinRootCauseMessage");
    }

    @Test
    void test11_joinRootCauseMessage() {
        assertEquals("downstream", exercise11_joinRootCauseMessage());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 12 — orTimeout (S07, Java 9+)
    // -------------------------------------------------------------------------

    /**
     * Scenario: slow task exceeds timeout — {@code orTimeout} completes exceptionally.
     * Return {@code true} if join throws {@link CompletionException} with {@link java.util.concurrent.TimeoutException} cause.
     */
    static boolean exercise12_orTimeoutFails() {
        CompletableFuture<Void> slow = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        // TODO: slow.orTimeout(50, TimeUnit.MILLISECONDS); catch CompletionException on join
        throw new UnsupportedOperationException("TODO: exercise12_orTimeoutFails");
    }

    @Test
    void test12_orTimeoutFails() {
        assertTrue(exercise12_orTimeoutFails());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 13 — Graceful shutdown (S05)
    // -------------------------------------------------------------------------

    /**
     * Scenario: submit one task, {@code shutdown()}, {@code awaitTermination} — return {@code true} if finished in 2s.
     */
    static boolean exercise13_gracefulShutdown() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        // TODO: submit short task, shutdown(), awaitTermination(2, SECONDS)
        throw new UnsupportedOperationException("TODO: exercise13_gracefulShutdown");
    }

    @Test
    void test13_gracefulShutdown() throws InterruptedException {
        assertTrue(exercise13_gracefulShutdown());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 14 — start() vs run() (S01)
    // -------------------------------------------------------------------------

    /**
     * Scenario: {@code new Thread(r).run()} — does {@code r} run on a new OS thread?
     * <p>Return {@code true} if {@code r} executed on the <em>calling</em> thread (run trap).</p>
     */
    static boolean exercise14_runUsesCurrentThread() {
        AtomicReference<Thread> runner = new AtomicReference<>();
        Runnable r = () -> runner.set(Thread.currentThread());
        Thread t = new Thread(r);
        // TODO: call t.run() (not start), return runner.get() == Thread.currentThread()
        throw new UnsupportedOperationException("TODO: exercise14_runUsesCurrentThread");
    }

    @Test
    void test14_runUsesCurrentThread() {
        assertTrue(exercise14_runUsesCurrentThread());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 15 — Virtual thread identity (S08, Java 21+)
    // -------------------------------------------------------------------------

    /**
     * Scenario: {@link Thread#ofVirtual()} — return {@code true} if created unstarted thread {@code isVirtual()}.
     */
    static boolean exercise15_virtualThreadIsVirtual() {
        // TODO: Thread.ofVirtual().unstarted(() -> {}).isVirtual()
        throw new UnsupportedOperationException("TODO: exercise15_virtualThreadIsVirtual");
    }

    @Test
    void test15_virtualThreadIsVirtual() {
        assertTrue(exercise15_virtualThreadIsVirtual());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 16 — Pinning awareness (S08 + S04)
    // -------------------------------------------------------------------------

    /**
     * Scenario: which synchronization style pins a virtual thread carrier?
     * Given snippets, return {@code "synchronized"} or {@code "reentrantLock"} for the pinning one.
     */
    static String exercise16_identifyPinningConstruct() {
        // Snippet A: synchronized (this) { db.query(); }
        // Snippet B: lock.lock(); try { db.query(); } finally { lock.unlock(); }
        // TODO: return "synchronized"
        throw new UnsupportedOperationException("TODO: exercise16_identifyPinningConstruct");
    }

    @Test
    void test16_identifyPinningConstruct() {
        assertEquals("synchronized", exercise16_identifyPinningConstruct());
    }
}
