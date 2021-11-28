package com.company.springboot.springbootcrm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot.springbootcrm.entity.Employee;
import com.company.springboot.springbootcrm.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee findById(@PathVariable("employeeId") int theId) {
		
		Employee theEmployee = employeeService.findById(theId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee not found - " + theId);
		}
		
		return theEmployee;
	}
	
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee theEmployee) {
    	
    	theEmployee.setId(0);
    	
    	employeeService.save(theEmployee);
    	
    	return theEmployee;
    }
    
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
    	
    	employeeService.save(theEmployee);
    	
    	return theEmployee;
    }
    
    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int theId) {
    	
    	Employee theEmployee = employeeService.findById(theId);
    	
    	if (theEmployee == null) {
    		throw new RuntimeException("Employee not found - " + theId);
    	}
    	
    	employeeService.deleteById(theId);
    	
    	return "Deleted employee id - " + theId;
    }
}
