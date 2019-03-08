package com.jamsubzero.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jamsubzero.security.Entity.Employee;
import com.jamsubzero.security.dao.EmployeeDAO;

@RestController
//@RequestMapping("/employees")
public class EmployeeController{
	
    @Autowired
    private EmployeeDAO employeeDao;
    
    
    @RequestMapping("/employees")
    public List<Employee> getEmployees() {
    	
       return employeeDao.getAllEmployees();
    
    }
    
    
}



