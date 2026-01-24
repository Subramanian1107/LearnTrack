package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.Scanner;

public class CourseService {
    private final Scanner sc;
    private final CourseRepository repository;

    public CourseService(Scanner sc){
        this.sc = sc;
        this.repository = new CourseRepository();
    }

    public void courseMenu(){
        int choice;
        System.out.println("---Course Menu---");
        do{
            System.out.println("Enter choice");
            System.out.println("1. Add new course");
            System.out.println("2. Display all courses");
            System.out.println("3. Back");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    addCourse();
                    break;
                case 2:
                    displayAllCourses();
                    break;
                case 3:
                    System.out.println("Returning back to main menu..");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=3);
    }
    private void addCourse(){
        System.out.println("Enter course id:");
        int id = sc.nextInt();
        System.out.println("Enter course name:");
        String name = sc.next();
        Course course = new Course(id,name);
        repository.addCourse(course);
    }
    private void displayAllCourses(){
        for(Course course: repository.getAllCourses()){
            System.out.println(course);
        }
    }

}
