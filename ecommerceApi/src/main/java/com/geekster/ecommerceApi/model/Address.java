package com.geekster.ecommerceApi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "address_landmark")
    private String landmark;

    @Column(name = "address_phoneNumber")
    private String phoneNumber;

    @Column(name = "address_zipcode")
    private String zipCode;

    @Column(name = "address_state")
    private String state;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User usedId;
}
