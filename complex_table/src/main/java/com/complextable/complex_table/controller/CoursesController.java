package com.complextable.complex_table.controller;
import com.complextable.complex_table.entities.Courses;
import com.complextable.complex_table.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    // Get all courses
    @GetMapping("/displaycourse")
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    // Get a course by ID
    @GetMapping("/{id}")
    public Courses getCourseById(@PathVariable Long id) {
        return coursesService.getCourseById(id);
    }

    // Save a new course
    @PostMapping("/addcourses")
    public Courses addCourse(@RequestBody Courses course) {
        return coursesService.saveCourse(course);
    }

    // Update an existing course
    @PutMapping("/{id}")
    public Courses updateCourse(@PathVariable Long id, @RequestBody Courses course) {
        return coursesService.updateCourse(id, course);
    }

    // Delete a course by ID
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        coursesService.deleteCourse(id);
    }

    // Assign students to a course
    @PostMapping("/{courseId}/students")
    public Courses assignStudentsToCourse(@PathVariable Long courseId, @RequestBody List<Long> studentIds) {
        return coursesService.assignStudentsToCourse(courseId, studentIds);
    }
}
