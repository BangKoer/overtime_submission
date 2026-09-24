package com.overtime.demo.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.overtime.demo.model.OvertimeRequest;
import com.overtime.demo.model.dto.response.OvertimeReqDTO;

@Repository 
public interface OvertimeReqRepository extends JpaRepository<OvertimeRequest, Integer> {


    
    @Modifying 
    @Query(value = "CALL sp_add_overtime_request(:p_employee_id, :p_submitted_by_id, :p_date, :p_start_time, :p_end_time, :p_reason)", nativeQuery = true)
    public void addOvertimeReq(
        @Param("p_employee_id") int employee_id,
        @Param("p_submitted_by_id") int submitted_by_id,
        @Param("p_date") LocalDate date,
        @Param("p_start_time") LocalTime start_time,
        @Param("p_end_time") LocalTime end_time,
        @Param("p_reason") String reason
    );
}
