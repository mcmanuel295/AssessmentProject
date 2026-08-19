# Assessment Application

A Spring Boot application for managing boxes and their items through a REST API.

## Prerequisites

- Java 21 or later
- MySQL
- A MySQL database for the application

## Configuration

Before starting the application, update `src/main/resources/application.yaml` with the MySQL connection details:

```yaml
spring:
  datasource:
    username: your-mysql-username
    password: your-mysql-password
    url: jdbc:mysql://localhost:3306/your-database-name
```

The application uses port `8080` by default.

## Build

Using the Maven Wrapper on Windows:

```powershell
.\mvnw.cmd clean package -DskipTests
```

Using the Maven Wrapper on macOS or Linux:

```bash
./mvnw clean package -DskipTests
```

The packaged JAR is created in `target/`.

## Run

Run directly with Spring Boot on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Run directly with Spring Boot on macOS or Linux:

```bash
./mvnw spring-boot:run
```

Alternatively, run the packaged JAR:

```bash
java -jar target/AssessmentApplication-0.0.1-SNAPSHOT.jar
```

Once started, the application is available at:

```text
http://localhost:8080
```

The REST API is rooted at `/boxes`.
