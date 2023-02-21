package com.geekster.ecommerceApi.dao;

import com.geekster.ecommerceApi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressDao extends JpaRepository<Address, Integer> {
}
