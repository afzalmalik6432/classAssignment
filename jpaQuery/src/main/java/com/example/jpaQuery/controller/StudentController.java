package com.example.jpaQuery.controller;

import com.example.jpaQuery.model.Student;
import com.example.jpaQuery.service.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;

@RestController
@RequestMapping(value = "/api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/student")
    public ResponseEntity<String> addStudent(@RequestBody String requestData){
        Student student=setStudent(requestData);
        Integer studentId=studentService.addStudent(student);
        return new ResponseEntity<>("Student saved with Id - "+studentId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/studentById")
    public ResponseEntity<String> getStudent(@RequestParam Integer id){
        Student student = studentService.getStudentById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName",student.getFirstName());
        jsonObject.put("lastName",student.getLastName());
        jsonObject.put("studentId",student.getStudentId());
        jsonObject.put("status",student.getStatus());
        jsonObject.put("age",student.getAge());
        jsonObject.put("admissionDate",student.getAdmissionDate());
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }

    @GetMapping(value = "/studentByIdQuery")
    public ResponseEntity<String> studentByIdQuery(@RequestParam Integer id){
        Student student = studentService.studentByIdQuery(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName",student.getFirstName());
        jsonObject.put("lastName",student.getLastName());
        jsonObject.put("studentId",student.getStudentId());
        jsonObject.put("status",student.getStatus());
        jsonObject.put("age",student.getAge());
        jsonObject.put("admissionDate",student.getAdmissionDate());
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }

    @GetMapping(value = "/studentByfirstNameQuery")
    public ResponseEntity<String> studentByfirstNameQuery(@RequestParam String firstName){
        Student student = studentService.studentByfirstNameQuery(firstName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName",student.getFirstName());
        jsonObject.put("lastName",student.getLastName());
        jsonObject.put("studentId",student.getStudentId());
        jsonObject.put("status",student.getStatus());
        jsonObject.put("age",student.getAge());
        jsonObject.put("admissionDate",student.getAdmissionDate());
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }

    @GetMapping(value = "/studentByfirstName")
    public ResponseEntity<String> studentByfirstName(@RequestParam String firstName){
        Student student = studentService.studentByfirstName(firstName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName",student.getFirstName());
        jsonObject.put("lastName",student.getLastName());
        jsonObject.put("studentId",student.getStudentId());
        jsonObject.put("status",student.getStatus());
        jsonObject.put("age",student.getAge());
        jsonObject.put("admissionDate",student.getAdmissionDate());
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }

    private Student setStudent(String requestData) {
        JSONObject jsonObject = new JSONObject(requestData);
        Student student = new Student();
        student.setFirstName(jsonObject.getString("firstName"));
        student.setLastName(jsonObject.getString("lastName"));
        student.setAge(jsonObject.getInt("age"));
        student.setStatus(jsonObject.getBoolean("status"));
        long dateTime = System.currentTimeMillis();
        Date date1 = new Date(dateTime);
        student.setAdmissionDate(date1);
        return student;
    }

}
