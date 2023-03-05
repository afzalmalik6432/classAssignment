package com.example.hibernateMapping.service;

import com.example.hibernateMapping.dao.ILaptopRepository;
import com.example.hibernateMapping.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    ILaptopRepository laptopRepository;

    public String addLaptop(Laptop laptop){
        Laptop byStudent = laptopRepository.findByStudent(laptop.getStudent());
        if(byStudent==null){
            return laptopRepository.save(laptop).getID()+"";
        }
        return null;
    }

    public Laptop getLaptopById(int id) {
        return laptopRepository.findById(id).get();
    }

    public List<Laptop> getAllLaptop(){
        return laptopRepository.findAll();
    }

    public Integer updateLaptop(Laptop laptopById) {
        return laptopRepository.save(laptopById).getStudent().getID();
    }

    public void deleteLaptop(Integer id) {
        laptopRepository.deleteById(id);
    }
}
