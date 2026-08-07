import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Module 02 — Streams API Capstone Exercise
 * <p>
 * Copy this entire file into IntelliJ / java-interview-lab (default package, or rename as needed).
 * Requires JUnit Jupiter 5.x on the classpath.
 * </p>
 * <p>
 * Each exercise has a {@code TODO} stub and a {@code @Test} with the expected result.
 * Implement the stub until all tests pass.
 * </p>
 */
public class StreamsCapstoneExercise {

    // -------------------------------------------------------------------------
    // EXERCISE 01 — Lazy evaluation & loop fusion (very common interview)
    // -------------------------------------------------------------------------

    /**
     * Scenario: {@code Stream.of(1,2,3).filter(n>1).map(n*10)} — trace when terminal runs.
     * <p>Expected trace string: {@code "F2M20F3M30"} (filter then map per element, fused).</p>
     */
    static String exercise01_lazyFusionTrace() {
        // TODO: build pipeline; append "F" + n on filter pass, "M" + (n*10) on map, return trace
        throw new UnsupportedOperationException("TODO: exercise01_lazyFusionTrace");
    }

    @Test
    void test01_lazyFusionTrace() {
        assertEquals("F2M20F3M30", exercise01_lazyFusionTrace());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 02 — Lazy source binding
    // -------------------------------------------------------------------------

    /**
     * Scenario: create stream, mutate list before terminal {@code count()}.
     * <p>Expected: {@code 4} (stream sees list at terminal time, not at stream creation).</p>
     */
    static long exercise02_countAfterLateAdd() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        Stream<Integer> s = list.stream();
        list.add(4);
        // TODO: return s.count()
        throw new UnsupportedOperationException("TODO: exercise02_countAfterLateAdd");
    }

