package com.example.universitystaff.api.service;

import com.example.universitystaff.api.Util.utilClasses.Department;

import java.util.Optional;

public interface DepartmentService {

    String registerDepartment(String name, String language);

    Optional<Department> getDepartmentById(Long id);
}
