# Task Manager Application

## Overview

Task Manager is a full-stack web application developed using Java Spring Boot, HTML, CSS, and JavaScript. The application allows users to create, view, update, delete, and manage tasks efficiently.

Tasks are stored using in-memory storage (ArrayList) as per the project requirement. No external database is used.

---

## Features

* Add a new task
* View all tasks
* Edit existing tasks
* Delete tasks
* Mark tasks as Complete/Incomplete
* Responsive and user-friendly UI
* Animated hero section
* REST API integration
* In-memory storage

---

## Technologies Used

### Backend

* Java 17
* Spring Boot 3.5
* Maven

### Frontend

* HTML5
* CSS3
* JavaScript

### Storage

* ArrayList (In-Memory Storage)

---

## Project Structure

Task-Manager

├── src

│   ├── main

│   │   ├── java

│   │   │   ├── controller

│   │   │   │   └── TaskController.java

│   │   │   ├── model

│   │   │   │   └── Task.java

│   │   │   ├── service

│   │   │   │   └── TaskService.java

│   │   │   └── TaskmanagerApplication.java

│   │

│   │   └── resources

│   │       └── static

│   │           ├── index.html

│   │           ├── style.css

│   │           └── script.js

│

├── pom.xml

├── mvnw

├── mvnw.cmd

└── README.md

---

## Prerequisites

Before running the application, ensure the following are installed:

* Java 17
* Maven 3.9+
* Git (optional)

Verify installation:

java -version

mvn -version

---

## How to Run the Application

### Step 1: Clone Repository

git clone https://github.com/Saicharan1221/Task-Manager.git

### Step 2: Open Project

cd Task-Manager

### Step 3: Run Application

mvn spring-boot:run

### Step 4: Open Browser

http://localhost:8080/index.html

---

## API Endpoints

### Get All Tasks

GET /tasks

Response:

[
{
"id": 1,
"title": "Learn Spring Boot",
"completed": false
}
]

---

### Create Task

POST /tasks

Request:

{
"title": "Learn Spring Boot",
"completed": false
}

---

### Update Task

PUT /tasks/{id}

Request:

{
"title": "Learn Spring Boot Advanced",
"completed": true
}

---

### Delete Task

DELETE /tasks/{id}

---

## Frontend and Backend Integration

The frontend communicates with the backend using JavaScript Fetch API.

Workflow:

User Action

↓

JavaScript Function

↓

REST API Request

↓

Spring Boot Controller

↓

Service Layer

↓

In-Memory Storage

↓

Response Returned

↓

UI Updated

---

## Edge Cases Handled

### Empty Task Title

Validation prevents users from creating tasks with empty titles.

Example:

""

Result:

Task title cannot be empty.

---

### Editing with Empty Value

If the user submits an empty value while editing, the update is rejected.

---

### Deleting Non-Existent Task

If a task does not exist, the API returns an appropriate error response.

Example:

404 Not Found

---

### Task Completion Status

Users can toggle between:

* Completed ✅
* Incomplete ⏳

---

## Design Decisions

* Layered Architecture (Controller, Service, Model)
* Separation of Concerns
* In-Memory Storage instead of Database
* RESTful API Design
* Responsive UI
* Lightweight Implementation

---

## Future Enhancements

* MySQL/PostgreSQL Integration
* User Authentication
* Due Dates
* Task Categories
* Search Functionality
* Cloud Deployment

---

## Conclusion

This project demonstrates full-stack web development using Java Spring Boot and JavaScript. It implements complete CRUD functionality, follows clean architecture principles, handles edge cases, and provides a user-friendly interface for task management.
