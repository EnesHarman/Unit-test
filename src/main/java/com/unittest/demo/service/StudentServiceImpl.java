package com.unittest.demo.service;

import com.unittest.demo.dto.StudentCreateRequest;
import com.unittest.demo.model.Student;
import com.unittest.demo.repository.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    @Override
    public Optional<List<Student>> findStudent(Optional<Integer> id, Optional<String> name) {
        Optional<List<Student>> students = Optional.empty();

        if(id.isPresent()){
            Optional<Student> student = studentRepository.findById(id.get());
            return student.isPresent() ? Optional.of(List.of(student.get())) : Optional.empty();
        }
        else if(name.isPresent()){
            students = studentRepository.findByName(name.get());
        }

        return students;
    }
}
