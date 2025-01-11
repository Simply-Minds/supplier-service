# Supplier Servicee

A microservice for managing suppliers as part of the Inventory Management System. This service is responsible for handling all CRUD operations related to suppliers, including creating, retrieving, updating, and deleting supplier information.

## Features
- Add new suppliers to the system.
- Retrieve a list of suppliers with support for filtering and pagination.
- Retrieve detailed information for a specific supplier by ID.
- Update existing supplier details.
- Delete a supplier from the system.
- Link suppliers to products for better inventory management.
- Track supplier details such as contact information, products supplied, and performance.

## Tech Stack

- Java: Version 17 (or specify your version)
- Spring Boot: 3.x
    - Spring Web
    - Spring Data JPA
    - Spring Actuator

- Database: MySQL
- Tools: Maven, Swagger (OpenAPI 3.0), Postman
- Cache: Redis (Optional, if used for stock monitoring)

### Steps to Run the Application

#### 1. Clone the Repository
```shell
git clone https://github.com/<your-organization>/supplier-service.git  

cd supplier-service
```

### 2. Update Application Properties
Update the application.yml or application.properties file with your database credentials:

```properties
# Spring Boot Application Configuration
spring.application.name=supplier-service
server.port=8082

# Database Configuration (MySQL)
spring.datasource.url=jdbc:mysql://localhost:3306/supplier_service?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=#replace with database password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate JPA Configuration
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Logging
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Optional: Cache Configuration (if Redis is used in the future)
```

## Development Guidelines

### Code Quality

- Follow SOLID principles and use design patterns wherever applicable.
- Write unit tests for all service and repository layers.

### Commit Message Format
```shell
<ticket-ID>: Meaningful message describing the change.

Example: IOMS-1005: Updated README.md for supplier-service.
```

### Using profiled application properties file

#### Development Profile: application-dev.properties

```properties
# Spring Boot Application Configuration
spring.application.name=supplier-service-dev
server.port=8083

# Database Configuration (Development - Local MySQL)
spring.datasource.url=jdbc:mysql://localhost:3306/supplier_service_dev?useSSL=false&serverTimezone=UTC
spring.datasource.username=dev_user
spring.datasource.password=#replace with database password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate JPA Configuration
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Logging Configuration
logging.level.root=INFO
logging.level.org.springframework.web=DEBUG

# Optional: Cache Configuration (if Redis is used in the future)
```

#### Enable Profiles in application.properties

To switch between profiles (e.g., dev, prod), you can specify the active profile in the application.properties or as a runtime parameter.

```properties
# Active Profile
spring.profiles.active=dev
```
