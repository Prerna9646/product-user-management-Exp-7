#  User & Product Management System (Spring Boot + JWT)

A secure REST API project built using **Spring Boot**, **Spring Security**, and **JWT Authentication**.  
This project allows users to register, login, and perform CRUD operations on products with secured endpoints.

---

##  Features

-  User Registration & Login (JWT authentication)
-  Secure APIs using Spring Security
-  User CRUD Operations
-  Product CRUD Operations
-  Input Validation using Jakarta Validation
-  Global Exception Handling
-  H2 In-Memory Database (for testing)

---

##  Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- H2 Database
- Maven
- Lombok

---

##  Project Structure


<img width="516" height="666" alt="project structure" src="https://github.com/user-attachments/assets/aa51f407-8d9b-4e5e-af28-83355a06cf96" />

---

##  Authentication Flow

1. Register a user  
2. Login using credentials  
3. Receive JWT Token  
4. Use token in headers to access protected APIs  


---

##  API Endpoints

###  User APIs

| Method | Endpoint | Description |
|--------|---------|------------|
| POST | `/api/user/register` | Register new user |
| POST | `/api/user/login` | Login & get token |
| GET | `/api/user/all` | Get all users |
| GET | `/api/user/{id}` | Get user by ID |
| PUT | `/api/user/update/{id}` | Update user |
| DELETE | `/api/user/delete/{id}` | Delete user |

---

###  Product APIs (Protected)

| Method | Endpoint | Description |
|--------|---------|------------|
| POST | `/api/products/add` | Add product |
| GET | `/api/products/all` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| PUT | `/api/products/update/{id}` | Update product |
| DELETE | `/api/products/delete/{id}` | Delete product |

---

##  Sample Request

###  Login

POST /api/user/login
```json
{
  "email": "prerna@gmail.com",
  "password": "Prer@123"
}
```

Response

```txt
Bearer <token>
```
### How to Run
1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Run DemoApplication.java
4. Use Postman to test APIs

### Future Improvements
Role-Based Authorization (Admin/User)
Product Search & Filtering
Pagination
Image Upload for Products
Swagger UI Integration

## Output
1. Registered User


    <img width="668" height="545" alt="create user" src="https://github.com/user-attachments/assets/fe50dec5-9e42-4f93-9013-63f8bfda96f5" />

2. Login User
 

   <img width="669" height="546" alt="Login User" src="https://github.com/user-attachments/assets/b0b1a19a-3277-4c87-9218-7ac151d2e7b1" />

3. Get all the users


   <img width="664" height="599" alt="get all users" src="https://github.com/user-attachments/assets/64de8353-7171-45a6-a938-05ffa5fbd218" />

4. Get user by id


   <img width="668" height="479" alt="Get user by id" src="https://github.com/user-attachments/assets/8a230acf-4933-4684-b09c-dfc4844d0d0f" />

5. Update user details


    <img width="653" height="543" alt="update user" src="https://github.com/user-attachments/assets/376623d9-f50d-4119-915d-2c7f68e51023" />

6. Delete user
  
   
   <img width="667" height="418" alt="delete user" src="https://github.com/user-attachments/assets/7efbedb9-81b5-427a-bb2f-b4dd1a799986" />

7. Add product
 
   
   <img width="647" height="523" alt="product created" src="https://github.com/user-attachments/assets/7d3a0a1a-9b81-4493-82a2-f4c3769a321b" />

8. Get all the added products
  
   
   <img width="664" height="640" alt="Get all products" src="https://github.com/user-attachments/assets/2d093d02-da97-4c1a-86b0-2a6789be776e" />

9. Get product info by id
  
   
   <img width="656" height="490" alt="get product by id" src="https://github.com/user-attachments/assets/56f32b19-9f0e-4a4a-8d4c-fc6d1d0594f5" />

10. Update product details


    <img width="652" height="543" alt="update product" src="https://github.com/user-attachments/assets/19108c0e-c9b6-4c60-b962-2061d2c48f99" />

11. Delete a product info


    <img width="655" height="354" alt="delete product" src="https://github.com/user-attachments/assets/8f528f64-1ab3-4d7e-818e-bc4af7671bbb" />

---
### Author
Prerna
CSE Student | 23BCS80341
