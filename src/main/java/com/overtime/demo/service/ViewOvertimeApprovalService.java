package com.overtime.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.dto.response.OvertimeApprovalDTO;
import com.overtime.demo.repository.ViewOvertimeApprovalRepository;
import com.overtime.demo.vw.ViewOvertimeApproval;

@Service
public class ViewOvertimeApprovalService {
    @Autowired
    private ViewOvertimeApprovalRepository viewOvertimeApprovalRepository;

    public List<OvertimeApprovalDTO> getAllOvertimeApproval() {
        List<ViewOvertimeApproval> overtimeApprovals = viewOvertimeApprovalRepository.findAll();
        return overtimeApprovals.stream()
                .map(vw -> new OvertimeApprovalDTO(
                        vw.getApprovalId(),
                        vw.getOvertimeId(),
                        vw.getApproverId(),
                        vw.getApproverName(),
                        vw.getApprovalLevel(),
                        vw.getRequesterId(),
                        vw.getRequesterName(),
                        vw.getOvertimeDate(),
                        vw.getTotalHours(),
                        vw.getOvertimePay(),
                        vw.getReason(),
                        vw.getStatus()))
                .collect(Collectors.toList());
    }

    public List<OvertimeApprovalDTO> getApprovalByOvertimeId(int id) {
        List<ViewOvertimeApproval> overtimeApprovals = viewOvertimeApprovalRepository.findByOvertimeId(id);
        return overtimeApprovals.stream()
                .map(vw -> new OvertimeApprovalDTO(
                        vw.getApprovalId(),
                        vw.getOvertimeId(),
                        vw.getApproverId(),
                        vw.getApproverName(),
                        vw.getApprovalLevel(),
                        vw.getRequesterId(),
                        vw.getRequesterName(),
                        vw.getOvertimeDate(),
                        vw.getTotalHours(),
                        vw.getOvertimePay(),
                        vw.getReason(),
                        vw.getStatus()))
                .collect(Collectors.toList());
    }
}
