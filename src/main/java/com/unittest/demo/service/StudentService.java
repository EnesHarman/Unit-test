package com.unittest.demo.service;

import com.unittest.demo.dto.StudentCreateRequest;
import com.unittest.demo.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentCreateRequest request);

    List<Student> listStudents(int page, int size);
}
