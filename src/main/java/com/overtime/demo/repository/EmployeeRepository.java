package com.overtime.demo.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.overtime.demo.model.Employee;
import com.overtime.demo.model.dto.response.EmployeeDTO;

@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("""
            SELECT
                new com.overtime.demo.model.dto.response.EmployeeDTO(e.id, e.name, e.basicSalary, d.name)
                FROM Employee e
                JOIN e.department d
                """)
    public List<EmployeeDTO> getEmployee();
    
    @Query("""
            SELECT
                new com.overtime.demo.model.dto.response.EmployeeDTO(e.id, e.name, e.basicSalary, d.name)
                FROM Employee e
                JOIN e.department d WHERE e.id = ?1
                """)
    public EmployeeDTO getEmployee(int id);
    
}
