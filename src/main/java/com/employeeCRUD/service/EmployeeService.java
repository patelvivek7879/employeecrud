package com.employeeCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.employeeCRUD.custom.exception.BusinessException;
import com.employeeCRUD.entity.Employee;
import com.employeeCRUD.repos.*;

@Service
public class EmployeeService implements EmployeeServiceInterface
{
	@Autowired
	private EmployeeCRUDRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
			if(employee.getName().isEmpty() || employee.getName().length() == 0)
			{
				throw new BusinessException("601","Name cannot be empty.");
			}
		try
		{
		Employee e = crudRepo.save(employee);
		return e;
		}catch(IllegalArgumentException e)
		{
			throw new BusinessException("602","Eployee is null" + e.getMessage());	
		}catch(Exception e)
		{
			throw new BusinessException("603","Something went wrong " + e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return crudRepo.findAll();
	}
	
	public Employee getEmployeeById(Integer id)
	{
		return crudRepo.findById(id).get();
	}

	@Override
	public void deleteEmployee(Integer id) {
		crudRepo.deleteById(id);
		
	}
	
}
