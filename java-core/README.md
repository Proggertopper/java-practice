# Java Core

Independent source sets. Open/compile one example at a time; repeated class names are intentional.

| Folder | Focus |
| --- | --- |
| [`collections-and-concurrency`](collections-and-concurrency/) | Collections helper methods, atomic counter, CompletableFuture and an HTTP-request example |
| [`streams`](streams/) | Orders/items, `flatMap` and stream transformations |
| [`file-io`](file-io/) | File/string/stream experiments and equality/hashCode practice |
| [`networking/socket-server`](networking/socket-server/) | A small blocking HTTP/socket experiment; it listens on port 81, not a hardened web server |
| [`olympiad`](olympiad/) | Earlier standalone Maven practice; POM requests Java 24 |
| [`book-exercises/project01`](book-exercises/project01/) | Packages, inheritance and command-line examples |
| [`book-exercises/project02`](book-exercises/project02/) | Mixed OOP, comparator, collection and numeric exercises |
| [`book-exercises/project03`](book-exercises/project03/) | Numeric/matrix experiments |
| [`book-exercises/project04`](book-exercises/project04/) | Interfaces and callbacks |
| [`book-exercises/project05`](book-exercises/project05/) | Stack interfaces/implementation and polynomial practice |
| [`book-exercises/project06`](book-exercises/project06/) | Annotations, reflection-related snippets and threads |
| [`book-exercises/project07`](book-exercises/project07/) | Synchronization examples |
| [`book-exercises/project08`](book-exercises/project08/) | Producer/consumer and shared-state examples |
| [`book-exercises/project09`](book-exercises/project09/) | Thread examples |
| [`book-exercises/project10`](book-exercises/project10/) | File I/O |
| [`book-exercises/project11`](book-exercises/project11/) | Generics and assertions |

The 11 original numbered exercise folders remain recognizable. Extra GitHub-only files were merged only where filenames did not conflict. `project11/projects/src` is a separate old experiment and is not part of the checked `project11/src` source root.

JDK 17 compilation passed for the 11 `src` roots and four selected standalone roots, but most examples were not executed. Some request input, start threads, access files or make network requests. Do not run all `main` methods automatically.

Several examples retain original hard-coded sample paths; update those paths for your machine when needed. Empty/stub files are preserved as learning history rather than described as complete features.
