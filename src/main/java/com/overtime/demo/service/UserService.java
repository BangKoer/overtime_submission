package com.overtime.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.Employee;
import com.overtime.demo.model.User;
import com.overtime.demo.model.dto.request.UserDTO;
import com.overtime.demo.repository.EmployeeRepository;
import com.overtime.demo.repository.UserRepository;

@Service 
public class UserService {
    @Autowired 
    private UserRepository userRepository;

    @Autowired 
    private EmployeeRepository employeeRepository;

    public String register(UserDTO userDTO){
        if (userDTO.getId() <= 0 || userDTO.getEmail().isEmpty() || userDTO.getPassword().isEmpty() || userRepository.existsByEmail(userDTO.getEmail())) {
            return "Failed Operations";
        }

        Employee employee = employeeRepository.findById(userDTO.getId()).orElse(null);

        User user = User.builder()
                    .email(userDTO.getEmail())
                    .password(userDTO.getPassword())
                    .employee(employee)
                    .build();

        userRepository.save(user);
        return "Operation Success";
    }
}
