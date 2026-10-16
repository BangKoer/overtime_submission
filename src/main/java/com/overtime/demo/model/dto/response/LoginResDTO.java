package com.overtime.demo.model.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@Builder
public class LoginResDTO {
    private String token;
    private String type = "Bearer";
    private Integer employeeId;
    private Integer departmentId;
    private String name;
    private String email;
    private List<String> roles;
    
    public LoginResDTO(String token, String type, Integer employeeId, Integer departmentId, String name, String email,
            List<String> roles) {
        this.token = token;
        this.type = type;
        this.employeeId = employeeId;
        this.departmentId = departmentId;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    

}
