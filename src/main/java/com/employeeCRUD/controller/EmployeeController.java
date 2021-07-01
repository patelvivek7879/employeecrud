package com.employeeCRUD.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.employeeCRUD.custom.exception.BusinessException;
import com.employeeCRUD.custom.exception.ControllerException;
import com.employeeCRUD.entity.Employee;
import com.employeeCRUD.service.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		try
		{
		Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.CREATED);
	}catch(BusinessException e)
		{
		ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMsg());
		return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
		ControllerException ce = new ControllerException("611","Something went wrong from controller");
		return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);	
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees = employeeServiceInterface.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	} 
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
	{
		Employee employee = employeeServiceInterface.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id)
	{
		employeeServiceInterface.deleteEmployee(id);
		return new ResponseEntity<Void> (HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee updatedEmployee = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);
	}
}	
