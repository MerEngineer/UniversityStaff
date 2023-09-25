package com.example.universitystaff.api.controller;

import com.example.universitystaff.api.Util.utilClasses.Course;
import com.example.universitystaff.api.Util.utilClasses.Department;
import com.example.universitystaff.api.Util.utilClasses.Person;
import com.example.universitystaff.api.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api/PersonController")
@RestController
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(value = "/registerPerson")
    @ResponseStatus(HttpStatus.OK)
    public String registerPerson(@RequestBody Person person) {
        return personService.registerPerson(person);
    }

    @PostMapping(value = "/returnPerson")
    @ResponseStatus(HttpStatus.OK)
    public Person returnPerson() {
        return new Person();
    }

    @PostMapping(value = "/getPersonById")
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@RequestParam Long id) {
        return personService.getPersonById(id);
    }
    @DeleteMapping(value = "/deletePersonById")
    @ResponseStatus(HttpStatus.OK)
    public String deletePerson(@RequestParam Long id) {
        return personService.deletePerson(id);
    }
}

