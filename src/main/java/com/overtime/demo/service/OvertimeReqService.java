package com.overtime.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.dto.request.OvertimeDTO;
import com.overtime.demo.repository.OvertimeReqRepository;

@Service 
public class OvertimeReqService {
    @Autowired 
    private OvertimeReqRepository overtimeReqRepository;

    // Numpang Overtime call sp
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
