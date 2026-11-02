# Java Practice

My Java learning collection: core-language exercises, Spring experiments, OAuth2 examples, messaging and testing.

The repository records learning progress rather than one finished application. Small console exercises sit alongside independent Maven projects; earlier and incomplete experiments are kept in [`archive/`](archive/) instead of being presented as complete features.

## Explore by topic

| Section | Contents | Start here |
| --- | --- | --- |
| **Java Core** | OOP, interfaces, generics, annotations, threads, synchronization, collections, streams, I/O and sockets | [`java-core/`](java-core/README.md) |
| **Spring fundamentals** | XML and Java configuration, DI, lifecycle examples, AOP, JDBC, ORM and MVC | [`spring/`](spring/README.md) |
| **Spring Security / OAuth2** | Authorization-server, OAuth2-client, login and client-credentials experiments | [`spring-security/`](spring-security/README.md) |
| **Kafka / messaging** | Producer/consumer and Spring Cloud Stream function examples | [`messaging/kafka/`](messaging/kafka/README.md) |
| **Testing** | JUnit 5 and Mockito practice | [`testing/junit5-mockito/`](testing/junit5-mockito/README.md) |
| **PostgreSQL setup** | Spring Boot / Compose configuration experiment | [`persistence/postgres-spring-boot/`](persistence/postgres-spring-boot/README.md) |
| **Earlier work** | Small starters, incomplete sources and a preserved reference variant | [`archive/`](archive/README.md) |

## Related repositories

Course solutions and standalone applications are maintained separately instead of being copied into this collection:

- [JavaRushTasks](https://github.com/Proggertopper/JavaRushTasks) — JavaRush exercises and mini-games.
- [taco-cloud-spring-boot](https://github.com/Proggertopper/taco-cloud-spring-boot) — the standalone Taco Cloud learning application.
- [design-patterns-java](https://github.com/Proggertopper/design-patterns-java) — design-pattern examples.
- [sql-practice](https://github.com/Proggertopper/sql-practice) — SQL schemas, exercises and queries.

The small incomplete fragments retained in `archive/` are not additional copies of those full projects.

## Selected examples

- [Collections and concurrency](java-core/collections-and-concurrency/src/): duplicate counting, first unique character, grouping by length, set intersection, `AtomicInteger` and `CompletableFuture`.
- [Streams](java-core/streams/src/): processing nested order/item data with `flatMap` and transformations.
- [Spring internals](spring/internals/): custom annotations, bean post-processors, proxy-based profiling and lifecycle experiments.
- [Spring JDBC](spring/jdbc/): DAO and row-mapping practice.
- [JUnit / Mockito](testing/junit5-mockito/): parameterized tests, assertions, mocking and interaction verification.

## How to run

```bash
git clone https://github.com/Proggertopper/java-practice.git
cd java-practice
```

**Do not compile or import the whole repository as one Java source module.** Examples intentionally reuse class names such as `Main` and `Solution`. Open the individual project you want to study.

### Plain Java exercises

Use JDK 17 for the checked Java Core examples. In IntelliJ IDEA, open the selected example folder, configure a JDK, mark its `src` directory as a Sources Root if necessary, and run the desired `main` method. Some examples need console input, local files or a service; inspect the source before running it.

For a simple standalone example, from the repository root:

```bash
javac -encoding UTF-8 -d .practice-out java-core/collections-and-concurrency/src/AtomicCounterExample.java
java -cp .practice-out AtomicCounterExample
```

The counter example starts two threads and prints `200000` twice. `System.gc()` in the original exercise is not a guarantee of garbage collection.

### Maven / Spring projects

Open the selected project's `pom.xml` in IntelliJ and use the JDK required by that POM. The original projects target different versions, including **17, 21 and 24**; there is no single root Maven build. Some older POMs do not explicitly pin a compiler release and may need local toolchain setup.

Where Maven Wrapper is included, run `./mvnw test` in Git Bash/Linux/macOS or `mvnw.cmd test` in Windows Command Prompt from that project folder. Otherwise use an installed Maven. This describes the invocation, not a guarantee that every historical project builds or that all tests pass.

Spring database projects need a matching local database/schema. OAuth2 and Kafka examples need their external services and configuration. See section READMEs and [configuration notes](docs/configuration.md) before starting them.

## Checked status

- **15 Java Core source sets** compiled separately with JDK 17.
- Eight smoke assertions passed for the collection helper methods; the counter and future examples were also executed.
- Spring/OAuth2/Kafka integration and the entire JUnit/Mockito suite were **not** executed as part of cleanup.

These checks establish a limited baseline, not correctness of every exercise or independent completion of every task. They concern the retained examples, not the separate JavaRush repository. See [validation details](docs/validation.md).

## Learning notes and provenance

The material comes from my learning projects and course/book exercises. Original package names, task IDs, comments and algorithm implementations are largely preserved. Course-provided scaffolding and exercise text remain attributable to their original authors; this repository is not an official answer collection or an endorsement by a course provider.

Repository organization, credential placeholders and documentation were prepared with AI assistance. Duplicate JavaRush sources and two full legacy Taco Cloud copies were subsequently removed from this collection. A differing old `OrderRepository.java` remains as a text reference in `archive/`, not a runnable duplicate project. See [cleanup and source mapping](docs/cleanup.md).

## Adding new practice

Add new work to the appropriate topic folder. For a new independent console exercise, give it its own folder and source root; for an existing example, edit that example. Include the task, a small input/output example and a note about edge cases when useful. Add tests where they help, not artificial commits for activity counts.

Never commit SDK installations, IDE caches, generated classes, real credentials or production data. Configuration placeholders in the cleaned tree do **not** remove secrets already committed in previous history; rotate any real/reused credentials.

## Author

**Oleksandr Kosynskyi** — Java/backend developer in training

- [GitHub](https://github.com/Proggertopper)
- [LinkedIn](https://www.linkedin.com/in/oleksandr-kosynskyi-java/)
