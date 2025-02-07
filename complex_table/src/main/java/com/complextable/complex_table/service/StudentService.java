package com.complextable.complex_table.service;


import com.complextable.complex_table.entities.Student;
import com.complextable.complex_table.entities.IdCard;
import com.complextable.complex_table.entities.Department;
import com.complextable.complex_table.entities.Courses;
import com.complextable.complex_table.repo.StudentRepo;
import com.complextable.complex_table.repo.IdCardRepo;
import com.complextable.complex_table.repo.DepartmentRepo;
import com.complextable.complex_table.repo.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    
    @Autowired
    private IdCardRepo idCardRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private CoursesRepo coursesRepo;

    
    // Get all students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Get a student by ID
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        return student.orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    // Save a new student
    public Student saveStudent(Student student) {
        // Handle the One-to-One relationship with IDCard
    	student.getIdCard().setStudent(student);

        // Handle the Many-to-One relationship with Department
        if (student.getDepartment() != null) {
            student.setDepartment(departmentRepo.findById(student.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Department not found")));
        }

        // Handle the Many-to-Many relationship with Courses
        if (student.getCourses() != null && !student.getCourses().isEmpty()) {
            List<Courses> savedCourses = coursesRepo.findAllById(
                    student.getCourses().stream().map(Courses::getId).toList()
            );
            student.setCourses(savedCourses);
        }

        // Save the student first (ensures ID is generated)
        Student savedStudent = studentRepo.save(student);

        // Save the ID card after ensuring the student ID is available
        if (savedStudent.getIdCard() != null) {
            savedStudent.getIdCard().setStudent(savedStudent);
            idCardRepo.save(savedStudent.getIdCard());
        }

        return savedStudent;
    }


    // Update an existing student
    public Student updateStudent(Long id, Student studentDetails) {
        Student existingStudent = getStudentById(id);

        // Update basic fields
        existingStudent.setName(studentDetails.getName());
        existingStudent.setAge(studentDetails.getAge());

        // Update the One-to-One relationship with IDCard
        if (studentDetails.getIdCard() != null) {
            IdCard updatedIdCard = idCardRepo.save(studentDetails.getIdCard());
            existingStudent.setIdCard(updatedIdCard);
        }

        // Update the Many-to-One relationship with Department
        if (studentDetails.getDepartment() != null) {
            Department updatedDepartment = departmentRepo.save(studentDetails.getDepartment());
            existingStudent.setDepartment(updatedDepartment);
        }

        // Update the Many-to-Many relationship with Courses
        if (studentDetails.getCourses() != null && !studentDetails.getCourses().isEmpty()) {
            for (Courses course : studentDetails.getCourses()) {
                // Save or update courses before associating them with the student
                coursesRepo.save(course);
            }
            existingStudent.setCourses(studentDetails.getCourses());
        }

        return studentRepo.save(existingStudent);
    }

    // Delete a student by ID
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
