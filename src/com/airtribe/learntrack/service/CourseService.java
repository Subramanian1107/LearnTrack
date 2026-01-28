package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.Scanner;

public class CourseService {
    private final Scanner sc;
    private final CourseRepository repository;

    public CourseService(Scanner sc, CourseRepository courseRepository){
        this.sc = sc;
        this.repository = courseRepository;
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
        // Adding course using course id
        System.out.println("Enter course id:");
        int id = sc.nextInt();
        System.out.println("Enter course name:");
        String name = sc.next();
        Course course = new Course(id,name);
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
        }
        else if(statusChoice == 2){
            course.setStatus(false);
        }
        else{
            System.out.println("Invalid status choice!");
            return;
        }
        System.out.println("Course status updated successfully!");
    }


}
