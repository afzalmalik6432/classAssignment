package com.geekster.ecommerceApi.dao;

import com.geekster.ecommerceApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDao extends JpaRepository<Product,Integer> {
}
