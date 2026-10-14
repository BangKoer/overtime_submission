package com.overtime.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.Employee;
import com.overtime.demo.model.OvertimeApproval;
import com.overtime.demo.model.OvertimeRequest;
import com.overtime.demo.model.dto.request.OvertimeDTO;
import com.overtime.demo.repository.EmployeeRepository;
import com.overtime.demo.repository.OvertimeApproveRepository;
import com.overtime.demo.repository.OvertimeReqRepository;

@Service
public class OvertimeReqService {
    @Autowired
    private OvertimeReqRepository overtimeReqRepository;

    @Autowired
    private OvertimeApproveRepository overtimeApproveRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public String deleteOvertimeReq(int id) {
        OvertimeRequest overtimeRequest = overtimeReqRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Operation Failed: Overtime ID Not Found"));

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
    public String addOvertimeReq(OvertimeDTO overtimeDTO) {
        if (overtimeDTO.getEmployee_id() <= 0 ||
                overtimeDTO.getSubmitted_by_id() <= 0 ||
                overtimeDTO.getReason().isEmpty()) {
            throw new IllegalStateException("Operation Failed:");
        }

        Employee employee = employeeRepository.findById(overtimeDTO.getEmployee_id())
                .orElseThrow(() -> new IllegalStateException("Operation Failed: Employee Not Found"));

        Employee submitter = employeeRepository.findById(overtimeDTO.getSubmitted_by_id())
                .orElseThrow(() -> new IllegalStateException("Operation Failed: Employee Not Found"));

        try {
            overtimeReqRepository.addOvertimeReq(employee.getId(), submitter.getId(),
                    overtimeDTO.getDate(), overtimeDTO.getStart_time(), overtimeDTO.getEnd_time(),
                    overtimeDTO.getReason());
            return "Success";
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Failed";
        }
    }

    public String editOvertimeReq(OvertimeDTO overtimeDTO) {
        OvertimeRequest overtimeRequest = overtimeReqRepository.findById(overtimeDTO.getId())
                .orElseThrow(() -> new IllegalStateException("Operation Failed: Overtime Request Not Found"));
        Employee employee = employeeRepository.findById(overtimeDTO.getEmployee_id())
                .orElseThrow(() -> new IllegalStateException("Operation Failed: Employee Not Found"));
        Employee submitter = employeeRepository.findById(overtimeDTO.getSubmitted_by_id())
                .orElseThrow(() -> new IllegalStateException("Operation Failed: Employee Not Found"));

        try {
            // overtimeReqRepository
            return "";
        } catch (Exception e) {
            // TODO: handle exception
            return "";
        }
    }
}
