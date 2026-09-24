package com.overtime.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.Department;
import com.overtime.demo.model.dto.request.DepartmentDTO;
import com.overtime.demo.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service 
public class DepartmentService {
    @Autowired 
    private DepartmentRepository departmentRepository;

    public Department createNewDepartment(DepartmentDTO requestDTO){
        Department department = Department.builder()
                                .name(requestDTO.getName())
                                .created_at(LocalDateTime.now())
                                .updated_at(LocalDateTime.now())
                                .build();
        return departmentRepository.save(department);
    }

}
