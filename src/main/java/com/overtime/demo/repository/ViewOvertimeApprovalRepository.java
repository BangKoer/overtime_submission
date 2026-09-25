package com.overtime.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overtime.demo.vw.ViewOvertimeApproval;

@Repository 
public interface ViewOvertimeApprovalRepository extends JpaRepository<ViewOvertimeApproval, Integer> {
    List<ViewOvertimeApproval> findByOvertimeId(Integer overtimeId);
}
