package com.overtime.demo.vw;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "vw_detailed_approval")
@Immutable 
@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
public class ViewOvertimeApproval {
    @Id 
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
