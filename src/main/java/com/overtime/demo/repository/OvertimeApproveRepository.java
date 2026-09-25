package com.overtime.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.overtime.demo.model.OvertimeApproval;

@Repository 
public interface OvertimeApproveRepository extends JpaRepository<OvertimeApproval, Integer> {
    
    boolean existsByOvertimeRequestId(Integer overtimeId);

    void deleteByOvertimeRequestId(Integer overtimeId);

    List<OvertimeApproval> findByOvertimeRequestId(Integer id);
    
    @Modifying 
    @Query(value = "CALL sp_approval_overtime(:p_overtime_id, :p_approver_id, :p_level, :p_status, :p_notes)", nativeQuery = true)
    public void addApproval(
        @Param("p_overtime_id") int overtime_id,
        @Param("p_approver_id") int approver_id,
        @Param("p_level") String level,
        @Param("p_status") String status,
        @Param("p_notes") String notes
    );

    
}
