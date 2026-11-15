# Two Spring Boot Apps with Postgres and Docker

Communication with two apps(ServiceA and ServiceB)

## Instructions to run 
* [Docker](https://docker.com) and Docker Compose
* (without Docker) JDK 21+ and Maven/Gradle

---

## Quickstart with Docker Compose

1. **Clone github repo**
   ```bash
      git clone https://github.com/Proggertopper/java-practice.git
      cd java-practice/testTasksForJavaDeveloper
   ```
   
2. **Enter variables for .env file**
   Create .env file in the root of project or copy of .env-example
   ```bash
   cp .env.example .env
   ```
   Example of `.env`:
   ```env
   POSTGRES_DB=testDB
   POSTGRES_USER=postgres
   POSTGRES_PASSWORD=postgres

   DB_URL=jdbc:postgresql://postgres:5432/testDB
   DB_USERNAME=postgres
   DB_PASSWORD=postgres
   JWT_SECRET=your_secret_key
   ```
   
3. **Build jars in order to docker compose**
   *For auth-api app*
    ```bash 
    mvn -f auth-api/pom.xml clean package -DskipTests
    ```
   *For data-api app*
    ```bash
    mvn -f data-api/pom.xml clean package -DskipTests
   ```
4. **Run the containers:**
   ```bash 
    docker compose up -d --build
   ```

5. **Stop project**
    ```bash
    docker compose down
   ```
   if you want delete data too add flag -v to command above

---

**API Examples to test**

***Register and Login User with saving token in response***
`POST /api/auth/register` and `POST /api/auth/login`

**Linux / macOS /Git Bash**
```bash 
    curl -X POST http://localhost:8080/api/auth/register \
    -H "Content-Type: application/json" \
    -d "{"email":"a@a.com","password":"pass"}"
   ```
```bash
    curl -X POST http://localhost:8080/api/auth/login \
     -H "Content-Type: application/json" \
     -d "{"email":"a@a.com","password":"pass"}"
   ```
***Save token from response***

***Process endpoint***
`POST /api/process`

**Linux / macOS /Git Bash**
```bash 
   curl -X POST http://localhost:8080/api/process \
   -H "Authorization: Bearer <token>" \
   -H "Content-Type: application/json" \
   -d "{"text":"hello"}"
   ```

 ***Expected: { "result": "transformed text" } and a row in processing_log***

