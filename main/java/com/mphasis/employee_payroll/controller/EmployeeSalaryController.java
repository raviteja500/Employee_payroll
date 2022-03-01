package com.mphasis.employee_payroll.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.employee_payroll.model.EmployeeSalary;
import com.mphasis.employee_payroll.service.EmployeeSalaryService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeSalaryController {

	private EmployeeSalaryService employeeSalaryService;

	public EmployeeSalaryController(EmployeeSalaryService employeeSalaryService) {
		super();
		this.employeeSalaryService = employeeSalaryService;
	}

	@GetMapping("/employeesalaries")
	public List<EmployeeSalary> getAllSalary() {
		return employeeSalaryService.getAllSalary();
	}

	@GetMapping("/employeesalaries/{id}")
	public ResponseEntity<EmployeeSalary> getSalaryById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<EmployeeSalary>(employeeSalaryService.getSalaryById(employeeId), HttpStatus.OK);
	}

}