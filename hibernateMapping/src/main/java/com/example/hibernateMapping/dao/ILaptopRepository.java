package com.example.hibernateMapping.dao;

import com.example.hibernateMapping.model.Laptop;
import com.example.hibernateMapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaptopRepository extends JpaRepository<Laptop,Integer> {
    Laptop findByStudent(Student student);
}
