package com.technoelevate.dao;

import java.util.List;

import com.technoelevate.dto.Employee;

public interface EmployeeDao {
	public int save(Employee employee);
	public int update(Employee e);
	public int delete(int id);
	public Employee getEmpById(int id);
	public List<Employee> getEmployees();
}
