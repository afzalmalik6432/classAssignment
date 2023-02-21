package com.geekster.ecommerceApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer ProductId;

    @Column(name = "product_name")
        private String productName;

    @Column(name = "product_price")
    private Integer price;

    @Column(name = "product_desc")
    private String description;

    @Column(name = "product_category")
    private String category;

    @Column(name = "product_brand")
    private String brand;
}
