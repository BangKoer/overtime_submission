package com.overtime.demo.model.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @AllArgsConstructor 
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
    public OvertimeReqDTO(Integer overtime_id, LocalDate overtime_date, Integer employee_id, String employee_name,
            Integer submitter_id, String submitted_by_name, Integer supervisor_id, String supervisor_name,
            Integer department_id, String department_name, LocalTime start_time, LocalTime end_time,
            Integer total_hours, Float overtime_pay, String reason, String request_status) {
        this.overtime_id = overtime_id;
        this.overtime_date = overtime_date;
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.submitter_id = submitter_id;
        this.submitted_by_name = submitted_by_name;
        this.supervisor_id = supervisor_id;
        this.supervisor_name = supervisor_name;
        this.department_id = department_id;
        this.department_name = department_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.total_hours = total_hours;
        this.overtime_pay = overtime_pay;
        this.reason = reason;
        this.request_status = request_status;
    }

    

}
