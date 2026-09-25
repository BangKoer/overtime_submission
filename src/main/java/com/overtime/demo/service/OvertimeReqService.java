package com.overtime.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.OvertimeApproval;
import com.overtime.demo.model.OvertimeRequest;
import com.overtime.demo.model.dto.request.OvertimeDTO;
import com.overtime.demo.repository.OvertimeApproveRepository;
import com.overtime.demo.repository.OvertimeReqRepository;

@Service 
public class OvertimeReqService {
    @Autowired 
    private OvertimeReqRepository overtimeReqRepository;

    @Autowired 
    private OvertimeApproveRepository overtimeApproveRepository;

    public String deleteOvertimeReq(int id){
        OvertimeRequest overtimeRequest = overtimeReqRepository.findById(id).orElse(null);

        if ("Awaiting Manager Approval (Lv1)".equals(overtimeRequest.getStatus())) {
            return "Cannot delete request. Status Not Eligible to Delete";
        }

        if (overtimeApproveRepository.existsByOvertimeRequestId(id)) {
            return "Cannot delete request. An approval process has already been recorded for this request";
        }

        overtimeReqRepository.delete(overtimeRequest);

        return "Overtime request ID " + id + " has been successfully deleted";
    }

    @Transactional 
    public String addOvertimeReq(OvertimeDTO overtimeDTO){
        if (
            overtimeDTO.getEmployee_id() <= 0 || 
            overtimeDTO.getSubmitted_by_id() <= 0 || 
            overtimeDTO.getReason().isEmpty()
        ) {
            return "Failed to Add Overtime Request";
        }

        try {
            overtimeReqRepository.addOvertimeReq(overtimeDTO.getEmployee_id(), overtimeDTO.getSubmitted_by_id(), overtimeDTO.getDate(), overtimeDTO.getStart_time(), overtimeDTO.getEnd_time(), overtimeDTO.getReason());
            return "Success";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Failed";
        }
    }
}   
