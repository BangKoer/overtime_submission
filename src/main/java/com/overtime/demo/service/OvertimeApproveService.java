package com.overtime.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.OvertimeApproval;
import com.overtime.demo.model.OvertimeRequest;
import com.overtime.demo.model.dto.request.OvertimeApproveDTO;
import com.overtime.demo.repository.OvertimeApproveRepository;
import com.overtime.demo.repository.OvertimeReqRepository;

@Service 
public class OvertimeApproveService {
    @Autowired 
    private OvertimeApproveRepository overtimeApproveRepository;

    @Autowired 
    private OvertimeReqRepository overtimeReqRepository;

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

    @Transactional 
    public String deleteOvertimeApprovalByOvrId(int overtimeId){
        OvertimeRequest overtimeRequest = overtimeReqRepository.findById(overtimeId).orElse(null);

        if (!overtimeApproveRepository.existsByOvertimeRequestId(overtimeId)) {
            return "Operation Failed. ID Not Found";
        }

        overtimeApproveRepository.deleteByOvertimeRequestId(overtimeId);

        overtimeRequest.setStatus("Awaiting Manager Approval (Lv1)");
        overtimeReqRepository.save(overtimeRequest);

        return "Successfully Delete Approval and Reset Status" + overtimeId;
    }
}
