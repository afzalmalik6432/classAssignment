package com.example.jpaQuery.repository;

import com.example.jpaQuery.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select * from tbl_student where student_id = :id",nativeQuery = true)
    Student getStudentById(Integer id);

    @Query(value = "select * from tbl_student where first_name = :firstName",nativeQuery = true)
    Student getStudentByFirstName(String firstName);

    Student findByFirstName(String firstName);
}
