package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class EnrollmentService {
    private final Scanner sc;
    private final EnrollmentRepository repository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    public EnrollmentService(Scanner sc,EnrollmentRepository enrollmentRepository,StudentRepository studentRepository, CourseRepository courseRepository){
        this.sc = sc;
        this.repository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public void enrollmentMenu(){
        int choice;
        System.out.println("---Course Menu---");
        do{
            System.out.println("Enter choice");
            System.out.println("1. Add new enrollment");
            System.out.println("2. Display all enrollments for a student");
            System.out.println("3. Update employment status");
            System.out.println("4. Back");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    // Enroll a student for a course
                    addEnrollment();
                    break;
                case 2:
                    // Display all the courses enrolled by a student
                    displayEnrollmentsForStudent();
                    break;
                case 3:
                    // Change status of enrollment to completed or cancelled
                    updateEmploymentStatus();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=4);
    }
    private void addEnrollment(){
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();

        System.out.print("Enter Course ID: ");
        int courseId = sc.nextInt();

        Student student = studentRepository.getStudentById(studentId);
        Course course = courseRepository.getCourseById(courseId);
        if (!student.getStatus()) {
            System.out.println("Inactive student cannot enroll!");
            return;
        }
        if (!course.getStatus()) {
            System.out.println("Inactive course cannot be enrolled!");
            return;
        }
        Enrollment existing =
                repository.findEnrollment(studentId, courseId);

        if (existing != null) {
            System.out.println("Student already enrolled!");
            return;
        }

        Enrollment enrollment =
                new Enrollment(studentId, courseId);
        repository.addEnrollment(enrollment);

        System.out.println("Enrollment successful!");
    }
    private void displayEnrollmentsForStudent(){
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();

        List<Enrollment> enrollments =
                repository.getEnrollmentsByStudentId(studentId);

        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }

        System.out.println("\n--- Enrollments ---");
        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
    }
    private void updateEmploymentStatus(){
        System.out.println("Enter Student ID: ");
        int studentId = sc.nextInt();
        System.out.println("Enter Course ID: ");
        int courseId = sc.nextInt();
        Enrollment enrollment = repository.findEnrollment(studentId,courseId);

        if(enrollment == null){
            System.out.println("Enrollment not found!");
            return;
        }
        System.out.println("1. COMPLETED");
        System.out.println("2. CANCELLED");
        System.out.println("Choose a new status: ");

        int statusChoice = sc.nextInt();
        if(statusChoice == 1){
            enrollment.setStatus("COMPLETED");
        }
        else if(statusChoice == 2){
            enrollment.setStatus("CANCELLED");
        }
        else{
            System.out.println("Invalid status!");
            return;
        }
        System.out.println("Employee status updated!");

    }
}
