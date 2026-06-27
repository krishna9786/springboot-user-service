# Spring Boot User Service

A production-style User Management REST API built with Spring Boot, JWT Authentication, PostgreSQL, AWS EC2, AWS RDS, Docker, and GitHub Actions CI/CD.

## Features

* User Registration
* User Login with JWT Authentication
* Password Encryption using BCrypt
* User CRUD Operations
* Pagination and Sorting
* Global Exception Handling
* Swagger/OpenAPI Documentation
* PostgreSQL Database Integration
* Docker Support
* AWS EC2 Deployment
* AWS RDS PostgreSQL Database
* GitHub Actions CI/CD Pipeline

---

## Architecture

```text
Client
   │
   ▼
Spring Boot REST API (AWS EC2)
   │
   ▼
PostgreSQL Database (AWS RDS)
```

### Deployment Architecture

```text
Git Push
   │
   ▼
GitHub Actions
   │
   ▼
Build & Test
   │
   ▼
Deploy to AWS EC2
   │
   ▼
Spring Boot Application
   │
   ▼
AWS RDS PostgreSQL
```

---

## Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Hibernate
* JWT Authentication

### Database

* PostgreSQL
* AWS RDS

### DevOps

* Docker
* GitHub Actions
* AWS EC2

### Documentation

* Swagger OpenAPI

---

## Setup

### Clone Repository

```bash
git clone https://github.com/krishna9786/springboot-user-service.git
cd springboot-user-service
```

### Configure Database

Update:

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

### Run Application

```bash
./mvnw spring-boot:run
```

---

## Deployment

### AWS Infrastructure

* EC2 Instance
* Amazon Linux 2023
* PostgreSQL RDS
* Security Groups
* GitHub Actions CI/CD

### Build

```bash
./mvnw clean package
```

### Run

```bash
java -jar target/user-service-0.0.1-SNAPSHOT.jar
```

---

## API Endpoints

### Authentication

| Method | Endpoint       | Description   |
| ------ | -------------- | ------------- |
| POST   | /auth/register | Register User |
| POST   | /auth/login    | Login User    |

### Users

| Method | Endpoint    | Description    |
| ------ | ----------- | -------------- |
| GET    | /users      | Get All Users  |
| GET    | /users/{id} | Get User By ID |
| PUT    | /users/{id} | Update User    |
| DELETE | /users/{id} | Delete User    |

---

## Swagger Documentation

Swagger UI:

```text
[http://<EC2-IP>:8080/swagger-ui/index.html](http://13.51.169.147:8080/swagger-ui/index.html)
```

OpenAPI Docs:

```text
[http://<EC2-IP>:8080/v3/api-docs](http://13.51.169.147:8080/v3/api-docs)
```

---

## CI/CD Pipeline

GitHub Actions automatically:

1. Builds the application
2. Runs tests
3. Creates JAR artifact
4. Deploys to AWS EC2
5. Restarts the application

---

## Author

Krishna

GitHub: https://github.com/krishna9786
LinkedIn: www.linkedin.com/in/krishna9786
