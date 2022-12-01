package com.ankur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ankur.model.Employee;
import com.ankur.service.EmpService;



@Controller
public class EmpController {
	
	
	@Autowired
	private EmpService es;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> em = es.getEmployee();
		
		m.addAttribute("em", em);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmppage() {
		return "addemp";
	}
	
	
	@PostMapping("/register")
	public String addEmp(@ModelAttribute Employee e) {
		
		System.out.println(e);
		
		es.addEmp(e);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editEmploye(@PathVariable int id, Model m) {
		
		Employee e = es.editEmpbyId(id);
		m.addAttribute("emp", e);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e) {
		
		es.addEmp(e);
		
		return "redirect:/";
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String removeEmp(@PathVariable int id) {
		
		es.deleteEmpById(id);
		return "redirect:/";
	}
}
