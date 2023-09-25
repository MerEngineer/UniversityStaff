package com.example.universitystaff.api.service;

import com.example.universitystaff.api.Util.utilClasses.Department;
import com.example.universitystaff.api.Util.utilClasses.Person;

import java.util.Optional;

public interface PersonService {
    String registerPerson(Person person);
    String deletePerson(Long cardId);
    Person getPersonById(Long id);

    Optional<Department> getDepartmentById (Long id);
}
