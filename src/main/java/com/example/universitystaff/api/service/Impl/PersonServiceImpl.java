package com.example.universitystaff.api.service.Impl;

import com.example.universitystaff.api.Util.utilClasses.Department;
import com.example.universitystaff.api.Util.utilClasses.Person;
import com.example.universitystaff.api.service.DepartmentService;
import com.example.universitystaff.api.service.PersonService;
import com.example.universitystaff.repo.DepartmentRepository;
import com.example.universitystaff.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository,
                             DepartmentService departmentService) {
        this.departmentService = departmentService;
        this.personRepository = personRepository;
    }

    @Override
    public String registerPerson(Person personFromUser) {

        try {

            if(!Objects.isNull(personRepository.findByEmail(personFromUser.getEmail())))
                throw new Exception("Person already exists.");


            Department department1 = departmentService.getDepartmentById(personFromUser.getDepartment().getId());

            personFromUser.setDepartment(department1);

            personRepository.save(personFromUser);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return e.getMessage();
        }
        return "Person registered.";
    }

    @Override
    public Person getPersonById(Long id){
          return personRepository.findById(id).get();
    }

    @Override
    public Optional<Department> getDepartmentById (Long id){
        return departmentRepository.findById(id);
    }
    @Override
    public String deletePerson(Long cardId) {
        try {
            if(personRepository.findById(cardId).get().getId() != 0) {
                personRepository.findById(cardId).ifPresent(personRepository::delete);
            }
        } catch (Exception e) {
            return "Person doesn't exist.";
        }
        return "Person deleted.";
    }
}
