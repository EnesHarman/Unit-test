package com.unittest.demo.controller;

import com.unittest.demo.dto.StudentCreateRequest;
import com.unittest.demo.model.Student;
import com.unittest.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createStudent(@RequestBody StudentCreateRequest request){
        studentService.createStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("The student is created.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> listStudents(@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int size){
        List<Student> students = studentService.listStudents(page, size);
        return ResponseEntity.ok(students);
    }


}
