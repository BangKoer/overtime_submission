package com.overtime.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.dto.request.OvertimeApproveDTO;
import com.overtime.demo.repository.OvertimeApproveRepository;

@Service 
public class OvertimeApproveService {
    @Autowired 
    private OvertimeApproveRepository overtimeApproveRepository;

    @Transactional 
    public String addOvertimeApproval(OvertimeApproveDTO overtimeApproveDTO){
        boolean isValidLevel = "1: Manager".equals(overtimeApproveDTO.getLevel()) || "2: Finance".equals(overtimeApproveDTO.getLevel());
        boolean isValidStatus = "Approved".equals(overtimeApproveDTO.getStatus()) || "Rejected".equals(overtimeApproveDTO.getStatus());
        boolean isNotesValid = overtimeApproveDTO.getNotes() != null && !overtimeApproveDTO.getNotes().trim().isEmpty();

        if (
            overtimeApproveDTO.getOvertime_id() <= 0 ||
            overtimeApproveDTO.getApprover_id() <= 0 ||
            overtimeApproveDTO.getNotes().isEmpty() ||
            !isValidLevel ||
            !isValidStatus ||
            !isNotesValid
        ) {
            return "Operation Failed";
        }

        try {
            overtimeApproveRepository.addApproval(overtimeApproveDTO.getOvertime_id(), overtimeApproveDTO.getApprover_id(), overtimeApproveDTO.getLevel(), overtimeApproveDTO.getStatus(), overtimeApproveDTO.getNotes());
            return "Success Approve Overtime ID : " + overtimeApproveDTO.getOvertime_id();
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Error : Cant Execute Operation";
        }
    }
}
