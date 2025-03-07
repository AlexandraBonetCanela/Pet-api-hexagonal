# 🐾 Pet API (Hexagonal Architecture version)  

## 🎯 Overview  
Welcome to the **Pet API**, a modern **Spring Boot-based** REST API for managing virtual pets. This API follows a **Hexagonal Architecture** approach, ensuring a modular and maintainable design by separating the **domain logic**, **infrastructure**, and **application layers**.  

There is also an MVC version of this project that you can find [here](https://github.com/AlexandraBonetCanela/Pet-api-mvc)

## 🚀 Key Features  
✅ **Hexagonal Architecture** – Decoupled design for scalability and testability.  
✅ **Pet Management** – Create, update, delete, and track virtual pets with persistent storage.  
✅ **User System** – Pets are associated with users, enabling personalized experiences.  
✅ **Persistence with JPA** – Uses **Spring Data JPA** with **MySQL** for robust storage.  
✅ **Domain-Driven Design (DDD)** – Clear separation of concerns with **ports & adapters**.  
✅ **RESTful API Design** – Fully documented with **OpenAPI (Swagger)** for easy integration.  
✅ **Unit & Integration Tested** – Ensures reliability with **JUnit and Mockito**.  

---

### **🛠 Technologies**  
- **Java 21**  
- **Maven 3.6.3**  
- **Spring Boot 3.4.1**  
- **MySQL 9.1.0**  

### **📦 Dependencies**  
- **Spring Web**  
- **Spring Data JPA**  
- **Lombok**  
- **Swagger (Springdoc OpenAPI)**  
- **JUnit 5**  
- **Mockito**  

---

## 📖 **Architecture Overview**  

```mermaid
flowchart TD
    A[Client] -->|REST API| B[Pet API]
    B -->|Handles Pet Requests| C[PetRESTController]
    C -->|Calls Application Logic| D[PetService]
    D -->|Interacts with Domain Layer| E[PetRepositoryPort]
    E -->|Persistence Logic| F[PetRepositoryImpl]
    F -->|Stores Data| G[(MySQL)]

```
## To run a project:

Move to the base folder of the project you want to run and:


- Compile the project
```bash
mvn compile
```
- Pack the project
```bash
mvn package
```
- Clean the project
```bash
mvn clean
```
- Execute the application
```bash
mvn spring-boot:run
```
### For API endpoints and usage, refer to the **Swagger UI**:
```sh
http://localhost:8080/swagger-ui.html
```

![Captura de pantalla 2025-03-07 a les 9 08 09](https://github.com/user-attachments/assets/11d5c2cd-2363-4ad8-bde5-fbe9af568398)

