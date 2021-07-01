package com.employeeCRUD.service;

import java.util.List;

import com.employeeCRUD.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Integer id);

	public void deleteEmployee(Integer id);

}
