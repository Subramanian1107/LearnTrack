package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student){
        studentList.add(student);
    }
    public List<Student> getAllStudents(){
        return studentList;
    }

    public Student getStudentById(int id){
        for(Student student:studentList){
            if(student.getId() == id)
                return student;
        }
        return null;
    }

}
