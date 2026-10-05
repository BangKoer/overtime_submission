package com.overtime.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.overtime.demo.helper.EmployeeRole;
import com.overtime.demo.model.Employee;
import com.overtime.demo.model.User;
import com.overtime.demo.model.dto.request.UserDTO;
import com.overtime.demo.model.dto.response.LoginResDTO;
import com.overtime.demo.repository.EmployeeRepository;
import com.overtime.demo.repository.UserRepository;
import com.overtime.demo.security.JWTUtils;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<String> getRole(Employee employee) {
        List<String> roles = new ArrayList<>();

        roles.add("ROLE_EMPLOYEE");

        if (employeeRepository.isManager(employee.getId())) {
            roles.add("ROLE_MANAGER");
        }

        if (employee.getDepartment() != null && "Finance".equalsIgnoreCase(employee.getDepartment().getName())) {
            roles.add("ROLE_FINANCE");
        }

        return roles;
    }

    public LoginResDTO login(UserDTO userDTO) {
        if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty() ||
                userDTO.getPassword() == null || userDTO.getPassword().trim().isEmpty()) {
            throw new IllegalStateException("Email and password are required.");
        }

        User resultUser = userRepository.findByEmail(userDTO.getEmail());
        if (resultUser == null) {
            throw new BadCredentialsException("Invalid email or password.");
        }

        boolean isPasswordMatch = passwordEncoder.matches(userDTO.getPassword(), resultUser.getPassword());
        // boolean isPasswordMatch =
        // resultUser.getPassword().equals(userDTO.getPassword());
        if (!isPasswordMatch) {
            throw new BadCredentialsException("Invalid email or password.");
        }

        Employee resultEmp = resultUser.getEmployee();
        if (resultEmp == null) {
            throw new IllegalStateException("User account is not linked to any active employee profile.");
        }
        
        List<String> roles = EmployeeRole.getRole(resultEmp, employeeRepository);
        String token = jwtUtils.generateToken(resultEmp.getName(), resultUser.getEmail(), resultEmp.getId(), roles);

        return LoginResDTO.builder()
                .token(token)
                .type("Bearer")
                .employeeId(resultEmp.getId())
                .name(resultEmp.getName())
                .email(resultUser.getEmail())
                .roles(roles)
                .build();
    }

    public String register(UserDTO userDTO) {
        if (userDTO.getId() <= 0 || userDTO.getEmail().isEmpty() || userDTO.getPassword().isEmpty()
                || userRepository.existsByEmail(userDTO.getEmail())) {
            return "Failed Operations";
        }

        Employee employee = employeeRepository.findById(userDTO.getId()).orElse(null);

        User user = User.builder()
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .employee(employee)
                .build();

        userRepository.save(user);
        return "Operation Success";
    }
}
