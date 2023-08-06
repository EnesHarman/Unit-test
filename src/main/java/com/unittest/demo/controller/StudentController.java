package com.unittest.demo.controller;

import com.unittest.demo.dto.StudentCreateRequest;
import com.unittest.demo.model.Student;
import com.unittest.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/find")
    public ResponseEntity<?> findStudent(@RequestParam(required = false) Optional<Integer> id, @RequestParam(required = false) Optional<String> name) {
        Optional<List<Student>> student = studentService.findStudent(id, name);
        return student.isPresent() && student.get().size() > 0 ? ResponseEntity.ok(student.get()) : ResponseEntity.badRequest().body("There is no such a student with given credentials."); // could be handled in service layer
    }


}
