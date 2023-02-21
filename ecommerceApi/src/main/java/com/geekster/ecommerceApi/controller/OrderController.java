package com.geekster.ecommerceApi.controller;

import com.geekster.ecommerceApi.model.Address;
import com.geekster.ecommerceApi.model.Order;
import com.geekster.ecommerceApi.model.Product;
import com.geekster.ecommerceApi.model.User;
import com.geekster.ecommerceApi.service.AddressService;
import com.geekster.ecommerceApi.service.OrderService;
import com.geekster.ecommerceApi.service.ProductService;
import com.geekster.ecommerceApi.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/order/")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @Autowired
    ProductService productService;

    @PostMapping(value = "/addorder")
    public ResponseEntity<String> addUser(@RequestBody String order){
        Order orderObject = setObject(order);
        int orderId = orderService.addOrder(orderObject);
        return new ResponseEntity<>("Order saved with orderId "+orderId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getorderbyid")
    public ResponseEntity<Order> getOrderById(@RequestParam Integer id){
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    private Order setObject(String RequestOrder) {
        JSONObject jsonObject = new JSONObject(RequestOrder);
        Order order = new Order();
        Integer userID = jsonObject.getInt("userID");
        Integer productID = jsonObject.getInt("productID");
        Integer addressID = jsonObject.getInt("addressID");
        Integer productQuantity = jsonObject.getInt("productQuantity");
        User userById = userService.getUserById(userID);
        Address addressById = addressService.getAddressById(addressID);
        Product productById = productService.getProductById(productID);
        order.setProductQuantity(productQuantity);
        order.setAddressId(addressById);
        order.setProductId(productById);
        order.setUserId(userById);
        return order;
    }
}
