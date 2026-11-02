# Local configuration and credentials

The cleaned files contain placeholders, not the original application secrets. This is repository hygiene, not a claim that earlier published secrets were revoked.

## Spring Boot / OAuth2

Set the variables required by the application you are running in IntelliJ's run configuration (Environment variables) or in that process's shell:

| Variable | Used for |
| --- | --- |
| `OAUTH_CLIENT_ID` | The selected application's OAuth2 client registration |
| `OAUTH_CLIENT_SECRET` | Its private client secret |
| `DEMO_USER_PASSWORD` | Local authorization-server demo user password |
| `DB_PASSWORD` | Database/Compose password |

Only supply variables used by the selected project. An `.env` file is **not automatically loaded by plain Java or every Spring app**. Docker Compose can use a local `.env`; for other apps use a run environment or a deliberately configured local property source.

The removed legacy Taco Cloud copy previously used additional `DB_URL`, `DB_USERNAME` and `MAIL_PASSWORD` placeholders. Those old settings are not prerequisites for the retained collection. Inspect each remaining application's own files rather than configuring variables from a deleted project.

## Legacy XML examples

`CHANGE_ME_LOCAL_ONLY` in XML and `database.properties` is a manual marker. Older contexts do not all have an environment-property resolver configured. Make a private working copy or add appropriate external configuration before connecting to a database. Do not replace the marker with a real password and commit it.

The supplied database schemas for the Spring examples are not reconstructed here. Do not point these exercises at production databases.

## Previously published values

If any password/client secret in the previous repository was real or reused, **rotate it with its service/provider**. A normal cleanup commit leaves prior values accessible in Git history. Making a repository private also does not undo a leak. History rewriting, if desired, is a separate coordinated operation, not part of this source package.

The full JavaRush collection is maintained separately in [JavaRushTasks](https://github.com/Proggertopper/JavaRushTasks). Toy strings in exercise code are not application configuration; real/reused credentials must never be treated as harmless tutorial data.
