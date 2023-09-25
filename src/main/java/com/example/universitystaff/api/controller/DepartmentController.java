package com.example.universitystaff.api.controller;

import com.example.universitystaff.api.Util.utilClasses.Department;
import com.example.universitystaff.api.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api/DepartmentController")
@RestController
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/registerDepartment")
    @ResponseStatus(HttpStatus.OK)
    public String registerDepartment(@RequestParam String name, String language) {
        return departmentService.registerDepartment(name, language);
    }

}
