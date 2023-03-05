package com.example.hibernateMapping.controller;
import com.example.hibernateMapping.model.Address;
import com.example.hibernateMapping.model.Student;
import com.example.hibernateMapping.service.StudentService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody String requestStudent){
        Student student = setStudent(requestStudent);
        Integer id = service.addUser(student);
        return new ResponseEntity<>("Student saved with id - "+id, HttpStatus.CREATED);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudent(@Nullable @RequestParam Integer id){
        List<Student> studentList = service.getStudent(id);
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    @PutMapping("/student")
    public ResponseEntity<String> updateStudent(@RequestBody String requestUpdate,@RequestParam Integer id){
        Student student = setStudent(requestUpdate);
        service.updateStudent(id,student);
        return new ResponseEntity<>("Student updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("/student")
    public ResponseEntity<String> deleteStudent(@RequestParam Integer id){
        service.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully",HttpStatus.OK);
    }

    private Student setStudent(String requestStudent) {
        JSONObject jsonObject = new JSONObject(requestStudent);
        Student student = new Student();
        student.setName(jsonObject.getString("name"));
        student.setAge(jsonObject.getString("age"));
        student.setBranch(jsonObject.getString("branch"));
        student.setDepartment(jsonObject.getString("department"));
        student.setPhoneNumber(jsonObject.getString("phoneNumber"));
        Address address = new Address();
        JSONObject jsonAddress = jsonObject.getJSONObject("address");
        address.setCountry(jsonAddress.getString("country"));
        address.setLandmark(jsonAddress.getString("landmark"));
        address.setDistrict(jsonAddress.getString("district"));
        address.setZipcode(jsonAddress.getString("zipcode"));
        address.setState(jsonAddress.getString("state"));
        student.setAddress(address);
        return student;
    }
}