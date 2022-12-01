package com.ankur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankur.model.Employee;
import com.ankur.repository.EmployeeRepo;


@Service
public class EmpService {
	
	@Autowired
	private EmployeeRepo er;
	
	public void addEmp(Employee emp) {
		
		er.save(emp);
	}

	
	public List<Employee> getEmployee(){
		return er.findAll();
		
	}
	
	public Employee editEmpbyId(int id) {
		
		Optional<Employee> emp = er.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
		
	}
	
	public void deleteEmpById(int id) {
		
		er.deleteById(id);
	}
}
