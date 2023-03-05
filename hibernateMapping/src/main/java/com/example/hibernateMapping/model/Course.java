package com.example.hibernateMapping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_course")
public class Course {

    @Id
    private String ID;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    List<Student> studentList = new ArrayList<>();
}
