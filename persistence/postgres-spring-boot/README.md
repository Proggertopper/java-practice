# PostgreSQL / Spring Boot setup experiment

This folder preserves the original Spring Boot starter and Compose configuration used for local PostgreSQL connection practice. Its presence does not imply a completed persistence/business layer.

Open [pom.xml](pom.xml) with JDK 21. Review [compose.yaml](compose.yaml), ports and database name before starting Docker/Compose. Set `DB_PASSWORD` in the process environment or a private `.env` file next to Compose; it is intentionally not supplied.

Automatic Compose integration and database connectivity were not executed during cleanup. If application datasource configuration is needed, provide it through an ignored local override or the IDE run environment. Never use real application credentials as tutorial defaults.
