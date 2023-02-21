package com.geekster.ecommerceApi.controller;

import com.geekster.ecommerceApi.model.Product;
import com.geekster.ecommerceApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/addproduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        Integer productId = productService.addProduct(product);
        return new ResponseEntity<>("Product added with id "+productId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAllProduct")
    public ResponseEntity<List<Product>> getAllProduct(){

        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteproductbyid")
    public ResponseEntity<String> deletById(@RequestParam Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully",HttpStatus.OK);
    }

}
