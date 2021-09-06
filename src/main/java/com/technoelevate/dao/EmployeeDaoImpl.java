package com.technoelevate.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import javax.naming.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.technoelevate.dto.Employee;  
@Component
public class EmployeeDaoImpl implements EmployeeDao{ 
	/* @Autowired */

  ApplicationContext context = new ClassPathXmlApplicationContext("com/technoelevate/controller/config.xml");
  JdbcTemplate jdbcTemplate=context.getBean("jdbcTemplate",JdbcTemplate.class);
public void setTemplate(JdbcTemplate template) {  
    this.jdbcTemplate = template;  
}  
@Override
public int save(Employee employee){  
    String sql="insert into emp_info(id, password, name, designation, salary) values(?,?,?,?,?)";  
    return jdbcTemplate.update(sql,employee.getId(),employee.getPassword(),employee.getName(),employee.getDesignation(),employee.getSalary());  
}  
@Override
public int update(Employee e){  
    String sql="update emp_info set name='"+e.getName()+"', password="+e.getPassword()+", designation='"+e.getDesignation()+", salary="+e.getSalary()+"' where id="+e.getId()+"";  
    return jdbcTemplate.update(sql);  
}  
@Override
public int delete(int id){  
    String sql="delete from emp_info where id="+id+"";  
    return jdbcTemplate.update(sql);  
}  
@Override
public Employee getEmpById(int id){  
    String sql="select * from emp_info where id=?";  
    return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));  
}  
@Override
public List<Employee> getEmployees(){  
    return jdbcTemplate.query("select * from emp_info",new RowMapper<Employee>(){  
        public Employee mapRow(ResultSet rs, int row) throws SQLException {  
            Employee e=new Employee();  
            e.setId(rs.getInt(1)); 
            e.setPassword(rs.getString(2));
            e.setName(rs.getString(3)); 
            e.setDesignation(rs.getString(4));  
            e.setSalary(rs.getDouble(5));  
            return e;  
        }  
    });  
}  
}  