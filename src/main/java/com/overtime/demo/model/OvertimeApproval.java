package com.overtime.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "tb_tr_overtime_approval")
@AllArgsConstructor 
@NoArgsConstructor 
@Data 
@Builder 
public class OvertimeApproval {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "overtime_id", referencedColumnName = "id")
    private OvertimeRequest overtimeRequest;

    @ManyToOne
    @JoinColumn(name = "approver_id", referencedColumnName = "id") 
    private Employee approver;

    private String level;
    private String status;
    private LocalDateTime date;
    private String notes;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
