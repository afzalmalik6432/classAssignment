package com.example.universityEventManagement.repository;

import com.example.universityEventManagement.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel,Integer> {
}
