Theatre Management System

Overview:

The Theatre Management System is a Spring Boot-based backend application that manages movie screenings, seat reservations, and ticket bookings. It provides RESTful APIs for seamless integration with a frontend system.

Features:

User Management: Role-based authentication (Admin, Staff, Customer)
Movie & Show Management: CRUD operations for movies and show scheduling
Seat Reservation & Ticket Booking: Real-time seat availability and booking
Payment Processing: Secure integration with a payment gateway
Database Integration: Uses MySQL with Hibernate ORM
API Documentation: Swagger/OpenAPI for easy testing

Prerequisites:

Ensure you have the following installed:
Java 17 or later
Maven
MySQL
Postman (optional, for API testing)

Setup & Installation:

Clone the Repository:
git clone <repository-url>
cd Theatre_Management_System

Configure the Database:

Update application.properties or application.yml with your MySQL credentials.
Build and Run the Application:
mvn clean install
mvn spring-boot:run

Access the APIs:

Swagger UI: http://localhost:8080/swagger-ui.html
API Base URL: http://localhost:8080/api

Project Page
Theatre Management System Project

License
This project is open-source and available under the MIT License.

