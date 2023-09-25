package com.example.universitystaff.api.service.Impl;

import com.example.universitystaff.api.Util.utilClasses.Course;
import com.example.universitystaff.api.service.CourseService;
import com.example.universitystaff.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public String addCourse(String name, Long dpId) {
        try {
            Optional<Course> courseOptional = courseRepository.findByName(name);
            if(!Objects.isNull(courseOptional) && !ObjectUtils.isEmpty(courseOptional))
                throw new Exception("Course already exists.");

            Course course =  new Course();
            course.setName(name);
            course.setDpId(dpId);
            courseRepository.save(course);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return e.getMessage();
        }
        return "Course registered.";
    }

    @Override
    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }
}
