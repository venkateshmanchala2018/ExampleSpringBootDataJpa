package com.jpa.test.EmployeeoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jpa.test.model.Employee;
import com.jpa.test.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",service.getAllEmployees());
		return "index";
		
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		service.saveEmployee(employee);
		return "redirect:/";		
	}
	
	@GetMapping("/showFormForUpdate/{id}")	
	public String ShowFormForUpdate(@PathVariable(value="id") long id,Model model) {
		Employee employee=service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return"update_emplyee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	
	public String deleteEmplyee(@PathVariable(value="id")long id) {
		this.service.deleteEmployeeById(id);
		return "redirect:/";
		
	}
	
	

}
