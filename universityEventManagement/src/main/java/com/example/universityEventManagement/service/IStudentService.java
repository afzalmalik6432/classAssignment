package com.example.universityEventManagement.service;

import com.example.universityEventManagement.model.StudentModel;

import java.util.List;

public interface IStudentService {
    List<StudentModel> getAllStudents();
    StudentModel getStudentById(int id);
    void addStudent(StudentModel student);
    StudentModel updateStudentDepartment(int id,String department);
    void deleteStudent(int id);
}
