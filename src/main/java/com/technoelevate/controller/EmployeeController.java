 package com.technoelevate.controller;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.technoelevate.dao.EmployeeDaoImpl;
import com.technoelevate.dto.Employee;
import com.technoelevate.service.EmployeeService;
import com.technoelevate.service.EmployeeServiceImpl;  
@Controller  
@ComponentScan(basePackages = {"com.technoelevate.service.EmployeeServiceImpl","com.technoelevate.dao.EmployeeDaoImpl"})
public class EmployeeController {  
    
    EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
    @RequestMapping("/empform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Employee());
    	return "empform"; 
    }  
   
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Employee emp){  
        employeeServiceImpl.save(emp);  
        return "redirect:/viewemp";
    }  
   
    @RequestMapping("/viewemp")  
    public String viewemp(Model m){  
        List<Employee> list=employeeServiceImpl.getEmployees();  
        m.addAttribute("list",list);
        return "viewemp";  
    }  
   
    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Employee emp=employeeServiceImpl.getEmpById(id);  
        m.addAttribute("command",emp);
        return "EmployeeeditForm";  
    }  
   
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Employee emp){  
        employeeServiceImpl.update(emp);  
        return "redirect:/viewemp";  
    }  
   
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        employeeServiceImpl.delete(id);  
        return "redirect:/viewemp";  
    }   
}  