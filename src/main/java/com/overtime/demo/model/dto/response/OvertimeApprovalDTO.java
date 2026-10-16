package com.overtime.demo.model.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @AllArgsConstructor
@Data
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
    private LocalDateTime reviewAt;

    public OvertimeApprovalDTO(Integer approvalId, Integer overtimeId, Integer approverId, String approverName,
            String approvalLevel, Integer requesterId, String requesterName, LocalDate overtimeDate, Float totalHours,
            Float overtimePay, String reason, String status, LocalDateTime reviewAt) {
        this.approvalId = approvalId;
        this.overtimeId = overtimeId;
        this.approverId = approverId;
        this.approverName = approverName;
        this.approvalLevel = approvalLevel;
        this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.overtimeDate = overtimeDate;
        this.totalHours = totalHours;
        this.overtimePay = overtimePay;
        this.reason = reason;
        this.status = status;
        this.reviewAt = reviewAt;
    }
}