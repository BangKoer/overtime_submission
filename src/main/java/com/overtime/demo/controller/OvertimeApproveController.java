package com.overtime.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overtime.demo.helper.Response;
import com.overtime.demo.model.dto.request.OvertimeApproveDTO;
import com.overtime.demo.service.OvertimeApproveService;
import com.overtime.demo.service.ViewOvertimeApprovalService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping("api")
public class OvertimeApproveController {
    @Autowired 
    private OvertimeApproveService overtimeApproveService;

    @Autowired 
    private ViewOvertimeApprovalService viewOvertimeApprovalService;

    @GetMapping("OvertimeApproves")
    public ResponseEntity<Object> getAllApproval() {
        return Response.generate(viewOvertimeApprovalService.getAllOvertimeApproval(), "Success", HttpStatus.OK);
    }

    @GetMapping("OvertimeApproves/{overtimeId}")
    public ResponseEntity<Object> getMethodName(@PathVariable(name = "overtimeId") int overtime_id) {
        return Response.generate(viewOvertimeApprovalService.getApprovalByOvertimeId(overtime_id), "Success", HttpStatus.OK);
    }
    

    @PostMapping("OvertimeApprove/addApproveOvertime")
    public ResponseEntity<Object> createOvertimeApproval(@RequestBody OvertimeApproveDTO overtimeApproveDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String res = overtimeApproveService.addOvertimeApproval(overtimeApproveDTO, authentication);
        return Response.generate(res, HttpStatus.OK);
    }

    @DeleteMapping("OvertimeApprove/delete/{overtimeId}")
    public ResponseEntity<Object> deleteApprovalByOvrId(@PathVariable(name = "overtimeId") int overtimeId) {
        return Response.generate(overtimeApproveService.deleteOvertimeApprovalByOvrId(overtimeId), HttpStatus.OK);
    }
    
    
}
