package com.unittest.demo.repository;

import com.unittest.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT new com.unittest.demo.model.Student(s.id, s.name, s.number, s.className, s.department) FROM Student s where s.name=:name")
    Optional<List<Student>> findByName(String name);
}
