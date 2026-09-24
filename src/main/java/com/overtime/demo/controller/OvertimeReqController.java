package com.overtime.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overtime.demo.helper.Response;
import com.overtime.demo.model.dto.request.OvertimeDTO;
import com.overtime.demo.service.OvertimeReqService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("api")
public class OvertimeReqController {
    @Autowired 
    private OvertimeReqService overtimeReqService;

    @PostMapping("addOvertimeReq")
    public ResponseEntity<Object> postAddOvertimeReq(@RequestBody OvertimeDTO overtimeDTO) {
        String res = overtimeReqService.addOvertimeReq(overtimeDTO);
        return Response.generate(res);
    }
    
}
