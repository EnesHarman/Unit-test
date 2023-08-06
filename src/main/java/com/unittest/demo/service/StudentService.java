package com.unittest.demo.service;

import com.unittest.demo.dto.StudentCreateRequest;
import com.unittest.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(StudentCreateRequest request);

    List<Student> listStudents(int page, int size);

    Optional<List<Student>> findStudent(Optional<Integer> id, Optional<String> name);
}
