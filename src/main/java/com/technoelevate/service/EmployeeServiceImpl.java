package com.technoelevate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.technoelevate.dao.EmployeeDaoImpl;
import com.technoelevate.dto.Employee;


@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	  //@Autowired 
	  EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

		/*
		 * Employee employee; public boolean validateInsertion(Employee employee) { if
		 * (employee.getId()>0) { employeeDaoImpl.save(employee); } return false;
		 * 
		 * }
		 */
@Override
public int save(Employee employee) {
	       System.out.println(employee);
	       System.out.println(employeeDaoImpl);
			if (employee.getId()>0){
		return employeeDaoImpl.save(employee);
	}else {
		System.out.println("plz enter valid input data");
	return 0;
	}
}
@Override
public int update(Employee e) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int delete(int id) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public Employee getEmpById(int id) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<Employee> getEmployees() {
	// TODO Auto-generated method stub
	return null;
}

}
