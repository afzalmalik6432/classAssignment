package com.geekster.ecommerceApi.dao;

import com.geekster.ecommerceApi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDao extends JpaRepository<Order,Integer> {
}
