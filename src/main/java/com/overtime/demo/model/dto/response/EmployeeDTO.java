package com.overtime.demo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class EmployeeDTO {
    private int id;
    private String name;
    private float basic_salary;
    private String department;
}
