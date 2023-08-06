package com.unittest.demo.repository;

import com.unittest.demo.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void shouldFindByName() {

        //given
        var student = Student.builder()
                .name("Enes")
                .className("Art102")
                .department("Engineering")
                .number("44242")
                .build();

        repository.save(student);
        //when
        Optional<List<Student>> test = repository.findByName("Enes");


        //then
        assertTrue(test.isPresent() && test.get().size() > 0);
    }
}