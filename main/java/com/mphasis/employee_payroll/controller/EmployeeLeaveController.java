package com.mphasis.employee_payroll.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.employee_payroll.model.EmployeeLeave;
import com.mphasis.employee_payroll.service.EmployeeLeaveService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeLeaveController {

	private EmployeeLeaveService employeeLeaveService;

	public EmployeeLeaveController(EmployeeLeaveService employeeLeaveService) {
		super();
		this.employeeLeaveService = employeeLeaveService;
	}

	@GetMapping("/employeeleaves")
	public List<EmployeeLeave> getAllLeave() {
		return employeeLeaveService.getAllLeave();
	}

	@GetMapping("/employeeleaves/{id}")
	public ResponseEntity<EmployeeLeave> getLeaveById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<EmployeeLeave>(employeeLeaveService.getLeaveById(employeeId), HttpStatus.OK);
	}
}