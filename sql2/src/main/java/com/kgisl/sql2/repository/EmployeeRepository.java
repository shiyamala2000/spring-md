package com.kgisl.sql2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.sql2.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
