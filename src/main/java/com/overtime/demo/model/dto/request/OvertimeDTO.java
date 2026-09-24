package com.overtime.demo.model.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class OvertimeDTO {
    private int employee_id;
    private int submitted_by_id;
    private LocalDate date;
    private LocalTime start_time; 
    private LocalTime end_time;
    private String reason; 
}
