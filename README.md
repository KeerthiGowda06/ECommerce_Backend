📄 README.md — E-Commerce Backend (Spring Boot + MySQL)

# 🛒 E-Commerce Backend  
### Built with Spring Boot 3 + Java 21 + JPA + MySQL

This backend powers the full-stack E-Commerce application.  
It provides secure REST APIs for user authentication, product management, orders, reviews, and admin roles.

---

## 🚀 Features

### 👤 User Module
- Register new users  
- Login via email + password  
- Get user details  
- Update / delete user  

### 🛍 Product Module
- Add new products  
- Get all products  
- Get product by ID  
- Filter products by category  
- Update / delete products  

### 📦 Order Module
- Place new order  
- Auto-calculate total  
- Reduce stock on purchase  
- Get orders of a user  
- View order details  
- Delete order  

### ⭐ Review Module
- Add product review  
- Delete review  

### 🧑‍💼 Admin Module (Hardcoded)
- Manager  
- Supervisor  
- Agent  

Admins are stored in-memory (no DB entry required).

---

# 🗂️ Project Structure

src/main/java/com/example/ECommerce │── controller/        # REST controllers │── services/          # Business logic │── entity/            # JPA entities │── Repository/        # JPA repositories │── Dto/               # Request models

---

# 🛢 Database Setup (MySQL)

Create the database:

```sql
CREATE DATABASE ECommerce;

Add this to application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/ECommerce
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


---

📌 API Endpoints

👤 User APIs

POST   /api/users              → Register user
POST   /api/users/login        → Login user
GET    /api/users/{id}         → Get user by ID
DELETE /api/users/{id}         → Delete user


---

🛍 Product APIs

GET    /api/products                       → Get all products
POST   /api/products                       → Create new product
GET    /api/products/{id}                  → Get product details
PUT    /api/products/{id}                  → Update product
DELETE /api/products/{id}                  → Delete product
GET    /api/products/category/{category}   → Filter products


---

📦 Order APIs

POST   /api/orders               → Place an order
GET    /api/orders/user/{id}     → Get user's orders
GET    /api/orders/{id}          → Get order details
DELETE /api/orders/{id}          → Delete order


---

⭐ Review APIs

POST   /api/reviews         → Add review
DELETE /api/reviews/{id}    → Delete review


---

▶️ Running the Backend

Using Maven:

mvn clean install
mvn spring-boot:run

Server starts at:

http://localhost:8080


---

🧪 Testing (Postman)

Import the following flows:

1️⃣ Register → Login
2️⃣ Add products
3️⃣ Get all products
4️⃣ Create order
5️⃣ Get user orders
6️⃣ View single order
7️⃣ Add review


---

📸 Recommended Extra Features (Future Enhancements)

JWT authentication

Admin dashboard

Image upload for products

Payment gateway integration

Email notifications



---

👨‍💻 Author

Keerthi G L
GitHub: https://github.com/KeerthiGowda06


---

📜 License

MIT License © 2025
