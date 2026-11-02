# Spring Security / OAuth2 experiments

| Folder | Role |
| --- | --- |
| [`authorization-server`](authorization-server/) | Authorization-server configuration and local authentication examples |
| [`oauth2-client`](oauth2-client/) | OAuth2 login/client interaction and API requests |
| [`oauth2-login-demo`](oauth2-login-demo/) | Separate OAuth2-login learning application |
| [`client-credentials/client`](client-credentials/client/) | Client-credentials/proxy experiment |
| [`client-credentials/pure-client`](client-credentials/pure-client/) | A smaller client-credentials example |
| [`client-credentials/resource`](client-credentials/resource/) | Resource-server example; original Java package spelling is preserved |

These are **independent learning setups**, not one fully wired system. Check each POM and configuration for its JDK, server ports, issuer URLs, registration IDs and endpoint paths. External identity-provider registrations or matching local services are required where referenced.

Client IDs/secrets in the cleaned configuration use `OAUTH_CLIENT_ID` and `OAUTH_CLIENT_SECRET`. Set them in the run configuration/environment; do not commit actual values. The local authorization-server demo additionally requires `DEMO_USER_PASSWORD`. The same environment-variable names across independent apps do not imply that they should share one production registration.

A commented token-dumping demonstration was removed from the login example; it was not an active endpoint. Do not print bearer tokens to logs. These demos are not a security audit or production-ready authorization architecture.

The old React/Vite counter starter named `pkce-demo-project` was excluded because its source did not implement a PKCE client. Two separately referenced Git repositories were unavailable; see [cleanup notes](../docs/cleanup.md).
