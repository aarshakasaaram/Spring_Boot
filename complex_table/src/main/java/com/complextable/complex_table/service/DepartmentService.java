package com.complextable.complex_table.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complextable.complex_table.entities.Department;
import com.complextable.complex_table.entities.Student;
import com.complextable.complex_table.repo.DepartmentRepo;
import com.complextable.complex_table.repo.StudentRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private StudentRepo studentRepo;

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    // Get a department by ID
    public Department getDepartmentById(Long id) {
        Optional<Department> department = departmentRepo.findById(id);
        return department.orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));
    }

    // Save a new department
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    // Update an existing department
    public Department updateDepartment(Long id, Department departmentDetails) {
        Department existingDepartment = getDepartmentById(id);

        // Update the department
        existingDepartment.setName(departmentDetails.getName());

        // Update the related students' department
        List<Student> students = studentRepo.findByDepartmentId(id);
        for (Student student : students) {
            student.setDepartment(departmentDetails); // Cascade the department update to students
        }

        return departmentRepo.save(existingDepartment);
    }

    // Delete a department by ID
    public void deleteDepartment(Long id) {
        // First, disassociate students or delete them
        List<Student> studentsInDepartment = studentRepo.findByDepartmentId(id);
        if (!studentsInDepartment.isEmpty()) {
            for (Student student : studentsInDepartment) {
                student.setDepartment(null); // Disassociate students from the department
                studentRepo.save(student); // Save the updated student
            }
        }

        // Now delete the department
        departmentRepo.deleteById(id);
    }

    // Get all students in a specific department
    public List<Student> getStudentsInDepartment(Long departmentId) {
        return studentRepo.findByDepartmentId(departmentId);
    }
}


