package com.overtime.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name = "tb_tr_overtime_request")
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Data 
public class OvertimeRequest {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne 
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne 
    @JoinColumn(name = "submitted_by_id", referencedColumnName = "id")
    private Employee submittedBy;
    
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Float totalHour;
    private Float overtimePay;
    private String reason;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
