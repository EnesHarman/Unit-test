package com.unittest.demo.service;

import com.unittest.demo.dto.StudentCreateRequest;
import com.unittest.demo.model.Student;
import com.unittest.demo.repository.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(StudentCreateRequest request) {
        Student student = Student.builder()
                .name(request.getName())
                .className(request.getClassName())
                .number(request.getNumber())
                .department(request.getDepartment())
                .build();

        return studentRepository.save(student);
    }

    @Override
    public List<Student> listStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return studentRepository.findAll(pageable).getContent();
    }
}
