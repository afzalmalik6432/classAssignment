package com.example.universityEventManagement.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class StudentModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String department;
}
