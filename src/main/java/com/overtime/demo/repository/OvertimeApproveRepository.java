package com.overtime.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overtime.demo.model.OvertimeApproval;

@Repository 
public interface OvertimeApproveRepository extends JpaRepository<OvertimeApproval, Integer> {

}
