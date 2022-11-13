package com.kgisl.sql2.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.sql2.Model.Employee;
import com.kgisl.sql2.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
	
    public List<Employee> getAll() {
     return employeeRepository.findAll();
    }
    
    public Optional<Employee> getById(Integer  id) {
     return employeeRepository.findById(id);
    }
    
    public Employee create(Employee e) {
    return  employeeRepository.save(e);
    }
    
    public Employee update(Employee e,int id) {
    return  employeeRepository.save(e);
    }
    
    public void delete(Integer id) {
     employeeRepository.deleteById(id);
    }
}
