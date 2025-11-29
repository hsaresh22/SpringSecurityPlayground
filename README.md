# SpringSecurityPlayground
Playground to work with Spring Security 

## Tech Stack:
- Spring Boot
- Spring Security
- JWT
- MySQL
- JPA/Hibernate
- Maven

## Features Implemented:
- User Registration and Authentication (Spring Security + JWT)
- Posts Retrieval from DB (Spring Data JPA)
- Password Encryption (BCrypt)
- JWT Token Generation and Validation (jjwt library)
- JWT Filter for Securing Endpoints (OncePerRequestFilter)

## Walkthrough
This project demonstrates user registration and authentication using Spring Security with JWT. 
Users can register, log in to receive a JWT token, and access secured endpoints(Posts) using that token.

In Detail:
1. User Registration:
   - Endpoint: POST /api/auth/register
   - Accepts user details (username, password, email).
   - Passwords are encrypted using BCrypt before storing in the database.
2. User Authentication:
   - Endpoint: POST /api/auth/login
   - Accepts username and password.
   - On successful authentication, generates a JWT token and returns it to user
   - The token contains user information and expiration time.
   - The token is signed using a secret key to prevent tampering.
3. Secured Endpoints:
   - Example Endpoint: GET /api/posts
   - Requires a valid JWT token in the Authorization header (Bearer token).
   - A custom JWT filter (extending OncePerRequestFilter) intercepts requests to validate the token.
   - If the token is valid, the request proceeds; otherwise, a 401 Unauthorized response is returned.
4. Password Encryption:
   - User passwords are hashed using BCrypt before being stored in the database.
   - During authentication, the provided password is compared with the hashed password stored in the database.
   - This ensures that even if the database is compromised, raw passwords are not exposed.
5. JWT Token Handling:
   - The jjwt library is used for generating and validating JWT tokens.
   - Tokens include claims such as username and expiration time.
   - The secret key used for signing tokens should be securely stored (e.g., in environment variables or a secure vault).
   - Tokens are validated on each request to secured endpoints to ensure authenticity and integrity.
   - Tokens have an expiration time to enhance security.
6. Database Integration:
   - MySQL is used as the database to store user and post information.
   - Spring Data JPA is utilized for database operations, providing an abstraction layer over raw SQL queries.
   - Entities are mapped to database tables using JPA annotations.
   - Repositories are created to handle CRUD operations for users and posts.
   - Database connection details are configured in the application.properties file.
   - Ensure that the MySQL server is running and accessible before starting the application. (I used Docker to set mine up)

## Future Enhancements:
- TODO: Role-Based Access Control (RBAC) 

