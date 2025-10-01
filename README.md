# Agri-Mart
Overview
AgriMart is a digital platform designed to empower farmers by facilitating the rental and sale of agricultural equipment. Built as a full-stack web application using Spring Boot, PostgreSQL, and Thymeleaf, it connects farmers directly, eliminating middlemen and promoting sustainable farming practices. Users can list equipment for rent or sale, browse available products, process payments via UPI, and review order history. This project showcases skills in backend development, database management, version control, and frontend design.

Features
User Authentication: Secure login and registration for farmers and buyers.
Product Listing: Farmers can list equipment with details like product name, model, company, year, description, location, and images.
Product Browsing: Search and filter products by type (rent/sale) with visual previews.
Payment Integration: UPI payment support with a summary page and "Pay Now" functionality.
Order History: View past orders with status updates (e.g., "Order Being Processed").
Responsive Design: Mobile-friendly interface using HTML and CSS.

Technologies Used

Backend: Spring Boot (for RESTful APIs, controllers, services, and security).
Database: PostgreSQL (for storing user data, products, orders, and payments).
Build Tool: Maven (for dependency management and project builds).
Version Control: Git and GitHub (for code repository and collaboration).
Frontend: Thymeleaf (template engine), HTML5, CSS3 (for UI components like forms, cards, and navigation).
Programming Paradigm: Java OOP (encapsulation, inheritance, polymorphism in models and services).

Project Structure
textAgriMart/
├── .idea/                              # IntelliJ IDEA project files
├── Backend/
│   ├── .mvn/                          # Maven wrapper files
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com.example/
│   │   │   │       ├── Config/         # Configuration classes (e.g., CorsConfig)
│   │   │   │       ├── Controller/     # Controllers for handling requests
│   │   │   │       ├── Model/          # Entities (e.g., Product, User)
│   │   │   │       ├── Repo/           # Repositories (e.g., ProductRepo)
│   │   │   │       ├── Security/       # Security configurations
│   │   │   │       ├── Service/        # Business logic
│   │   │   │       └── BackendApplication.java  # Main application entry point
│   │   │   └── resources/
│   │   │       ├── static/             # CSS, JS, and images
│   │   │       ├── templates/          # Thymeleaf HTML templates
│   │   │       └── application.properties  # Configuration (e.g., database settings)
│   │   └── test/                       # Unit and integration tests
│   ├── target/                         # Build output
│   ├── .gitattributes                  # Git attributes
│   └── .gitignore                      # Git ignore file
Development Process
Below is a step-by-step overview of how AgriMart was developed, tailored to the observed project structure and typical workflows.
1. Project Initialization

The project was set up using Spring Initializr (via start.spring.io) with dependencies including Spring Web, Spring Data JPA, Spring Security, Thymeleaf, PostgreSQL Driver, Lombok, and Spring Boot DevTools.
The generated project was imported into IntelliJ IDEA, where the initial structure was established.

2. Database Setup

PostgreSQL was installed locally, and a database named agrimart was created.
The application.properties file was configured with database connection details (e.g., URL, username, password) and JPA settings for automatic schema updates.

3. Core Implementation

Models: Defined JPA entities (e.g., Product, User) in the Model package using Java OOP principles and annotations.
Repositories: Created interfaces extending JpaRepository in the Repo package for database operations.
Services: Implemented business logic in the Service package.
Controllers: Developed RESTful endpoints in the Controller package to handle user requests.

4. Configuration

Configured CORS settings in CorsConfig.java within the Config package to enable cross-origin resource sharing.
Set up security configurations in the Security package using Spring Security.

5. Frontend Development

Utilized Thymeleaf for dynamic templates stored in the templates directory (e.g., home.html, products.html).
Styled the application with CSS files in the static directory, ensuring a consistent green theme for buttons and cards.
Integrated forms for listing equipment and processing payments.

6. Static Resources and Image Handling

Stored static files (e.g., images, CSS) in the static directory.
Implemented image upload functionality, ensuring proper resource serving from the static folder.

7. Version Control with Git and GitHub

Initialized a Git repository within the project.
Committed changes periodically and pushed the codebase to a GitHub repository named AgriMart for version control and collaboration.

8. Testing and Debugging

Wrote unit and integration tests in the test directory to validate functionality.
Debugged issues using IntelliJ IDEA’s debugging tools and application logs.

9. Running the Application

The application was run directly from IntelliJ IDEA using the BackendApplication main class.
The app was accessible at http://localhost:8080 for local testing.

Setup and Installation
To run this project locally:

Clone the repository:
textgit clone https://github.com/yourusername/AgriMart.git
cd AgriMart/Backend

Ensure PostgreSQL is installed and the agrimart database is created with appropriate credentials in application.properties.
Open the project in IntelliJ IDEA and resolve Maven dependencies.
Run the application using the BackendApplication class.
Access the app at http://localhost:<youport number>.

Screenshots

Home Page: Welcome screen with navigation and "Browse Available Tools" button.
Products Page: Listing of available equipment.
Listing Form: Interface for adding new equipment.
Payment Summary: Payment details and "Pay Now" option.
Order History: Table of past transactions.
About Page: Mission and vision statements.

(Include actual screenshot images in the docs/ folder or embed via GitHub Markdown if available.)
Contributing
Contributions are welcome! Please fork the repository and submit a pull request. For major changes, open an issue first to discuss.
Contact
For questions or feedback, reach out via GitHub issues or email at sadhanalavenkat372@gmail.com.
