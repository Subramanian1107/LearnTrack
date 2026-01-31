package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.Scanner;

public class CourseService {
    private final Scanner sc;
    private final CourseRepository repository;

    private final EnrollmentService enrollmentService;

    public CourseService(Scanner sc,
                         CourseRepository courseRepository,
                         EnrollmentService enrollmentService) {
        this.sc = sc;
        this.repository = courseRepository;
        this.enrollmentService = enrollmentService;
    }


    public void courseMenu(){
        int choice;
        System.out.println("---Course Menu---");
        do{
            System.out.println("Enter choice");
            System.out.println("1. Add new course");
            System.out.println("2. Display all courses");
            System.out.println("3. Activate or deactivate a course");
            System.out.println("4. Back");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    // Add course
                    addCourse();
                    break;
                case 2:
                    // Display all active courses
                    displayAllCourses();
                    break;
                case 3:
                    // Activate or deactivate course
                    updateCourseStatus();
                    break;
                case 4:
                    System.out.println("Returning back to main menu..");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=4);
    }
    private void addCourse(){
        sc.nextLine();
        System.out.println("Enter course name:");
        String name = sc.nextLine();
        System.out.println("Enter course description:");
        String description = sc.nextLine();
        System.out.println("Enter course duration(in weeks):");
        int duration = sc.nextInt();
        Course course = new Course(name,description,duration);
        repository.addCourse(course);
    }
    private void displayAllCourses(){
        // Displaying all active courses
        for(Course course: repository.getAllCourses()){
            if(course.getStatus())
                System.out.println(course);
        }
    }
    private void updateCourseStatus(){
        // Activating or deactivating a course
        System.out.println("Enter course id:");
        int id = sc.nextInt();
        Course course = repository.getCourseById(id);
        if(course == null){
            System.out.println("Course does not exist!");
            return;
        }
        System.out.println("1. Activate course");
        System.out.println("2. Deactivate course");
        System.out.println("Enter status choice:");
        int statusChoice = sc.nextInt();
        if(statusChoice == 1){
            course.setStatus(true);
            System.out.println("Activated course successfully!");
        }
        else if(statusChoice == 2){
            course.setStatus(false);
            enrollmentService.cancelEnrollmentsForCourse(id);
            System.out.println("Deactivated course successfully!");
        }
        else{
            System.out.println("Invalid status choice!");
            return;
        }
    }


}
