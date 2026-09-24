package com.overtime.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overtime.demo.helper.Response;
import com.overtime.demo.model.dto.request.OvertimeDTO;
import com.overtime.demo.model.dto.response.EmployeeDTO;
import com.overtime.demo.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public ResponseEntity<Object> getAll() {
        return Response.generate(employeeService.getAllEmployee(), "Success Retrieve Data", HttpStatus.OK);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable(name = "id") int id) {
        return Response.generate(employeeService.getEmployee(id), "Success Retrieve Data", HttpStatus.OK);
    }

}
