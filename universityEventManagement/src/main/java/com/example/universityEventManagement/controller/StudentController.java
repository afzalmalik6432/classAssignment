package com.example.universityEventManagement.controller;

import com.example.universityEventManagement.model.StudentModel;
import com.example.universityEventManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/v1")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/getAllStudents")
    public List<StudentModel> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/id")
    public StudentModel getStudentById(@RequestParam(name = "id") int id){
        return  studentService.getStudentById(id);
    }
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentModel student){
        studentService.addStudent(student);
        return "Student added successfully";
    }
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam(name = "id") int id){
        studentService.deleteStudent(id);
        return "student deleted successfully";
    }
    @PutMapping("/updateStudent/id/{id}/department/{department}")
    public String updateStudentDepartment(@PathVariable int id, @PathVariable String department){
         studentService.updateStudentDepartment(id,department);
        return "Department updated to "+department;
    }
}
