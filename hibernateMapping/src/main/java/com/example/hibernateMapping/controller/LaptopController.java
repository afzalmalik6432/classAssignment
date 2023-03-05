package com.example.hibernateMapping.controller;

import com.example.hibernateMapping.model.Laptop;
import com.example.hibernateMapping.model.Student;
import com.example.hibernateMapping.service.LaptopService;
import com.example.hibernateMapping.service.StudentService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/laptop")
    public ResponseEntity<String> addLaptop(@RequestBody String requestData){
        Laptop laptop = setLaptop(requestData);
        String laptopId = laptopService.addLaptop(laptop);

        if (laptopId!=null){
            return new ResponseEntity<>("Laptop is added with id - "+laptopId, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Laptop is already assigned", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/laptop")
    public ResponseEntity<List<Laptop>> getLaptop(@Nullable @RequestParam Integer id){
        List<Laptop> laptops = new ArrayList<>();
        if(id!=null){
            Laptop laptopById = laptopService.getLaptopById(id);
            laptops.add(laptopById);
            return new ResponseEntity<>(laptops,HttpStatus.OK);
        }
        List<Laptop> allLaptop = laptopService.getAllLaptop();
        return new ResponseEntity<>(allLaptop,HttpStatus.OK);

    }

    @PutMapping(value = "/laptop")
    public ResponseEntity<String> updateLaptop(@RequestParam Integer id, @RequestBody String requestData){
        Laptop laptopById = laptopService.getLaptopById(id);
        Laptop laptop = setLaptop(requestData);
        laptopById.setStudent(laptop.getStudent());
        laptopById.setName(laptop.getName());
        laptopById.setBrand(laptop.getBrand());
        laptopById.setPrice(laptop.getPrice());
        Integer sid = laptopService.updateLaptop(laptopById);
        return new ResponseEntity<>("Updated successfully for sid - "+sid,HttpStatus.OK);
    }

    @DeleteMapping(value = "/laptop")
    public ResponseEntity<String> deleteLaptop(@RequestParam Integer id){
        laptopService.deleteLaptop(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }

    private Laptop setLaptop(String requestData) {
        Laptop laptop = new Laptop();
        JSONObject jsonObject = new JSONObject(requestData);
        laptop.setName(jsonObject.getString("name"));
        laptop.setBrand(jsonObject.getString("brand"));
        laptop.setPrice(jsonObject.getInt("price"));
        int studentId = jsonObject.getInt("studentId");
        Student student = studentService.findStudent(studentId);
        laptop.setStudent(student);
        return laptop;
    }
}
