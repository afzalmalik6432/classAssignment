package com.example.hibernateMapping.dao;

import com.example.hibernateMapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
