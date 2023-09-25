package com.example.universitystaff.api.Util.utilClasses;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "language")
    private String language;

    @JsonIgnore
    @OneToMany(targetEntity = Course.class, mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "department",cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Person.class)
    private List<Person> persons = new ArrayList<>();


}
