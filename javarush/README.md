# JavaRush practice

Recovered JavaRush learning sources from the supplied local archive, plus an additional GitHub-only task. Original packages under `com.javarush` and task IDs are preserved.

- [`exercises/src`](exercises/src/): 493 Java source files, checked for JDK 17 compilation as a source set. File count is not a count of solved tasks; some tasks contain multiple classes.
- [`games/src`](games/src/): 14 mini-game source files requiring JavaRush's game-engine API. The external game-engine JAR is not redistributed in this cleaned package.
- [`task1701` in archive](../archive/incomplete-javarush/): incomplete exercise referencing the missing `NoteThread` class. It is preserved separately and excluded from the checked exercise source set.

In IntelliJ, open `exercises` and mark `src` as a source root, then run an individual `Solution.main`. Packages remain unchanged, so task IDs are easy to locate. Compilation does not mean platform validators would accept every solution.

For the game examples, use a suitably configured JavaRush environment and obtain dependencies through the course's permitted distribution. The repository does not include the plugin's account folder, avatars, SDK or logs.

Some I/O exercises use file paths or filenames from the original sessions. Supplied fixture files were retained next to their corresponding sources, but environment-specific paths may need adjustment.

This is personal practice with course scaffolding, not an official JavaRush repository. No blanket license for third-party course materials or binaries is implied.
