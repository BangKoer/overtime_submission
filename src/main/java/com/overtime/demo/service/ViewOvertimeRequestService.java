package com.overtime.demo.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.dto.response.OvertimeReqDTO;
import com.overtime.demo.repository.ViewOvertimeRequestRepository;
import com.overtime.demo.vw.ViewOvertimeRequests;

@Service
public class ViewOvertimeRequestService {
    @Autowired
    private ViewOvertimeRequestRepository viewOvertimeRepository;

    public List<OvertimeReqDTO> getAllOvertimeRequest() {
        List<ViewOvertimeRequests> overtimeRequests = viewOvertimeRepository.findAll();
        return overtimeRequests.stream()
                .map(vw -> new OvertimeReqDTO(
                        vw.getOvertimeId(),
                        vw.getOvertimeDate(),
                        vw.getEmployeeId(),
                        vw.getEmployeeName(),
                        vw.getSubmitterId(),
                        vw.getSubmittedByName(),
                        vw.getSupervisorId(),
                        vw.getSupervisorName(),
                        vw.getDepartmentId(),
                        vw.getDepartmentName(),
                        vw.getStartTime(),
                        vw.getEndTime(),
                        vw.getTotalHours(),
                        vw.getOvertimePay(),
                        vw.getReason(),
                        vw.getRequestStatus()))
                .collect(Collectors.toList());
    }

    public OvertimeReqDTO getOvertimeRequestById(int id) {
        ViewOvertimeRequests overtimeRequest = viewOvertimeRepository.findById(id).orElse(null);
        return new OvertimeReqDTO(
                overtimeRequest.getOvertimeId(),
                overtimeRequest.getOvertimeDate(),
                overtimeRequest.getEmployeeId(),
                overtimeRequest.getEmployeeName(),
                overtimeRequest.getSubmitterId(),
                overtimeRequest.getSubmittedByName(),
                overtimeRequest.getSupervisorId(),
                overtimeRequest.getSupervisorName(),
                overtimeRequest.getDepartmentId(),
                overtimeRequest.getDepartmentName(),
                overtimeRequest.getStartTime(),
                overtimeRequest.getEndTime(),
                overtimeRequest.getTotalHours(),
                overtimeRequest.getOvertimePay(),
                overtimeRequest.getReason(),
                overtimeRequest.getRequestStatus());
    }

    public List<OvertimeReqDTO> getOvertimeRequestBySupIdAndStatus(int id, String status) {
        List<ViewOvertimeRequests> overtimeRequests = viewOvertimeRepository.findBySupervisorIdAndRequestStatus(id, status);
        return overtimeRequests.stream()
                .map(vw -> new OvertimeReqDTO(
                        vw.getOvertimeId(),
                        vw.getOvertimeDate(),
                        vw.getEmployeeId(),
                        vw.getEmployeeName(),
                        vw.getSubmitterId(),
                        vw.getSubmittedByName(),
                        vw.getSupervisorId(),
                        vw.getSupervisorName(),
                        vw.getDepartmentId(),
                        vw.getDepartmentName(),
                        vw.getStartTime(),
                        vw.getEndTime(),
                        vw.getTotalHours(),
                        vw.getOvertimePay(),
                        vw.getReason(),
                        vw.getRequestStatus()))
                .collect(Collectors.toList());
    }
}
