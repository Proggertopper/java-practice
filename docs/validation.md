# Validation of the cleaned source tree

Checks performed with **OpenJDK 17.0.20** on the prepared working-tree copy. Compiler outputs and temporary harness files are not shipped in the repository.

## Compilation

| Source set | Java files | Result |
| --- | ---: | --- |
| `java-core/collections-and-concurrency/src` | 5 | Compiled |
| `java-core/streams/src` | 4 | Compiled |
| `java-core/file-io/src` | 3 | Compiled |
| `java-core/networking/socket-server/src` | 1 | Compiled; server not started |
| `java-core/book-exercises/project01/src` | 7 | Compiled |
| `java-core/book-exercises/project02/src` | 14 | Compiled |
| `java-core/book-exercises/project03/src` | 2 | Compiled |
| `java-core/book-exercises/project04/src` | 3 | Compiled |
| `java-core/book-exercises/project05/src` | 3 | Compiled |
| `java-core/book-exercises/project06/src` | 5 | Compiled |
| `java-core/book-exercises/project07/src` | 3 | Compiled |
| `java-core/book-exercises/project08/src` | 5 | Compiled |
| `java-core/book-exercises/project09/src` | 2 | Compiled |
| `java-core/book-exercises/project10/src` | 2 | Compiled |
| `java-core/book-exercises/project11/src` | 5 | Compiled |
| `javarush/exercises/src` | 493 | Compiled |

Every source set was compiled separately with UTF-8 encoding and its own output folder. No broad single-source-root build was attempted for the whole repository.

`task1701` originally prevented compilation because `NoteThread` was absent. The original source was moved to `archive/incomplete-javarush`; it remains incomplete and is not part of the passing exercise source set.

## Limited runtime checks

- `AtomicCounterExample`: ran successfully, printing `200000` twice.
- `FutureExample`: ran successfully and printed the asynchronous message.
- A temporary assertion harness checked eight cases across `FindDuplicates`: duplicate counting, empty input, first unique character, no unique character, grouping by length and set intersection. All eight passed. This harness is preparation-time QA, not a shipped JUnit suite.

## Structural checks

- All 49 original XML/POM files in the cleaned set parsed as well-formed XML; that does not validate Spring namespace semantics or Maven dependency resolution.
- The source mapping checked that Java files from both inputs were either retained or represented by an exact duplicate; the one distinct legacy source variant is retained as a text reference.
- Reviewed application credential assignments were replaced with environment placeholders or local-only markers. This was a targeted hygiene review, **not a comprehensive security audit**.

## Not verified

Spring/Maven builds, JDK 21/24 projects, OAuth2 flows, Kafka delivery, MySQL/PostgreSQL behavior, servlet-container deployment, JavaRush game-engine execution, all historical archive fragments and the complete JUnit/Mockito suite were not run. Compilation alone does not prove a course solution is logically correct or accepted by a platform validator.
