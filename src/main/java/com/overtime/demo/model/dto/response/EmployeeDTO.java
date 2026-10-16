package com.overtime.demo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @AllArgsConstructor 
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Float basic_salary;
    private String department;

    public EmployeeDTO(Integer id, String name, Float basic_salary, String department) {
        this.id = id;
        this.name = name;
        this.basic_salary = basic_salary;
        this.department = department;
    }
}
