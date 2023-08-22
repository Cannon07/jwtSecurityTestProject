# Spring Boot JWT Token Example

This project is a practical exploration of implementing JWT (JSON Web Tokens) authentication in a Spring Boot application. JSON Web Tokens are a widely used standard for securely transmitting information between parties as a JSON object. This project provides a hands-on introduction to the concepts of authentication, token generation, and verification using JWTs.

## Key Features

- **JWT Authentication:** Learn how to integrate JWT-based authentication into a Spring Boot application.
- **Token Generation:** Understand the process of generating JWT tokens containing user information.
- **Token Validation:** Implement token validation to ensure the authenticity and integrity of transmitted data.
- **User Management:** Explore how to manage user data and roles in the context of JWT authentication.
- **API Endpoints:** Set up secure API endpoints that require valid JWT tokens for access.
- **Security Configuration:** Gain insights into Spring Security configurations for JWT-based authentication.

## Technologies Used

- Spring Boot
- Spring Security
- JSON Web Tokens (JWT)
- Java Persistence API (JPA)
- Maven for project management
- RESTful API design principles

## Getting Started

1. Clone the repository to your local machine.
2. Configure your database settings in `application.properties`.
3. Run the application using your preferred IDE or the command line.
4. Access the API endpoints, understanding how JWT tokens are used for authentication.

## API Endpoints

### 1. Register User

**Endpoint:** `POST /api/v1/auth/register`

This endpoint allows users to register by providing their username and password. Upon successful registration, the user's information is stored securely in the database.

#### Request

POST /api/v1/auth/register  
Content-Type: application/json

``` json
{
    "firstName": "new",
    "lastName": "user",
    "email": "newuser@email.com",
    "password": "1234"
}
```
#### Response

HTTP/1.1 200 OK

``` json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuZXd1c2VyQGVtYWlsLmNvbSIsImlhdCI6MTY5MjcyMDA4NCwiZXhwIjoxNjkyNzIxNTI0fQ.HwN99fq4SFZMogv74MerdHJuxuALghLKWsowNerekqo"
}
```

### 2. Authenticate User

**Endpoint:** `POST /api/v1/auth/authenticate`

This endpoint allows users to authenticate by providing their registered username and password. Upon successful authentication, a JWT token is returned, which is required for accessing the authenticated endpoint.

#### Request

POST /api/auth/authenticate  
Content-Type: application/json  

``` json
{
    "email": "newuser@email.com",
    "password": "1234"
}
```
#### Response

HTTP/1.1 200 OK

``` json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuZXd1c2VyQGVtYWlsLmNvbSIsImlhdCI6MTY5MjcyMDA4NCwiZXhwIjoxNjkyNzIxNTI0fQ.HwN99fq4SFZMogv74MerdHJuxuALghLKWsowNerekqo"
}
```

### 3. Authenticated Endpoint

**Endpoint:** `GET /api/v1/demo-controller`

This is a secure endpoint that requires a valid JWT token to access. Users need to include the received token in the request header to access this endpoint.

#### Request

GET /api/v1/demo-controller  
Authorization: Bearer your_generated_jwt_token 

#### Response

HTTP/1.1 200 OK

``` json
{
    "message": "Hello From Secured Endpoint"
}
```


## Usage

This project serves as a hands-on reference for implementing JWT-based authentication in Spring Boot applications. It's designed for developers who want to grasp the core concepts of JWTs and their application in securing RESTful APIs.

## Contributions

Contributions are welcome! If you find any issues or want to enhance the project, feel free to fork the repository and submit pull requests.
