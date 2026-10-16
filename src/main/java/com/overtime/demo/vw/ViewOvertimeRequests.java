package com.overtime.demo.vw;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "vw_detailed_overtime_request")
@Immutable 
@NoArgsConstructor
// @AllArgsConstructor  
@Getter  
public class ViewOvertimeRequests {

    @Id
    private int overtimeId;
    
    private LocalDate overtimeDate;
    private Integer employeeId;
    private String employeeName;
    private Integer submitterId;
    private String submittedByName;
    private Integer supervisorId;
    private String supervisorName;
    private Integer departmentId;
    private String departmentName;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer totalHours;
    private Float overtimePay;
    private String reason;
    private String requestStatus;
    
    public ViewOvertimeRequests(int overtimeId, LocalDate overtimeDate, Integer employeeId, String employeeName,
            Integer submitterId, String submittedByName, Integer supervisorId, String supervisorName,
            Integer departmentId, String departmentName, LocalTime startTime, LocalTime endTime, Integer totalHours,
            Float overtimePay, String reason, String requestStatus) {
        this.overtimeId = overtimeId;
        this.overtimeDate = overtimeDate;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.submitterId = submitterId;
        this.submittedByName = submittedByName;
        this.supervisorId = supervisorId;
        this.supervisorName = supervisorName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalHours = totalHours;
        this.overtimePay = overtimePay;
        this.reason = reason;
        this.requestStatus = requestStatus;
    }
}
