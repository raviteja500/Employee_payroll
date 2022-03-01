package com.mphasis.employee_payroll.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.employee_payroll.model.EmployeeAttendance;
import com.mphasis.employee_payroll.service.EmployeeAttendanceService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeAttendanceController {

	private EmployeeAttendanceService employeeAttendanceService;

	public EmployeeAttendanceController(EmployeeAttendanceService employeeAttendanceService) {
		super();
		this.employeeAttendanceService = employeeAttendanceService;
	}

	@GetMapping("/employeeattendances")
	public List<EmployeeAttendance> getAllAttendance() {
		return employeeAttendanceService.getAllAttendance();
	}

	@GetMapping("/employeeattendances/{id}")
	public ResponseEntity<EmployeeAttendance> getLeaveById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<EmployeeAttendance>(employeeAttendanceService.getAttendanceById(employeeId),
				HttpStatus.OK);
	}

}