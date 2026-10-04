# Mission: Spring Boot Internals

## Why
You are targeting Senior Backend / SWE II roles where “I use Spring” is not enough. Interviewers and production incidents require you to explain IoC, bean lifecycle, auto-configuration, transaction proxies, the servlet request path, and when *not* to choose WebFlux — so you can debug NoSuchBean, silent @Transactional, and thread-pool vs DB-pool latency without folklore.

## Success looks like
- Explain IoC vs DI and defend constructor injection without listing annotations.
- Walk ApplicationContext refresh: definitions → instances → init → singleton cache.
- Debug missing/duplicate beans via scan, profiles, conditions, @Primary/@Qualifier.
- Describe auto-config as imports file + conditions + OnMissingBean back-off; use --debug.
- Draw Caller → proxy → @Transactional; name self-invocation and rollback defaults.
- Map HTTP: Tomcat worker → Filter → DispatcherServlet → Controller; size against Hikari.
- Choose liveness vs readiness; lock down Actuator; pick MVC±VT vs WebFlux with a decision tree.

## Constraints
- Build on Modules 00–04 (OOP, collections, streams, concurrency including virtual threads, JVM diagnostics).
- Prefer Spring Framework / Spring Boot official docs over blog folklore. Java 21+ and Boot 3.2+ conventions.
- Interview + production debugging first; annotation encyclopedias second.

## Out of scope (for now)
- Hibernate/SQL internals — Module 06.
- Full Spring Security filter graph, Prometheus/Grafana install, Spring Cloud Gateway.
- AspectJ load-time weaving, R2DBC tutorials, StepVerifier encyclopedia.

---

<details>
<summary>Previous mission: Concurrency & Threads (completed)</summary>

Lessons `concurrency-0001`–`concurrency-0008` and capstone remain in this workspace.
</details>

<details>
<summary>Previous mission: JVM & Memory Management (completed)</summary>

Lessons `jvm-0001`–`jvm-0008` and capstone remain in this workspace.
</details>

<details>
<summary>Previous mission: Core Java & OOP (completed)</summary>

Lessons `oop-0001`–`oop-0015` and related references remain in this workspace.
</details>

<details>
<summary>Previous mission: Java Collection Internals (completed)</summary>

Lessons 7–16 and related references remain in this workspace.
</details>
