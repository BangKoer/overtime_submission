package com.overtime.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overtime.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("api")
public class DepartmentController {
    @Autowired 
    private DepartmentService departmentService;

    @PostMapping("department")
    public String postInsertNewDepartment(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    

}
