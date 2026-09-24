package com.overtime.demo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class UserDTO {
    private int id;
    private String email;
    private String password;
}
