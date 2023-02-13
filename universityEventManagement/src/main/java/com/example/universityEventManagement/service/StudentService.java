package com.example.universityEventManagement.service;

import com.example.universityEventManagement.model.StudentModel;
import com.example.universityEventManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;
    public static List<StudentModel> students = new ArrayList<StudentModel>();
    @Override
    public List<StudentModel> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(StudentModel student) {
        studentRepository.save(student);
    }

    @Override
    public StudentModel updateStudentDepartment(int id, String department) {
        StudentModel student = studentRepository.findById(id).get();
        student.setDepartment(department);
        studentRepository.save(student);
        System.out.println(student);
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentModel getStudentById(int id) {
        return studentRepository.findById(id).get();
    }
}
