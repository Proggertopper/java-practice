# Repository scope and cleanup history

## Current scope

At snapshot `4d801e7`, the retained tree contains **217 Java source files**, not 776. The full JavaRush collection is maintained in [JavaRushTasks](https://github.com/Proggertopper/JavaRushTasks). The standalone Taco Cloud application is maintained in [taco-cloud-spring-boot](https://github.com/Proggertopper/taco-cloud-spring-boot), and design-pattern examples are maintained in [design-patterns-java](https://github.com/Proggertopper/design-patterns-java).

The `javarush/` directory and the full `archive/taco-cloud-jdbc-legacy` and `archive/taco-cloud-messaging` copies were removed here after cross-repository comparison. All 507 Java files in the removed JavaRush tree were exact duplicates of files in JavaRushTasks.

Small source-only starters, a four-file early Taco Cloud fragment, one differing old interface as text, and the incomplete `task1701` fragment remain in [archive](../archive/README.md). They are not full runnable copies of those external projects.

The sections below record the **historical initial cleanup**, not the current repository layout or validation scope.

## Inputs

- The public `Proggertopper/java-practice` snapshot at commit `200bfc9`.
- The owner's uploaded `JavaRushTasks.rar`: 574 regular files, including 564 `.java` files.

All Java source files from those two supplied inputs were accounted for before sanitization. Exact duplicate copies were represented once; a distinct legacy source variant was retained as a text reference. No completed exercise logic was rewritten to make it appear correct.

The initial combined tree contained **776 `.java` files**, including historical, starter and incomplete examples. That historical file count is not the number of completed tasks or the current repository size.

## Historical initial moves

| Original location | Cleaned location |
| --- | --- |
| Uploaded JavaRush exercises | Initially included here; now maintained in the separate JavaRushTasks repository |
| Uploaded JavaRush mini-games | Initially included here; now maintained in the separate JavaRushTasks repository |
| Uploaded `IdeaProjects/project1` … `project11` | `java-core/book-exercises/project01` … `project11` |
| `javarushTrainings/javarushTrain` | `java-core/collections-and-concurrency` |
| `IdeaProjects/IdeaProjects/codeForces` | `java-core/streams` |
| `IdeaProjects/IdeaProjects/project1/FileInputOutput/InputOutput` | `java-core/file-io` |
| `IdeaProjects/IdeaProjects/MySimpleServer` | `java-core/networking/socket-server` |
| Eclipse Spring example projects | `spring/core`, `core-advanced`, `aop`, `jdbc`, `orm`, `mvc`, `mvc-orm`, `java-config` |
| `IdeaProjects/IdeaProjects/SpringInner` | `spring/internals` |
| `IdeaProjects/PureSpring/APIServer` and `Client` | `spring-security/authorization-server` and `oauth2-client` |
| `auth-code-flow` OAuth2 examples | `spring-security/` |
| `auth-code-flow/JUnit5AndMockito` | `testing/junit5-mockito` |
| `kafka/producer`, `kafka/consumer` | `messaging/kafka/producer`, `messaging/kafka/consumer` |
| `PureSpring/PostgresConnection1` | `persistence/postgres-spring-boot` |
| Other starter/legacy sources | `archive/` |

Original Java package declarations and internal project resource layouts were kept. The outer duplicate `IdeaProjects/IdeaProjects` structure was not retained. This was selective consolidation, not deletion of all files under that path.

## Excluded during initial cleanup

- SDK installations, nested `.git` directories, plugin account avatars/logs and local Tomcat server configuration.
- The external `game-engine.jar`; the game sources now live in the separate JavaRushTasks repository.
- The default React/Vite counter starter named `pkce-demo-project`; it did not contain a PKCE implementation.
- Git-only placeholder entries for `AllDesignPatternsJava` and `TacoCloud2Parts/taco_cloud2`: **their referenced source repositories were not supplied**. No code was recovered or invented for them.
- Generic root test notes without a clear source dependency.

The initial JavaRushTasks Git-link problem was resolved by recovering its files from the uploaded archive. After deduplication, that full collection is no longer part of this repository. The separate design-pattern and Taco Cloud repositories are linked above rather than included as unresolved Git-link entries.

## Configuration edits

- Replaced application database passwords and OAuth2 client credentials with environment variables or explicit local-only markers.
- Made the authorization-server demo password require `DEMO_USER_PASSWORD`.
- Removed a **commented**, non-active token-dumping example from the login controller.
- Moved the incomplete `task1701` source to `archive/incomplete-javarush`; no replacement `NoteThread` was invented.

The original cleanup was prepared in a separate working-tree copy without modifying the owner's Windows source folder. The owner subsequently published it and removed duplicated sections. Credential cleanup in current files does not erase previously committed values; real/reused credentials still require rotation.
