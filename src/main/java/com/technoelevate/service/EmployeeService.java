package com.technoelevate.service;

import java.util.List;

import com.technoelevate.dto.Employee;

public interface EmployeeService{
	public int save(Employee employee);
	public int update(Employee e);
	public int delete(int id);
	public Employee getEmpById(int id);
	public List<Employee> getEmployees();
}
