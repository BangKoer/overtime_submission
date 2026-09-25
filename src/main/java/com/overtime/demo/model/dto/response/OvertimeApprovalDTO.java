package com.overtime.demo.model.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OvertimeApprovalDTO {
    private Integer approvalId;
    private Integer overtimeId;
    private Integer approverId;
    private String approverName;
    private String approvalLevel;
    private Integer requesterId;
    private String requesterName;
    private LocalDate overtimeDate;
    private Float totalHours;
    private Float overtimePay;
    private String reason;
    private String status;
}