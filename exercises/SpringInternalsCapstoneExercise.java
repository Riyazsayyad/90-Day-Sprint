import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Module 05 — Spring Boot Internals Capstone Exercise.
 * Copy into IntelliJ. JUnit Jupiter 5.x. Maps to spring-0001 … spring-0009.
 */
public class SpringInternalsCapstoneExercise {

    /** {@code scan}, {@code condition}, {@code both} */
    static String exercise01_missingBeanCause(boolean outsideScan, boolean propertyDisabled) {
        throw new UnsupportedOperationException("TODO: exercise01_missingBeanCause");
    }

    @Test
    void test01_bothCauses() {
        assertEquals("both", exercise01_missingBeanCause(true, true));
    }

    @Test
    void test01_scanOnly() {
        assertEquals("scan", exercise01_missingBeanCause(true, false));
    }

    /** {@code primary}, {@code qualifier}, {@code list}, {@code fail} */
    static String exercise02_resolution(int candidateCount, boolean hasPrimary, boolean hasQualifier) {
        throw new UnsupportedOperationException("TODO: exercise02_resolution");
    }

    @Test
    void test02_fail() {
        assertEquals("fail", exercise02_resolution(2, false, false));
    }

    @Test
    void test02_qualifier() {
        assertEquals("qualifier", exercise02_resolution(2, true, true));
    }

    /** {@code proxy}, {@code self} — did @Transactional advice run? */
    static String exercise03_txPath(boolean calledViaThis) {
        throw new UnsupportedOperationException("TODO: exercise03_txPath");
    }

    @Test
    void test03_self() {
        assertEquals("self", exercise03_txPath(true));
    }

    /** {@code backoff}, {@code create}, {@code missing_class} */
    static String exercise04_dataSource(boolean userBean, boolean jdbcOnClasspath) {
        throw new UnsupportedOperationException("TODO: exercise04_dataSource");
    }

    @Test
    void test04_backoff() {
        assertEquals("backoff", exercise04_dataSource(true, true));
    }

    @Test
    void test04_create() {
        assertEquals("create", exercise04_dataSource(false, true));
    }

    /** {@code db_pool}, {@code cpu}, {@code add_tomcat_only} — first diagnosis bucket */
    static String exercise05_latency(int tomcatBusy, int hikariMax, int cpuPercent) {
        throw new UnsupportedOperationException("TODO: exercise05_latency");
    }

    @Test
    void test05_pool() {
        assertEquals("db_pool", exercise05_latency(200, 20, 15));
    }
}
