package com.example.hibernateMapping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Entity @Table(name = "tbl_laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String name;
    private String brand;
    private Integer price;

    @JoinColumn(name = "std_id")
    @OneToOne
    private Student student;

}
