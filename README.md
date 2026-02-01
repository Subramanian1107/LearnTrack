# 📘 LearnTrack – Console-Based Learning Management System

LearnTrack is a **Java-based, console-driven Learning Management System (LMS)** designed to demonstrate strong Object-Oriented Programming (OOP) principles, clean service–repository separation, and real-world business logic handling.

This project is ideal for:

* Java/OOP practice
* Interview preparation
* Understanding service-layer design
* Building a mini end-to-end system without frameworks

---

## 🚀 Features

### 👤 Student Management

* Add students with optional last name and email
* Input validation using custom validators
* Activate / Deactivate students
* Automatic cancellation of enrollments when a student is deactivated

### 📚 Course Management

* Add courses with name, description, and duration
* Activate / Deactivate courses
* Automatic cancellation of enrollments when a course is deactivated

### 📝 Enrollment Management

* Enroll a student into a course
* Prevent enrollment for inactive students or courses
* View enrollments for a student
* Update enrollment status (ENROLLED / COMPLETED / CANCELLED)

### 🧱 Object-Oriented Design

* Inheritance (`Person → Student / Trainer`)
* Method overriding (`display()` method)
* Constructor overloading
* Encapsulation and immutability where applicable
* Polymorphism via base-class references

### ⚠️ Validation & Exceptions

* Centralized `InputValidator`
* Custom `InvalidInputException`
* Clean error handling in service layer

---

## 🗂️ Project Structure

```
com.airtribe.learntrack
│
├── entity
│   ├── Person.java
│   ├── Student.java
│   ├── Trainer.java
│   ├── Course.java
│   └── Enrollment.java
│
├── service
│   ├── StudentService.java
│   ├── CourseService.java
│   └── EnrollmentService.java
│
├── repository
│   ├── StudentRepository.java
│   ├── CourseRepository.java
│   └── EnrollmentRepository.java
│
├── util
│   ├── InputValidator.java
│   └── IdGenerator.java
│
├── exception
│   └── InvalidInputException.java
│
└── ui
    └── Main.java
```

---

## ▶️ How to Run

1. Clone the repository
2. Open the project in IntelliJ / Eclipse
3. Run `Main.java`
4. Use the console menu to navigate between:

   * Student Management
   * Course Management
   * Enrollment Management

---

## 🧪 Sample Console Output

```
=== LearnTrack ===
Enter your choice: 
1. Student Management
2. Course Management
3. Enrollment Management
4. Exit

=== Student Menu ===
1. Add new student
2. Display all students
3. Deactivate a student
4. Back
=== Course Menu ===
Enter choice
1. Add new course
2. Display all courses
3. Activate or deactivate a course
4. Back
=== Enrollment Menu ===
Enter choice
1. Add new enrollment
2. Display all enrollments for a student
3. Update employment status
4. Back
```

```
=== Student details ===
ID: 1 | First Name: Subramanian | Last Name: Segaran | Email: subseg1107@gmail.com | Batch: 18 | Age: 23
ID: 2 | First Name: Subu | Last Name: N/A | Email: N/A | Batch: 18 | Age: 23
```

```
=== Course details ===
CourseId: 1 | Name: Java fundamentals | Description: Basics of Java and OOPS concepts | Duration: 6 weeks
CourseId: 2 | Name: DSA | Description: Basics of data structures and algorithms | Duration: 16 weeks
```

```
=== Enrollments details ===
StudentId: 1 | CourseId: 1 | Status: ENROLLED
StudentId: 1 | CourseId: 2 | Status: ENROLLED

=== Course Menu ===
Enter choice
1. Add new course
2. Display all courses
3. Activate or deactivate a course
4. Back
3
Enter course id:
2
1. Activate course
2. Deactivate course
Enter status choice:
2
All enrollments cancelled for course 2
Deactivated course successfully!

=== Enrollments details ===
StudentId: 1 | CourseId: 1 | Status: ENROLLED
StudentId: 1 | CourseId: 2 | Status: CANCELLED
```
---

## 💡 Design Decisions

* **Service layer handles business logic**, not repositories
* **Repositories store in-memory data** (no DB for simplicity)
* **Entities remain lightweight** and free of cross-dependencies
* **Automatic consistency** between student/course status and enrollments

---

## 🔮 Future Enhancements

* Use `enum` for EnrollmentStatus
* Add Trainer management
* Persist data using a database or file storage
* Add unit tests
* Convert to REST API using Spring Boot
* Add role-based access
