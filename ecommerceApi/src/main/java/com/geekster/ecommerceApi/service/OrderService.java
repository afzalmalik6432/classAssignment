package com.geekster.ecommerceApi.service;

import com.geekster.ecommerceApi.dao.IOrderDao;
import com.geekster.ecommerceApi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    IOrderDao orderDao;

    public int addOrder(Order order){
        Order savedOrder = orderDao.save(order);
        return savedOrder.getOrderId();
    }

    public Order getOrderById(Integer id) {
        return orderDao.findById(id).get();
    }
}
