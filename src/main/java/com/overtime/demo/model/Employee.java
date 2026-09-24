package com.overtime.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="tb_m_employee")
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Data 
public class Employee {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float basic_salary;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    
    @ManyToOne 
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    private Employee supervisor;
    
    @ManyToOne 
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

}
