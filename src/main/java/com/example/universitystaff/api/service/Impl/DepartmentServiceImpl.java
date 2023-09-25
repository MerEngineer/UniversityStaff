package com.example.universitystaff.api.service.Impl;

import com.example.universitystaff.api.Util.utilClasses.Department;
import com.example.universitystaff.api.service.DepartmentService;
import com.example.universitystaff.repo.DepartmentRepository;
import com.example.universitystaff.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                                 PersonRepository personRepository){ this.departmentRepository = departmentRepository;
        this.personRepository = personRepository;
    }

    @Override
    public String registerDepartment(String name, String language){
        try {
            Optional<Department> departmentOptional = departmentRepository.findByName(name);
            if(!Objects.isNull(departmentOptional) && !ObjectUtils.isEmpty(departmentOptional))
                throw new Exception("Department already exists.");

            Department department = new Department();
            department.setName(name);
            department.setLanguage(language);
            departmentRepository.save(department);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return e.getMessage();
        }
        return "Department registered.";
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }
}
