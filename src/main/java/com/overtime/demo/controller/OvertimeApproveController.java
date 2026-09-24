package com.overtime.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overtime.demo.helper.Response;
import com.overtime.demo.model.dto.request.OvertimeApproveDTO;
import com.overtime.demo.service.OvertimeApproveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("api")
public class OvertimeApproveController {
    @Autowired 
    private OvertimeApproveService overtimeApproveService;

    @PostMapping("OvertimeApprove/addApproveOvertime")
    public ResponseEntity<Object> createOvertimeApproval(@RequestBody OvertimeApproveDTO overtimeApproveDTO) {
        String res = overtimeApproveService.addOvertimeApproval(overtimeApproveDTO);
        return Response.generate(res, HttpStatus.OK);
    }
    
}
