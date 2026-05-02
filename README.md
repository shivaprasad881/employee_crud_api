# Employee CRUD API - Spring Boot

A simple Spring Boot REST API for managing employees using:
- Spring Web
- Spring Data JPA
- H2 Database
- Bean Validation
- Global Exception Handling

## Project Structure

```text
employee-crud-api/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/com/example/employeeapi/
        │   ├── EmployeeCrudApiApplication.java
        │   ├── controller/EmployeeController.java
        │   ├── entity/Employee.java
        │   ├── exception/GlobalExceptionHandler.java
        │   ├── exception/ResourceNotFoundException.java
        │   ├── repository/EmployeeRepository.java
        │   └── service/EmployeeService.java
        └── resources/
            ├── application.properties
            └── data.sql
```

## How to Run

### Prerequisites
- Java 17+
- Maven 3.8+

### Run commands
```bash
mvn clean install
mvn spring-boot:run
```

Application runs at:
```text
http://localhost:8080
```

## API Endpoints

### 1. Get all employees
```http
GET /api/employees
```

### 2. Get employee by id
```http
GET /api/employees/{id}
```

### 3. Create employee
```http
POST /api/employees
Content-Type: application/json

{
  "name": "Jane Doe",
  "email": "jane@example.com",
  "department": "Marketing"
}
```

### 4. Update employee
```http
PUT /api/employees/{id}
Content-Type: application/json

{
  "name": "Jane Updated",
  "email": "jane.updated@example.com",
  "department": "Sales"
}
```

### 5. Delete employee
```http
DELETE /api/employees/{id}
```

## Sample curl commands

### Get all employees
```bash
curl -X GET http://localhost:8080/api/employees
```

### Get employee by id
```bash
curl -X GET http://localhost:8080/api/employees/1
```

### Create employee
```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"name":"Priya","email":"priya@example.com","department":"IT"}'
```

### Update employee
```bash
curl -X PUT http://localhost:8080/api/employees/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Priya Sharma","email":"priya.sharma@example.com","department":"Admin"}'
```

### Delete employee
```bash
curl -X DELETE http://localhost:8080/api/employees/1
```

## Bonus Features Added
- `@NotBlank` validation
- `@Email` validation
- `@ControllerAdvice` global exception handling
- Preloaded sample employee records
