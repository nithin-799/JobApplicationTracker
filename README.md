# JobApplicationTracker
A Java Servlet application to track job applications with details like company name, role, applied date, status, resume used, portal, location, and salary.

## Features
- Add job application details via a web form
- Store data in MySQL database
- Redirect to success page after insertion

## Requirements
- Java 21+
- Tomcat 10+
- MySQL 8+
- JDBC Driver (`mysql-connector-j`)

## Setup
1. Clone the repository.
2. Configure database:
   ```sql
   CREATE DATABASE nithin;
   USE nithin;
   CREATE TABLE jobapplicationtracker (
       id INT AUTO_INCREMENT PRIMARY KEY,
       company_name VARCHAR(100),
       job_role VARCHAR(100),
       applied_date DATE,
       application_status VARCHAR(50),
       resume_used VARCHAR(100),
       job_portal VARCHAR(100),
       location VARCHAR(100),
       ctc VARCHAR(50)
   );
