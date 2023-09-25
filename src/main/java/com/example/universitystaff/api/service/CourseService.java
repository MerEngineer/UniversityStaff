package com.example.universitystaff.api.service;

import com.example.universitystaff.api.Util.utilClasses.Course;

public interface CourseService {

    String addCourse(String name, Long dpId);

    Course getCourseById(Long id);
}
