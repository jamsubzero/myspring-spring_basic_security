package com.jamsubzero.security.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jamsubzero.security.Entity.Employee;

//TODO convert to repository
@Component
public class EmployeeDAO {
	
	   private static List<Employee> employees = new ArrayList<>();
	    
	    static 
	    {
	    	employees.add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
	    	employees.add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
	    	employees.add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
	    }
	    
	    public List<Employee> getAllEmployees() 
	    {
	        return employees;
	    }

}