    @Test
    void test02_countAfterLateAdd() {
        assertEquals(4L, exercise02_countAfterLateAdd());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 03 — Collectors.toMap duplicate keys
    // -------------------------------------------------------------------------

    record User(String email, String name) {}

    /**
     * Scenario: two users share email {@code "a@x.com"} — first wins.
     * <p>Expected map: {@code a@x.com -> Alice} only (Bob discarded).</p>
     */
    static Map<String, User> exercise03_toMapFirstWins(List<User> users) {
        // TODO: Collectors.toMap with merge function (old, neu) -> old
        throw new UnsupportedOperationException("TODO: exercise03_toMapFirstWins");
    }

    @Test
    void test03_toMapFirstWins() {
        List<User> users = List.of(
                new User("a@x.com", "Alice"),
                new User("b@x.com", "Bob"),
                new User("a@x.com", "Alicia")
        );
        Map<String, User> map = exercise03_toMapFirstWins(users);
        assertEquals(2, map.size());
        assertEquals("Alice", map.get("a@x.com").name());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 04 — groupingBy + counting (enterprise aggregation)
    // -------------------------------------------------------------------------

    record Order(String status) {}

    /**
     * Scenario: count orders per status.
     * <p>Expected: {@code {PAID=2, PENDING=1}}.</p>
     */
    static Map<String, Long> exercise04_countByStatus(List<Order> orders) {
        // TODO: groupingBy(Order::status, counting())
        throw new UnsupportedOperationException("TODO: exercise04_countByStatus");
    }

    @Test
    void test04_countByStatus() {
        List<Order> orders = List.of(
                new Order("PAID"), new Order("PAID"), new Order("PENDING")
        );
        Map<String, Long> counts = exercise04_countByStatus(orders);
        assertEquals(2L, counts.get("PAID"));
        assertEquals(1L, counts.get("PENDING"));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 05 — Parallel reduce (3-arg combiner)
    // -------------------------------------------------------------------------

    /**
     * Scenario: sum 1..1000 in parallel.
     * <p>Expected: {@code 500500}.</p>
     * <p>Interview trap: 2-arg reduce fails for counting; sum needs associative combiner.</p>
     */
    static int exercise05_parallelSumOneToN(int n) {
        // TODO: IntStream.rangeClosed(1, n).parallel().reduce(0, Integer::sum, Integer::sum)
        throw new UnsupportedOperationException("TODO: exercise05_parallelSumOneToN");
    }

    @Test
    void test05_parallelSumOneToN() {
        assertEquals(500500, exercise05_parallelSumOneToN(1000));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 06 — findFirst vs findAny on ordered parallel stream
    // -------------------------------------------------------------------------

    /**
     * Scenario: ordered parallel stream, first even number.
     * <p>Expected: {@code Optional.of(0)} (encounter order preserved for findFirst).</p>
     */
    static Optional<Integer> exercise06_parallelFindFirstEven() {
        // TODO: IntStream.range(0, 1_000_000).parallel().filter(i -> i % 2 == 0).findFirst()
        throw new UnsupportedOperationException("TODO: exercise06_parallelFindFirstEven");
    }

    @Test
    void test06_parallelFindFirstEven() {
        assertEquals(Optional.of(0), exercise06_parallelFindFirstEven());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 07 — Short-circuit: limit + filter
    // -------------------------------------------------------------------------

    /**
     * Scenario: {@code filter(even).limit(2).sum()} on 1..10.
     * <p>Expected: {@code 6} (2 + 4 only; 6 never evaluated).</p>
     */
    static int exercise07_shortCircuitLimitSum() {
        // TODO
        throw new UnsupportedOperationException("TODO: exercise07_shortCircuitLimitSum");
    }

    @Test
    void test07_shortCircuitLimitSum() {
        assertEquals(6, exercise07_shortCircuitLimitSum());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 08 — flatMap (nested collections)
    // -------------------------------------------------------------------------

    record Customer(String name, List<String> orders) {}

    /**
     * Scenario: flatten all order ids across customers, keep only ids starting with "A".
     * <p>Expected: {@code ["A1", "A2"]} in encounter order.</p>
     */
    static List<String> exercise08_flatMapOrderIds(List<Customer> customers) {
        // TODO: flatMap orders stream, filter startsWith "A", collect toList
        throw new UnsupportedOperationException("TODO: exercise08_flatMapOrderIds");
    }

    @Test
    void test08_flatMapOrderIds() {
        List<Customer> customers = List.of(
                new Customer("Riyaz", List.of("A1", "B9")),
                new Customer("Coach", List.of("A2", "C3"))
        );
        assertEquals(List.of("A1", "A2"), exercise08_flatMapOrderIds(customers));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 09 — partitioningBy
    // -------------------------------------------------------------------------

    /**
     * Scenario: partition integers into even vs odd buckets.
     * <p>Expected evens: {@code [2,4]}, odds: {@code [1,3,5]}.</p>
     */
    static Map<Boolean, List<Integer>> exercise09_partitionEvenOdd(List<Integer> input) {
        // TODO: partitioningBy(n -> n % 2 == 0)
        throw new UnsupportedOperationException("TODO: exercise09_partitionEvenOdd");
    }

    @Test
    void test09_partitionEvenOdd() {
        Map<Boolean, List<Integer>> parts = exercise09_partitionEvenOdd(List.of(1, 2, 3, 4, 5));
        assertEquals(List.of(2, 4), parts.get(true));
        assertEquals(List.of(1, 3, 5), parts.get(false));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 10 — Fix parallel mutable accumulator (classic bug)
    // -------------------------------------------------------------------------

    /**
     * Scenario: broken code uses {@code parallelStream().forEach} on shared {@code HashMap}.
     * <p>Implement thread-safe word frequency using {@code collect(groupingBy, counting())}.</p>
     * <p>Expected: {@code {java=2, stream=2, rocks=1}}.</p>
     */
    static Map<String, Long> exercise10_safeWordCountParallel(List<String> words) {
        // TODO: do NOT mutate HashMap in forEach; use collect
        throw new UnsupportedOperationException("TODO: exercise10_safeWordCountParallel");
    }

    @Test
    void test10_safeWordCountParallel() {
        List<String> words = Arrays.asList("java", "stream", "java", "rocks", "stream");
        Map<String, Long> freq = exercise10_safeWordCountParallel(words);
        assertEquals(2L, freq.get("java"));
        assertEquals(2L, freq.get("stream"));
        assertEquals(1L, freq.get("rocks"));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 11 — distinct + sorted pipeline
    // -------------------------------------------------------------------------

    /**
     * Scenario: dedupe and sort strings.
     * <p>Input: {@code ["c", "b", "a", "b"]}.</p>
     * <p>Expected: {@code ["a", "b", "c"]}.</p>
     */
    static List<String> exercise11_distinctSorted(List<String> input) {
        // TODO: distinct().sorted().collect(toList())
        throw new UnsupportedOperationException("TODO: exercise11_distinctSorted");
    }

    @Test
    void test11_distinctSorted() {
        List<String> in = List.of("c", "b", "a", "b");
        assertEquals(List.of("a", "b", "c"), exercise11_distinctSorted(in));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 12 — joining collector
    // -------------------------------------------------------------------------

    /**
     * Scenario: join names with {@code " | "}, skip blanks.
     * <p>Expected: {@code "Amy | Bob | Cy"}.</p>
     */
    static String exercise12_joinNonBlank(List<String> names) {
        // TODO: filter non-blank, collecting(joining(" | "))
        throw new UnsupportedOperationException("TODO: exercise12_joinNonBlank");
    }

    @Test
    void test12_joinNonBlank() {
        List<String> names = List.of("Amy", "", "  ", "Bob", "Cy");
        assertEquals("Amy | Bob | Cy", exercise12_joinNonBlank(names));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 13 — ConcurrentModificationException
    // -------------------------------------------------------------------------

    /**
     * Scenario: structural modify {@code ArrayList} during sequential {@code forEach}.
     * <p>Expected: {@code ConcurrentModificationException} thrown.</p>
     */
    static void exercise13_mutateDuringTraversal() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        // TODO: list.stream().forEach(n -> list.add(n)) or similar — must throw CME
        throw new UnsupportedOperationException("TODO: exercise13_mutateDuringTraversal");
    }

    @Test
    void test13_mutateDuringTraversal() {
        assertThrows(ConcurrentModificationException.class, StreamsCapstoneExercise::exercise13_mutateDuringTraversal);
    }

    // -------------------------------------------------------------------------
    // EXERCISE 14 — Top N per group (downstream collector — frequent coding Q)
    // -------------------------------------------------------------------------

    record Sale(String dept, int amount) {}

    /**
     * Scenario: per department, keep top 2 sales amounts (descending).
     * <p>Expected IT: {@code [900, 800]}, HR: {@code [500, 400]}.</p>
     */
    static Map<String, List<Integer>> exercise14_top2AmountsPerDept(List<Sale> sales) {
        // TODO: groupingBy(dept, collectingAndThen(
        //           mapping(Sale::amount, toList()),
        //           list -> list.stream().sorted(reverseOrder()).limit(2).collect(toList())))
        throw new UnsupportedOperationException("TODO: exercise14_top2AmountsPerDept");
    }

    @Test
    void test14_top2AmountsPerDept() {
        List<Sale> sales = List.of(
                new Sale("IT", 800), new Sale("IT", 900), new Sale("IT", 100),
                new Sale("HR", 400), new Sale("HR", 500), new Sale("HR", 50)
        );
        Map<String, List<Integer>> top = exercise14_top2AmountsPerDept(sales);
        assertEquals(List.of(900, 800), top.get("IT"));
        assertEquals(List.of(500, 400), top.get("HR"));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 15 — Reduce vs collect (immutable vs mutable reduction)
    // -------------------------------------------------------------------------

    /**
     * Scenario: build comma-separated string of ids without leading/trailing comma.
     * <p>Input ids {@code [10, 20, 30]} — expected {@code "10,20,30"}.</p>
     * <p>Prefer {@code joining} or {@code reduce} with StringBuilder? Use streams only.</p>
     */
    static String exercise15_joinIds(List<Integer> ids) {
        // TODO: ids.stream().map(String::valueOf).collect(joining(","))
        throw new UnsupportedOperationException("TODO: exercise15_joinIds");
    }

    @Test
    void test15_joinIds() {
        assertEquals("10,20,30", exercise15_joinIds(List.of(10, 20, 30)));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 16 — IntStream primitive specialization (boxing trap)
    // -------------------------------------------------------------------------

    /**
     * Scenario: sum squares of 0..99 using primitive stream (no {@code Stream<Integer>}).
     * <p>Expected: {@code 328350} (sum of i*i for i in 0..99).</p>
     */
    static long exercise16_sumOfSquaresPrimitive() {
        // TODO: IntStream.range(0, 100).mapToLong(i -> (long) i * i).sum()
        throw new UnsupportedOperationException("TODO: exercise16_sumOfSquaresPrimitive");
    }

    @Test
    void test16_sumOfSquaresPrimitive() {
        assertEquals(328350L, exercise16_sumOfSquaresPrimitive());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 17 — Optional stream pattern
    // -------------------------------------------------------------------------

    /**
     * Scenario: find first name longer than 3 chars, uppercased, or empty string if none.
     * <p>Input {@code ["Amy", "Bob", "Cy"]} — expected {@code ""} (none &gt; 3).</p>
     * <p>Input with {@code "Riyaz"} — expected {@code "RIYAZ"}.</p>
     */
    static String exercise17_firstLongNameUppercased(List<String> names) {
        // TODO: stream -> filter length>3 -> findFirst -> map uppercase -> orElse("")
        throw new UnsupportedOperationException("TODO: exercise17_firstLongNameUppercased");
    }

    @Test
    void test17_firstLongNameUppercased_none() {
        assertEquals("", exercise17_firstLongNameUppercased(List.of("Amy", "Bob", "Cy")));
    }

    @Test
    void test17_firstLongNameUppercased_found() {
        assertEquals("RIYAZ", exercise17_firstLongNameUppercased(List.of("Amy", "Riyaz", "Bob")));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 18 — Match operations (any / all / none)
    // -------------------------------------------------------------------------

    /**
     * Scenario: verify all transaction amounts are positive.
     * <p>Expected: {@code true} for [1,5,9], {@code false} if any &lt;= 0.</p>
     */
    static boolean exercise18_allPositive(List<Integer> amounts) {
        // TODO: amounts.stream().allMatch(a -> a > 0)
        throw new UnsupportedOperationException("TODO: exercise18_allPositive");
    }

    @Test
    void test18_allPositive() {
        assertTrue(exercise18_allPositive(List.of(1, 5, 9)));
        assertEquals(false, exercise18_allPositive(List.of(1, 0, 9)));
    }
}
