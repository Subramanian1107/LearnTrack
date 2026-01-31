package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();





        EnrollmentService enrollmentService =
                new EnrollmentService(
                        sc,
                        enrollmentRepository,
                        studentRepository,
                        courseRepository
                );
        StudentService studentService =
                new StudentService(sc, studentRepository,enrollmentService);
        CourseService courseService =
                new CourseService(sc, courseRepository,enrollmentService);
        int choice;

        System.out.println("\n=== LearnTrack ===");
        do{
            System.out.print("Enter your choice: \n");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");

            choice = sc.nextInt();
            switch(choice){
                case 1:
                    // Student Service
                    studentService.studentMenu();
                    break;
                case 2:
                    // Course Service
                    courseService.courseMenu();
                    break;
                case 3:
                    // Enrollment Service
                    enrollmentService.enrollmentMenu();
                    break;
                case 4:
                    System.out.println("Exiting!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=4);

        sc.close();
    }
}
