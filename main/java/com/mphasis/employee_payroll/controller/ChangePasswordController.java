package com.mphasis.employee_payroll.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.employee_payroll.model.ChangePassword;
import com.mphasis.employee_payroll.service.ChangePasswordService;

@RestController
@RequestMapping("/api/v1")
public class ChangePasswordController {

	private ChangePasswordService changePasswordService;

	public ChangePasswordController(ChangePasswordService changePasswordService) {
		super();
		this.changePasswordService = changePasswordService;
	}

	@PutMapping("/changepasswords/{id}")
	public ResponseEntity<ChangePassword> changePassword(@PathVariable("id") long id,
			@RequestBody ChangePassword changePassword) {
		return new ResponseEntity<ChangePassword>(changePasswordService.changePassword(changePassword, id),
				HttpStatus.OK);
	}
}