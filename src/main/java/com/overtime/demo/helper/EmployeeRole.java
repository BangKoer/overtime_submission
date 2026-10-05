package com.overtime.demo.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.overtime.demo.model.Employee;
import com.overtime.demo.repository.EmployeeRepository;

public class EmployeeRole {

    public static List<String> getRole(Employee employee, EmployeeRepository employeeRepository){
        List<String> roles = new ArrayList<>();

        roles.add("ROLE_EMPLOYEE");

        if (employeeRepository.isManager(employee.getId())) {
            roles.add("ROLE_MANAGER");
        }

        if (employee.getDepartment() != null && "Finance".equalsIgnoreCase(employee.getDepartment().getName())) {
            roles.add("ROLE_FINANCE");
        }
        return roles;
    }
}
