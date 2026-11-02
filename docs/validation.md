# Validation of the cleaned source tree

The compilation checks below were repeated with **OpenJDK 17.0.20** against the retained Java Core sources in snapshot `4d801e7` while updating this documentation. The runtime smoke checks were performed during the earlier cleanup on unchanged copies of those example sources. Compiler outputs and temporary harness files are not shipped in the repository.

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

Every source set was compiled separately with UTF-8 encoding and its own output folder. No broad single-source-root build was attempted for the whole repository.

`archive/incomplete-javarush` retains one unfinished `task1701` fragment that references a missing `NoteThread`. It is not included in the checked Java Core source sets. The full JavaRush collection and its former compilation result are outside the current repository's scope; see [JavaRushTasks](https://github.com/Proggertopper/JavaRushTasks).

## Limited runtime checks

- `AtomicCounterExample`: ran successfully, printing `200000` twice.
- `FutureExample`: ran successfully and printed the asynchronous message.
- A temporary assertion harness checked eight cases across `FindDuplicates`: duplicate counting, empty input, first unique character, no unique character, grouping by length and set intersection. All eight passed. This harness is preparation-time QA, not a shipped JUnit suite.

## Structural checks

- All 46 XML/POM files remaining in snapshot `4d801e7` parsed as well-formed XML; that does not validate Spring namespace semantics or Maven dependency resolution.
- The initial cleanup accounted for Java files from both original inputs. A later deduplication removed the full JavaRush tree and two old Taco Cloud copies; [cleanup notes](cleanup.md) distinguish the historical and current layouts. One differing old source variant remains as a text reference.
- Reviewed application credential assignments were replaced with environment placeholders or local-only markers. This was a targeted hygiene review, **not a comprehensive security audit**.

## Not verified

Spring/Maven builds, JDK 21/24 projects, OAuth2 flows, Kafka delivery, MySQL/PostgreSQL behavior, servlet-container deployment, historical archive fragments and the complete JUnit/Mockito suite were not run. Compilation alone does not prove an exercise is logically correct.
