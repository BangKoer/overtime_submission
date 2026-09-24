package com.overtime.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overtime.demo.helper.Response;
import com.overtime.demo.model.dto.request.UserDTO;
import com.overtime.demo.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("api")
public class UserController {
    @Autowired 
    private UserService userService;

    @PostMapping("user/register")
    public ResponseEntity<Object> register(@RequestBody UserDTO userDTO) {
        return Response.generate(userService.register(userDTO), "Success", HttpStatus.OK);
    }
    
}
