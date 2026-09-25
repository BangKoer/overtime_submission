package com.overtime.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overtime.demo.helper.Response;
import com.overtime.demo.model.dto.request.OvertimeDTO;
import com.overtime.demo.service.OvertimeReqService;
import com.overtime.demo.service.ViewOvertimeRequestService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api")
public class OvertimeReqController {
    @Autowired
    private OvertimeReqService overtimeReqService;

    @Autowired 
    private ViewOvertimeRequestService viewOvertimeRequestService;

    @GetMapping("OvertimeReqs")
    public ResponseEntity<Object> getAllOvertime() {
        return Response.generate(viewOvertimeRequestService.getAllOvertimeRequest(), "Success", HttpStatus.OK);
    }

    @GetMapping("OvertimeReqs/{id}")
    public ResponseEntity<Object> getOvertimeReqById(@PathVariable(name = "id") int id) {
        return Response.generate(viewOvertimeRequestService.getOvertimeRequestById(id),"Success", HttpStatus.OK);
    }

    @GetMapping("OvertimeReqs/sup/{id}")
    public ResponseEntity<Object> getMethodName(@PathVariable(name = "id") int id, @RequestParam(name = "status") String status) {
        return Response.generate(viewOvertimeRequestService.getOvertimeRequestBySupIdAndStatus(id, status),"Success", HttpStatus.OK);
    }

    @DeleteMapping("OvertimeReqs/delete/{id}")
    public ResponseEntity<Object> postMethodName(@PathVariable(name = "id") int id) {
        return Response.generate(overtimeReqService.deleteOvertimeReq(id), HttpStatus.OK);
    }
    

    @PostMapping("OvertimeReqs/addOvertimeReq")
    public ResponseEntity<Object> createOvertimeReq(@RequestBody OvertimeDTO overtimeDTO) {
        String res = overtimeReqService.addOvertimeReq(overtimeDTO);
        return Response.generate(res, HttpStatus.OK);
    }

}
