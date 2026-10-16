package com.overtime.demo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @AllArgsConstructor 
@NoArgsConstructor
@Data
public class OvertimeApproveDTO {
    private Integer overtime_id;
    private Integer approver_id;
    // private String level; // value : (1: Manager, 2: Finance)
    private String status; // value : ("Approved", "Rejected")
    private String notes;

    public OvertimeApproveDTO(Integer overtime_id, Integer approver_id, String status, String notes) {
        this.overtime_id = overtime_id;
        this.approver_id = approver_id;
        this.status = status;
        this.notes = notes;
    }


}
