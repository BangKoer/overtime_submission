package com.overtime.demo.model.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class LoginResDTO {
    private String token;
    private String type = "Bearer";
    private Integer employeeId;
    private String name;
    private String email;
    private List<String> roles;
}
