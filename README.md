# Agri-Mart

## Overview
AgriMart is a digital platform designed to empower farmers by facilitating the rental and sale of agricultural equipment. Built as a full-stack web application using **Spring Boot**, **PostgreSQL**, and **Thymeleaf**, it connects farmers directly, eliminating middlemen and promoting sustainable farming practices.  

Users can list equipment for rent or sale, browse available products, process payments via UPI, and review order history. This project showcases skills in backend development, database management, version control, and frontend design.

---

## Features
- **User Authentication:** Secure login and registration for farmers and buyers.
- **Product Listing:** Farmers can list equipment with details like product name, model, company, year, description, location, and images.
- **Product Browsing:** Search and filter products by type (rent/sale) with visual previews.
- **Payment Integration:** UPI payment support with a summary page and "Pay Now" functionality.
- **Order History:** View past orders with status updates (e.g., "Order Being Processed").
- **Responsive Design:** Mobile-friendly interface using HTML and CSS.

---

## Technologies Used
- **Backend:** Spring Boot (RESTful APIs, controllers, services, security)
- **Database:** PostgreSQL (users, products, orders, payments)
- **Build Tool:** Maven
- **Version Control:** Git & GitHub
- **Frontend:** Thymeleaf, HTML5, CSS3
- **Programming Paradigm:** Java OOP (encapsulation, inheritance, polymorphism)

---

## Project Structure
![File Structure](githubimages/filestructure.png)

---

## Development Process

1. **Project Initialization**  
   - Created using [Spring Initializr](https://start.spring.io) with dependencies: Spring Web, Spring Data JPA, Spring Security, Thymeleaf, PostgreSQL Driver, Lombok, DevTools.  
   - Imported into IntelliJ IDEA.

2. **Database Setup**  
   - PostgreSQL database `agrimart` created locally.  
   - Configured connection in `application.properties`.  

![Database](githubimages/database.png)

3. **Core Implementation**  
   - **Models:** Defined JPA entities in `Model/`.  
   - **Repositories:** JpaRepository interfaces in `Repo/`.  
   - **Services:** Business logic in `Service/`.  
   - **Controllers:** RESTful endpoints in `Controller/`.

4. **Configuration**  
   - CORS settings in `Config/CorsConfig.java`.  
   - Security setup in `Security/`.

5. **Frontend Development**  
   - Dynamic templates using Thymeleaf (`templates/`).  
   - Styled with CSS (`static/`) with green-themed buttons and cards.  
   - Forms for listing equipment and payments.

6. **Static Resources & Images**  
   - Stored in `static/Uploads` and `githubimages/`.  
   - Implemented image upload and serving functionality.

7. **Version Control**  
   - Git repository initialized.  
   - Code pushed to GitHub repository `AgriMart`.

8. **Testing & Debugging**  
   - Unit and integration tests in `test/`.  
   - Debugging via IntelliJ IDEA.

9. **Running the Application**  
   - Run `BackendApplication` class in IntelliJ IDEA.  
   - Access at `http://localhost:8080`.

---

## Setup and Installation

```bash
# Clone the repository
git clone https://github.com/yourusername/AgriMart.git
cd AgriMart/Backend

# Ensure PostgreSQL is installed and 'agrimart' database is created
# Update application.properties with DB credentials

# Open in IntelliJ IDEA, resolve Maven dependencies
# Run the application
Access the app at http://localhost:<your-port>.

Screenshots
Home Pages


Products Page

Listing Form

Payment Summary

Order History

About Page

Contributing
Contributions are welcome! Please fork the repository and submit a pull request. For major changes, open an issue first to discuss.

Contact
For questions or feedback, reach out via GitHub issues or email at sadhanalavenkat372@gmail.com.

---

If you want, I can also **optimize it with badges** (Java, Maven, PostgreSQL) and **better visual layout** so it looks professional on GitHub.  

Do you want me to do that?






