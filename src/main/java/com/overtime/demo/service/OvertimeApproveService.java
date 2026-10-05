package com.overtime.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.overtime.demo.helper.EmployeeRole;
import com.overtime.demo.model.Employee;
import com.overtime.demo.model.OvertimeApproval;
import com.overtime.demo.model.OvertimeRequest;
import com.overtime.demo.model.dto.request.OvertimeApproveDTO;
import com.overtime.demo.repository.EmployeeRepository;
import com.overtime.demo.repository.OvertimeApproveRepository;
import com.overtime.demo.repository.OvertimeReqRepository;
import com.overtime.demo.security.JWTUtils;

@Service
public class OvertimeApproveService {
    @Autowired
    private OvertimeApproveRepository overtimeApproveRepository;

    @Autowired
    private OvertimeReqRepository overtimeReqRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Transactional
    public String addOvertimeApproval(OvertimeApproveDTO overtimeApproveDTO, Authentication loggedEmployeeAuth) {
        // Check Token and ID for Approver
        String token = (String) loggedEmployeeAuth.getCredentials();
        if (token.isEmpty()) {
            throw new IllegalStateException("Operation Failed: No Token.");
        }

        Integer loggedEmployeeId = jwtUtils.getEmployeeIdFromJwtToken(token);
        if (overtimeApproveDTO.getApprover_id() != loggedEmployeeId) {
            throw new IllegalStateException("Operation Failed: Unauthorized! Token ID does not match request payload.");
        }

        // Check is status valid and notes is Filled
        boolean isValidStatus = "Approved".equals(overtimeApproveDTO.getStatus())
                || "Rejected".equals(overtimeApproveDTO.getStatus());
        boolean isNotesValid = overtimeApproveDTO.getNotes() != null && !overtimeApproveDTO.getNotes().trim().isEmpty();

        if (overtimeApproveDTO.getOvertime_id() <= 0 ||
                overtimeApproveDTO.getApprover_id() <= 0 ||
                overtimeApproveDTO.getNotes().isEmpty() ||
                !isValidStatus ||
                !isNotesValid) {
            throw new IllegalStateException("Operation Failed");
        }

        // Check If theres actually that said employee and overtime is requested
        Employee employee = employeeRepository.findById(overtimeApproveDTO.getApprover_id()).orElseThrow(
                () -> new IllegalArgumentException("Employee not found ID: " + overtimeApproveDTO.getApprover_id()));
        OvertimeRequest overtimeRequest = overtimeReqRepository.findById(overtimeApproveDTO.getOvertime_id())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Overtime Request not found ID: " + overtimeApproveDTO.getOvertime_id()));
        
        // Check if the request approval process
        String currentStatus = overtimeRequest.getStatus();
        if ("Fully Approved".equals(currentStatus) || "Rejected".equals(currentStatus)) {
            throw new IllegalStateException("Operation Failed: Overtime request is already " + currentStatus
                    + " and cannot receive further decisions.");
        }

        String level = "";
        List<String> roles = EmployeeRole.getRole(employee, employeeRepository);

        if (roles.contains("ROLE_MANAGER") && "Awaiting Manager Approval (Lv1)".equals(overtimeRequest.getStatus())) {
            level = "1: Manager";
        }

        if (roles.contains("ROLE_FINANCE") && "Awaiting Finance Approval (Lv2)".equals(overtimeRequest.getStatus())) {
            level = "2: Finance";
        }

        if (level.isEmpty()) {
            throw new IllegalStateException(
                    "Operation Failed: User is not eligible to approve at status '" + currentStatus + "'.");
        }

        try {
            overtimeApproveRepository.addApproval(overtimeApproveDTO.getOvertime_id(),
                    overtimeApproveDTO.getApprover_id(), level, overtimeApproveDTO.getStatus(),
                    overtimeApproveDTO.getNotes());
            return "Success Approve Overtime ID : " + overtimeApproveDTO.getOvertime_id();
        } catch (Exception e) {
            System.out.println(e.toString());
            return "Error : Cant Execute Operation";
        }
    }

    @Transactional
    public String deleteOvertimeApprovalByOvrId(int overtimeId) {
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
