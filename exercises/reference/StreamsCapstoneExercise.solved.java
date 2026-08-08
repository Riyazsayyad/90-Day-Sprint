import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Module 02 — Streams API Capstone Exercise (SOLVED REFERENCE)
 * <p>
 * Riyaz — all 18 tests green (2026-08-09). Stub file for practice:
 * {@code exercises/StreamsCapstoneExercise.java}
 * </p>
 * <p><strong>Next LeetCode (streams collectors):</strong></p>
 * <ul>
 *   <li><a href="https://leetcode.com/problems/top-k-frequent-elements/">LC 347 — Top K Frequent Elements</a> (priority)</li>
 *   <li><a href="https://leetcode.com/problems/group-anagrams/">LC 49 — Group Anagrams</a> (spaced redo)</li>
 *   <li><a href="https://leetcode.com/problems/reorder-data-in-log-files/">LC 937 — Reorder Data in Log Files</a></li>
 * </ul>
 */
public class StreamsCapstoneExercise {

    // -------------------------------------------------------------------------
    // EXERCISE 01 — Lazy evaluation & loop fusion (very common interview)
    // -------------------------------------------------------------------------

    static String exercise01_lazyFusionTrace() {
        StringBuilder trace = new StringBuilder();

        Stream.of(1, 2, 3).filter(n -> {
            if (n > 1) {
                trace.append("F").append(n);
                return true;
            }
            return false;
        }).map(n -> {
            int result = n * 10;
            trace.append("M").append(result);
            return result;
        }).forEach(n -> {});

        return trace.toString();
    }

    @Test
    void test01_lazyFusionTrace() {
        assertEquals("F2M20F3M30", exercise01_lazyFusionTrace());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 02 — Lazy source binding
    // -------------------------------------------------------------------------

    static long exercise02_countAfterLateAdd() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        Stream<Integer> s = list.stream();
        list.add(4);
        return s.count();
    }

    @Test
    void test02_countAfterLateAdd() {
        assertEquals(4L, exercise02_countAfterLateAdd());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 03 — Collectors.toMap duplicate keys
    // -------------------------------------------------------------------------

    record User(String email, String name) {}

    static Map<String, User> exercise03_toMapFirstWins(List<User> users) {
        return users.stream().collect(Collectors.toMap(
                User::email,
                Function.identity(),
                (old, latest) -> old
        ));
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

    static Map<String, Long> exercise04_countByStatus(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::status, Collectors.counting()));
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
     * 2-arg {@code reduce(0, Integer::sum)} works for sum — {@code Integer::sum} is associative
     * and valid combiner. Trap is counting: {@code (a,e) -> a+1} is not a valid combiner on partials.
     * Interview form: {@code reduce(0, Integer::sum, Integer::sum)}.
     */
    static int exercise05_parallelSumOneToN(int n) {
        return IntStream.rangeClosed(1, n).parallel().reduce(0, Integer::sum);
    }

    @Test
    void test05_parallelSumOneToN() {
        assertEquals(500500, exercise05_parallelSumOneToN(1000));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 06 — findFirst vs findAny on ordered parallel stream
    // -------------------------------------------------------------------------

    static OptionalInt exercise06_parallelFindFirstEven() {
        return IntStream.range(0, 1_000_000).parallel().filter(i -> i % 2 == 0).findFirst();
    }

    @Test
    void test06_parallelFindFirstEven() {
        assertEquals(OptionalInt.of(0), exercise06_parallelFindFirstEven());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 07 — Short-circuit: limit + filter
    // -------------------------------------------------------------------------

    static int exercise07_shortCircuitLimitSum() {
        return IntStream.range(1, 11)
                .filter(n -> n % 2 == 0)
                .limit(2)
                .sum();
    }

    @Test
    void test07_shortCircuitLimitSum() {
        assertEquals(6, exercise07_shortCircuitLimitSum());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 08 — flatMap (nested collections)
    // -------------------------------------------------------------------------

    record Customer(String name, List<String> orders) {}

    static List<String> exercise08_flatMapOrderIds(List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.orders.stream())
                .filter(order -> order.startsWith("A"))
                .collect(Collectors.toList());
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

    static Map<Boolean, List<Integer>> exercise09_partitionEvenOdd(List<Integer> input) {
        return input.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
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

    static Map<String, Long> exercise10_safeWordCountParallel(List<String> words) {
        return words.parallelStream().collect(
                Collectors.groupingByConcurrent(word -> word, Collectors.counting())
        );
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

    static List<String> exercise11_distinctSorted(List<String> input) {
        return input.stream().distinct().sorted().collect(Collectors.toList());
    }

    @Test
    void test11_distinctSorted() {
        List<String> in = List.of("c", "b", "a", "b");
        assertEquals(List.of("a", "b", "c"), exercise11_distinctSorted(in));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 12 — joining collector
    // -------------------------------------------------------------------------

    static String exercise12_joinNonBlank(List<String> names) {
        return names.stream()
                .filter(name -> !name.isBlank())
                .collect(Collectors.joining(" | "));
    }

    @Test
    void test12_joinNonBlank() {
        List<String> names = List.of("Amy", "", "  ", "Bob", "Cy");
        assertEquals("Amy | Bob | Cy", exercise12_joinNonBlank(names));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 13 — ConcurrentModificationException
    // -------------------------------------------------------------------------

    static void exercise13_mutateDuringTraversal() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        list.stream().forEach(n -> list.add(n));
    }

    @Test
    void test13_mutateDuringTraversal() {
        assertThrows(ConcurrentModificationException.class, StreamsCapstoneExercise::exercise13_mutateDuringTraversal);
    }

    // -------------------------------------------------------------------------
    // EXERCISE 14 — Top N per group (downstream collector — frequent coding Q)
    // -------------------------------------------------------------------------

    record Sale(String dept, int amount) {}

    static Map<String, List<Integer>> exercise14_top2AmountsPerDept(List<Sale> sales) {
        return sales.stream().collect(Collectors.groupingBy(
                Sale::dept,
                Collectors.collectingAndThen(
                        Collectors.mapping(Sale::amount, Collectors.toList()),
                        list -> list.stream()
                                .sorted((a, b) -> b - a)
                                .limit(2)
                                .collect(Collectors.toList())
                )
        ));
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

    static String exercise15_joinIds(List<Integer> ids) {
        return ids.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    @Test
    void test15_joinIds() {
        assertEquals("10,20,30", exercise15_joinIds(List.of(10, 20, 30)));
    }

    // -------------------------------------------------------------------------
    // EXERCISE 16 — IntStream primitive specialization (boxing trap)
    // -------------------------------------------------------------------------

    static long exercise16_sumOfSquaresPrimitive() {
        return IntStream.range(0, 100).mapToLong(i -> (long) i * i).sum();
    }

    @Test
    void test16_sumOfSquaresPrimitive() {
        assertEquals(328350L, exercise16_sumOfSquaresPrimitive());
    }

    // -------------------------------------------------------------------------
    // EXERCISE 17 — Optional stream pattern
    // -------------------------------------------------------------------------

    static String exercise17_firstLongNameUppercased(List<String> names) {
        return names.stream()
                .filter(name -> name.length() > 3)
                .findFirst()
                .map(String::toUpperCase)
                .orElse("");
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

    static boolean exercise18_allPositive(List<Integer> amounts) {
        return amounts.stream().allMatch(amount -> amount > 0);
    }

    @Test
    void test18_allPositive() {
        assertTrue(exercise18_allPositive(List.of(1, 5, 9)));
        assertEquals(false, exercise18_allPositive(List.of(1, 0, 9)));
    }
}
