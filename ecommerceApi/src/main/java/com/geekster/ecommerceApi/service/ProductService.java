package com.geekster.ecommerceApi.service;

import com.geekster.ecommerceApi.dao.IProductDao;
import com.geekster.ecommerceApi.model.Product;
import com.geekster.ecommerceApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    IProductDao productDao;

    public Integer addProduct(Product product){
        Product savedProduct = productDao.save(product);
        return savedProduct.getProductId();
    }

    public Product getProductById(Integer id){
        return productDao.findById(id).get();
    }

    public List<Product> getAllProduct(){
        return productDao.findAll();
    }

    public void deleteProduct(Integer id) {
        productDao.deleteById(id);
    }
}
