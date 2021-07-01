package com.employeeCRUD.repos;

import org.springframework.stereotype.*;

import com.employeeCRUD.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeCRUDRepo extends JpaRepository<Employee, Integer> {

}
