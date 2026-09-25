package com.overtime.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overtime.demo.vw.ViewOvertimeRequests;
import java.util.List;


@Repository 
public interface ViewOvertimeRequestRepository extends JpaRepository<ViewOvertimeRequests, Integer> {
    
    List<ViewOvertimeRequests> findBySupervisorIdAndRequestStatus(int supervisor_id ,String requestStatus);
    
    List<ViewOvertimeRequests> findByRequestStatus(String requestStatus);
    
}
