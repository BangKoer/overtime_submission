package com.overtime.demo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class OvertimeApproveDTO {
    private Integer overtime_id;
    private Integer approver_id;
    private String level;       // value : (1: Manager, 2: Finance)
    private String status;      // value : ("Approved", "Rejected")
    private String notes;

}
