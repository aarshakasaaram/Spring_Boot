package com.example.restapi.usecase.employee.student.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.restapi.usecase.employee.student.project.entity.Employee;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query(value = "select * from Employee where employee_name = :name", nativeQuery = true)
    public Optional<Employee> findByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "delete from Employee where employee_name = :name", nativeQuery = true)
    public void deleteByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "delete from Employee where employee_desig = :employee_desig", nativeQuery = true)
    public void deleteByDesig(@Param("employee_desig") String employee_desig);
}