package com.example.hibernateMapping.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Embeddable
public class Address {

    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;
}
