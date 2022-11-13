package com.kgisl.sql2.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kgisl.sql2.Model.Employee;
import com.kgisl.sql2.repository.EmployeeRepository;
import com.kgisl.sql2.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
	 Gson gson = new Gson();
	
	 @GetMapping("/")
	    public ResponseEntity<String> getAllEmployee() {
	        List<Employee> l = employeeService.getAll();
	        String element=gson.toJson(l);
	        return  new ResponseEntity<>(element, HttpStatus.OK);
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<Object> getEmployeeById(@PathVariable Integer id) {
	        Object l = employeeService.getById(id);
	        return new ResponseEntity<>(l, HttpStatus.FOUND);
	    }
	   /* @PostMapping("/")
	    public ResponseEntity<String> createEmployee(@RequestBody Employee e) {
	    	Employee l = employeeService.create(e);
	    	String element=gson.toJson(l);
	    	return new ResponseEntity<>(element, HttpStatus.CREATED);
	    }*/
	    
	    @PostMapping("/")
	    public Employee createEmployee( @RequestBody Employee e) {
	        return employeeService.create(e);
//	        return  new ResponseEntity<>(l, HttpStatus.OK);
	    }

	    @PutMapping("/{id}")
	    public Employee updateEmployee(@RequestBody Employee e,@PathVariable int id) {
	    	 return employeeService.update(e,id);
	    }
	    
	   /* @PutMapping("/{id}")
	    public ResponseEntity<String> updateEmployee(@RequestBody Employee e,@PathVariable int id) {
	    	Employee l = employeeService.update(e, id);
	    	String element=gson.toJson(l);	    	
	    	return new ResponseEntity<>(element, HttpStatus.ACCEPTED);
	    }*/
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Object> deleteEmployee(@PathVariable Integer id) {
	       employeeService.delete(id);
	       return new ResponseEntity<>(HttpStatus.GONE);
	    }
}
