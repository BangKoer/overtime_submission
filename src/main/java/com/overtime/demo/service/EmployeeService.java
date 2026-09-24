package com.overtime.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtime.demo.model.dto.request.OvertimeDTO;
import com.overtime.demo.model.dto.response.EmployeeDTO;
import com.overtime.demo.repository.EmployeeRepository;


@Service  
public class EmployeeService {
    @Autowired 
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployee(){
        return employeeRepository.getEmployee();
    }

    public EmployeeDTO getEmployee(int id){
        if (id <= 0) {
            return null;
        }

        return employeeRepository.getEmployee(id);
    }

    
}
