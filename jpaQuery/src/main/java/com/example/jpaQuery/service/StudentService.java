package com.example.jpaQuery.service;

import com.example.jpaQuery.model.Student;
import com.example.jpaQuery.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Integer addStudent(Student student) {
        return studentRepository.save(student).getStudentId();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public Student studentByIdQuery(Integer id) {

        return studentRepository.getStudentById(id);

    }

    public Student studentByfirstNameQuery(String firstName) {
        return studentRepository.getStudentByFirstName(firstName);
    }

    public Student studentByfirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }
}
