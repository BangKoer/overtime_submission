package com.overtime.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overtime.demo.model.Department;

@Repository 
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    // public Department insertNewDepartment();
}
