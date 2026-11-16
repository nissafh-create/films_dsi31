# Films Backend (Spring Boot)

REST API for the Films & Genres Management project.

- **Frontend Repository:** https://github.com/nissafh-create/films_dsi31_angular_frontend
- **Users Microservice (Auth):** https://github.com/nissafh-create/films_dsi31-users-microservice

---

## Features

- **Films CRUD:** RESTful endpoints to create, retrieve, update, and delete films.
- **Genres Management & Projections:** Associated genres with custom projections for optimized responses.
- **Search & Filtering:** Search films by title and filter films by genre.
- **JWT Authorization:** Secured with Spring Security and stateless `JWTAuthorizationFilter` validating tokens issued by the Users Microservice.
- **CORS Support:** Configured for Angular frontend (`http://localhost:4200`).

---

## Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA & Spring Data REST**
- **Spring Security (JWT validation)**
- **MySQL Connector**
- **Maven**

---

## Run

1. Start MySQL Server (running on port 3306).
2. Start the **Users Microservice** first (port `8081`) to handle authentication & tokens.
3. Verify database settings in `src/main/resources/application.properties`.
4. Run the application (port `8080`):
   ```bash
   # Windows
   .\mvnw.cmd spring-boot:run

   # Linux / macOS
   ./mvnw spring-boot:run
   ```
5. Frontend runs on `http://localhost:4200`.
