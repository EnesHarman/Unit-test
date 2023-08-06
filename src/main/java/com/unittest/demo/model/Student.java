package com.unittest.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", columnDefinition = "varchar(50)")
    private String name;

    @Column(name = "number", columnDefinition = "varchar(50)")
    private String number;

    @Column(name = "className", columnDefinition = "varchar(50)")
    private String className;

    @Column(name = "department", columnDefinition = "varchar(50)")
    private String department;
}
