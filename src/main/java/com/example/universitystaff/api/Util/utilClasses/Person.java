package com.example.universitystaff.api.Util.utilClasses;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "student")
    private boolean student;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, targetEntity= Department.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "dp_id")
    private Department department;





}

