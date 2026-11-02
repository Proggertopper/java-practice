# Spring learning projects

Each folder is a separate Maven project. Original Java packages and internal resource layout are retained.

| Project | Practice |
| --- | --- |
| [`core`](core/) | XML beans, constructor/property injection, collections and lifecycle examples |
| [`core-advanced`](core-advanced/) | Autowiring, interfaces and property-placeholder experiments |
| [`java-config`](java-config/) | Java-based Spring configuration |
| [`aop`](aop/) | Aspect and service-method examples |
| [`internals`](internals/) | BeanPostProcessor, custom annotations, profiling/proxies and context lifecycle |
| [`jdbc`](jdbc/) | JDBC template, DAO and row mapping |
| [`orm`](orm/) | Spring/Hibernate ORM examples |
| [`mvc`](mvc/) | Servlet/Spring MVC examples |
| [`mvc-orm`](mvc-orm/) | Web MVC and ORM integration practice |

Open the desired `pom.xml`, inspect dependencies and select a compatible JDK. Older examples mix historical `javax` APIs and newer Spring dependencies; they are retained as learning experiments, not guaranteed current production templates.

The database examples require local MySQL setup. Hard-coded database passwords in copied XML/properties were replaced with `CHANGE_ME_LOCAL_ONLY`. This is an intentionally non-secret marker, **not a working password**. Configure a private local copy and keep credentials out of commits; see [configuration notes](../docs/configuration.md).

Local Eclipse/Tomcat server configuration was excluded. The MVC samples need an appropriately configured servlet container/application setup; they are not automatically deployable just because their sources are present.

XML files were parsed for well-formedness. Maven dependency resolution, full compilation and database/container integration were not verified during repository cleanup.
