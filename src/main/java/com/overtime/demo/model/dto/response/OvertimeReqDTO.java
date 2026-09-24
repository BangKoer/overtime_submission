package com.overtime.demo.model.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class OvertimeReqDTO {
    private Integer overtime_id;
    private LocalDate overtime_date;
    private Integer employee_id;
    private String employee_name;
    private Integer submitter_id;
    private String submitted_by_name;
    private Integer supervisor_id;
    private String supervisor_name;
    private Integer department_id;
    private String department_name;
    private LocalTime start_time;
    private LocalTime end_time;
    private Integer total_hours;
    private Float overtime_pay;
    private String reason;
    private String request_status;

}
