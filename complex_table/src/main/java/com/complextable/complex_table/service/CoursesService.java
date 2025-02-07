package com.complextable.complex_table.service;
import com.complextable.complex_table.entities.Courses;
import com.complextable.complex_table.repo.CoursesRepo;
import com.complextable.complex_table.entities.Student;
import com.complextable.complex_table.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoursesService {

    @Autowired
    private CoursesRepo coursesRepo;

    @Autowired
    private StudentRepo studentRepo;

    // Get all courses
    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }

    // Get a course by ID
    public Courses getCourseById(Long id) {
        Optional<Courses> course = coursesRepo.findById(id);
        return course.orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
    }

    // Save a new course
    public Courses saveCourse(Courses course) {
        // Ensure that the list of students is properly set, if present
        if (course.getStudents() != null) {
            for (Student student : course.getStudents()) {
                student.getCourses().add(course);
            }
        }
        return coursesRepo.save(course);
    }

    // Update an existing course
    public Courses updateCourse(Long id, Courses courseDetails) {
        Courses existingCourse = getCourseById(id);

        // Update course fields
        existingCourse.setTitle(courseDetails.getTitle());

        // Update the student list, ensuring students aren't added more than once
        if (courseDetails.getStudents() != null) {
            // Remove previous students' association with this course
            for (Student student : existingCourse.getStudents()) {
                student.getCourses().remove(existingCourse);
                studentRepo.save(student);
            }

            // Now associate the new students
            existingCourse.getStudents().clear();
            existingCourse.getStudents().addAll(courseDetails.getStudents());

            // Save updated student associations
            for (Student student : courseDetails.getStudents()) {
                student.getCourses().add(existingCourse);
                studentRepo.save(student);
            }
        }

        // Save and return the updated course
        return coursesRepo.save(existingCourse);
    }

    // Delete a course by ID
    public void deleteCourse(Long id) {
        Courses course = getCourseById(id);

        // Disassociate this course from all students
        for (Student student : course.getStudents()) {
            student.getCourses().remove(course);
            studentRepo.save(student);  // Save the student after disassociation
        }

        // Delete the course itself
        coursesRepo.deleteById(id);
    }

    // Assign students to a course
    public Courses assignStudentsToCourse(Long courseId, List<Long> studentIds) {
        Courses course = getCourseById(courseId);

        // Fetch students by their IDs
        List<Student> students = studentRepo.findAllById(studentIds);

        // Ensure no duplicates are added
        for (Student student : students) {
            if (!course.getStudents().contains(student)) {
                course.getStudents().add(student);  // Add student to the course
                student.getCourses().add(course);  // Add course to the student's list
                studentRepo.save(student);  // Save updated student
            }
        }

        // Save the updated course and return
        return coursesRepo.save(course);
    }
}
