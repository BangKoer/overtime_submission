package com.overtime.demo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Float basic_salary;
    private String department;
}
