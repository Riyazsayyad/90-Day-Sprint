import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
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
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Solved reference — Module 03 Concurrency Capstone. Do not paste until you have attempted the stubs.
 */
public class ConcurrencyCapstoneExercise {

    static int exercise01_atomicCounter(int threads, int timesEach) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        CountDownLatch done = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < timesEach; j++) {
                    counter.incrementAndGet();
                }
                done.countDown();
            }).start();
        }
        done.await(10, TimeUnit.SECONDS);
        return counter.get();
    }

    static String exercise02_volatileGuarantees() {
        return "visibility not atomicity";
    }

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

        new Thread(task).start();
        new Thread(task).start();
        start.countDown();
        done.await(5, TimeUnit.SECONDS);
        return loadCount.get();
    }

    static int exercise04_chmComputeIfAbsentLoadCount() throws InterruptedException {
        ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
        AtomicInteger loadCount = new AtomicInteger();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(2);

        Runnable task = () -> {
            try {
                start.await();
                cache.computeIfAbsent("k", key -> {
                    loadCount.incrementAndGet();
                    return "v";
                });
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                done.countDown();
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        start.countDown();
        done.await(5, TimeUnit.SECONDS);
        return loadCount.get();
    }

    static int exercise05_tryLockIncrementOrSkip(ReentrantLock lock, AtomicInteger metric) {
        if (lock.tryLock()) {
            try {
                return metric.incrementAndGet();
            } finally {
                lock.unlock();
            }
        }
        return -1;
    }

    static boolean exercise06_abortPolicyRejects() throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1, 1, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.AbortPolicy());
        CountDownLatch blocker = new CountDownLatch(1);
        pool.execute(() -> {
            try {
                blocker.await(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        pool.execute(() -> {
        });
        boolean rejected = false;
        try {
            pool.execute(() -> {
            });
        } catch (RejectedExecutionException e) {
            rejected = true;
        }
        blocker.countDown();
        pool.shutdownNow();
        pool.awaitTermination(2, TimeUnit.SECONDS);
        return rejected;
    }

    static int exercise07_blockingQueueSum(int n) throws InterruptedException {
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(n);
        AtomicInteger sum = new AtomicInteger();
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    sum.addAndGet(q.take());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        consumer.start();
        for (int i = 1; i <= n; i++) {
            q.put(i);
        }
        consumer.join(5_000);
        return sum.get();
    }

    static List<String> exercise08_thenComposePipeline(int userId) {
        return CompletableFuture
                .supplyAsync(() -> loadUserId(userId))
                .thenCompose(id -> loadOrdersAsync(id))
                .join();
    }

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

    static int exercise09_exceptionallyFallback() {
        return CompletableFuture
                .<Integer>supplyAsync(() -> {
                    throw new RuntimeException("pricing down");
                })
                .exceptionally(ex -> 0)
                .join();
    }

    static int exercise10_allOfSum() {
        CompletableFuture<Integer> a = fetchServiceA();
        CompletableFuture<Integer> b = fetchServiceB();
        CompletableFuture<Integer> c = fetchServiceC();
        return CompletableFuture.allOf(a, b, c)
                .thenApply(v -> a.join() + b.join() + c.join())
                .join();
    }

    static String exercise11_joinRootCauseMessage() {
        CompletableFuture<Void> f = CompletableFuture.runAsync(() -> {
            throw new IllegalStateException("downstream");
        });
        try {
            f.join();
            return "";
        } catch (CompletionException e) {
            return e.getCause().getMessage();
        }
    }

    static boolean exercise12_orTimeoutFails() {
        CompletableFuture<Void> slow = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        slow.orTimeout(50, TimeUnit.MILLISECONDS);
        try {
            slow.join();
            return false;
        } catch (CompletionException e) {
            return e.getCause() instanceof java.util.concurrent.TimeoutException;
        }
    }

    static boolean exercise13_gracefulShutdown() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(() -> {
        });
        pool.shutdown();
        return pool.awaitTermination(2, TimeUnit.SECONDS);
    }

    static boolean exercise14_runUsesCurrentThread() {
        AtomicReference<Thread> runner = new AtomicReference<>();
        Runnable r = () -> runner.set(Thread.currentThread());
        Thread t = new Thread(r);
        t.run();
        return runner.get() == Thread.currentThread();
    }

    static boolean exercise15_virtualThreadIsVirtual() {
        return Thread.ofVirtual().unstarted(() -> {
        }).isVirtual();
    }

    static String exercise16_identifyPinningConstruct() {
        return "synchronized";
    }

    @Test
    void smoke() {
        assertEquals(10_000, exercise01_atomicCounter(10, 1_000));
    }
}
