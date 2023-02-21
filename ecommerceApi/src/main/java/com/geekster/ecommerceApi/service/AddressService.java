package com.geekster.ecommerceApi.service;

import com.geekster.ecommerceApi.dao.IAddressDao;
import com.geekster.ecommerceApi.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressDao addressDao;

    public void addAddress(Address address){
        addressDao.save(address);
    }
    public Address getAddressById(Integer id){
        return addressDao.findById(id).get();
    }
}
