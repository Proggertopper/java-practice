# Cleanup and source provenance

## Inputs

- The public `Proggertopper/java-practice` snapshot at commit `200bfc9`.
- The owner's uploaded `JavaRushTasks.rar`: 574 regular files, including 564 `.java` files.

All Java source files from those two supplied inputs were accounted for before sanitization. Exact duplicate copies were represented once; a distinct legacy source variant was retained as a text reference. No completed exercise logic was rewritten to make it appear correct.

The cleaned tree contains **776 `.java` files**, including historical, starter and incomplete examples. That is a file count, not the number of completed tasks.

## Main moves

| Original location | Cleaned location |
| --- | --- |
| Uploaded `JavaRushTasks/javarush/.../src/com/javarush/task` | `javarush/exercises/src/com/javarush/task` |
| Uploaded mini-games | `javarush/games/src/com/javarush/games` |
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

## Not included in the clean tree

- SDK installations, nested `.git` directories, plugin account avatars/logs and local Tomcat server configuration.
- The external `game-engine.jar`; game sources remain, with their dependency requirement documented.
- The default React/Vite counter starter named `pkce-demo-project`; it did not contain a PKCE implementation.
- Git-only placeholder entries for `AllDesignPatternsJava` and `TacoCloud2Parts/taco_cloud2`: **their referenced source repositories were not supplied**. No code was recovered or invented for them.
- Generic root test notes without a clear source dependency.

The `JavaRushTasks` Git-link problem is resolved in this package by including the recovered files directly, without Git metadata. The other two missing Git links are documented rather than advertised as working modules.

## Configuration edits

- Replaced application database passwords and OAuth2 client credentials with environment variables or explicit local-only markers.
- Made the authorization-server demo password require `DEMO_USER_PASSWORD`.
- Removed a **commented**, non-active token-dumping example from the login controller.
- Moved the incomplete `task1701` source to `archive/incomplete-javarush`; no replacement `NoteThread` was invented.

No code was committed or pushed to GitHub. No files in the owner's original Windows folder were touched. The download is a new working-tree copy; it does not replace or contain their Git history.
