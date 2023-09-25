package com.example.universitystaff.api.controller;

import com.example.universitystaff.api.Util.utilClasses.Course;
import com.example.universitystaff.api.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api/CourseController")
@RestController
@Slf4j
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/addCourse")
    @ResponseStatus(HttpStatus.OK)
    public String addCourse(@RequestParam String name, Long dpId) {
        return courseService.addCourse(name,dpId);
    }

    @PostMapping(value = "/getCourseById")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseById(@RequestParam Long id) {
        return courseService.getCourseById(id);
    }
}

