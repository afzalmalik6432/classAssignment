package com.geekster.ecommerceApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User userId;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product productId;

    @JoinColumn(name = "address_id")
    @ManyToOne
    private Address addressId;

    @Column(name = "product_quantity")
    private Integer productQuantity;
}
