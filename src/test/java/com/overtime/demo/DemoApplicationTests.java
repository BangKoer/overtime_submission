package com.overtime.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.overtime.demo.model.dto.response.EmployeeDTO;
import com.overtime.demo.service.EmployeeService;


@SpringBootTest
class DemoApplicationTests {
	// AAA
	// - Arrange (siapkan hal-hal yang ingin di testing)
	@Autowired 
	private EmployeeService employeeService;

	
	// - Assert
	@Test
	void contextLoads() {
		// - Act
		List<EmployeeDTO> employee = employeeService.getAllEmployee();
		int actual = employee.size();

		// - Assert (Validate)
		assertEquals(10, actual);
	}

}
