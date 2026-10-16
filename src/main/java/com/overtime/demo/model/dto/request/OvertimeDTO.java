package com.overtime.demo.model.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class OvertimeDTO {
    private Integer id;
    private Integer employee_id;
    private Integer submitted_by_id;
    private LocalDate date;
    private LocalTime start_time; 
    private LocalTime end_time;
    private String reason;
    
    public OvertimeDTO(Integer id, Integer employee_id, Integer submitted_by_id, LocalDate date, LocalTime start_time,
            LocalTime end_time, String reason) {
        this.id = id;
        this.employee_id = employee_id;
        this.submitted_by_id = submitted_by_id;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.reason = reason;
    }

    public OvertimeDTO(Integer employee_id, Integer submitted_by_id, LocalDate date, LocalTime start_time,
            LocalTime end_time, String reason) {
        this.employee_id = employee_id;
        this.submitted_by_id = submitted_by_id;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.reason = reason;
    } 
}
