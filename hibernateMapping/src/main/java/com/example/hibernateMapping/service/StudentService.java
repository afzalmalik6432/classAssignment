package com.example.hibernateMapping.service;

import com.example.hibernateMapping.dao.IStudentRepository;
import com.example.hibernateMapping.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    IStudentRepository repository;

    public Integer addUser(Student student) {
        return repository.save(student).getID();
    }

    public List<Student> getStudent(Integer id) {
        List<Student> list = new ArrayList<>();
        if(id!=null){
            list.add(repository.findById(id).get());
        }else{
            list = repository.findAll();
        }
        return list;
    }

    public Student findStudent(Integer id){
        return repository.findById(id).get();
    }

    public void updateStudent(Integer id, Student student) {
//        Student oldStudent = repository.findById(id).get();
        student.setID(id);
        repository.save(student);
    }

    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }
}







