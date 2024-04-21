package com.greatlearning.rbawiththymeleaf.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.rbawiththymeleaf.entity.Employee;
import com.greatlearning.rbawiththymeleaf.service.EmployeeServiceImpl;



// BE --> FE Model
// FE --> BE @ModelAttribute
@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeservice;
	
	
	
	@RequestMapping("/employees")
	public String listemployees(Model model)
	{
		
		List<Employee> emplist=employeeservice.getAllEmployees();
		model.addAttribute("employees",emplist);
		
		return "employees";
		
	}
	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model)
	{
		
		Employee e1=new Employee();
		model.addAttribute("employee",e1);
		return "create_employee";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable int id,Model model)
	{
		Employee empdb=employeeservice.getEmployeeById(id);
		model.addAttribute("employee",empdb);
		return "edit_employee";
	}
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		employeeservice.deleteEmployeeById(id);
		return "redirect:/employees";
	}
	
	@PostMapping("/employees/save")
	public String saveEmployee(@ModelAttribute("employee") Employee e1)
	{
		employeeservice.saveEmployee(e1);
		return "redirect:/employees";
	}
	
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable int id,@ModelAttribute("employee") Employee newvalues)
	{
		Employee empdb=employeeservice.getEmployeeById(id);
		empdb.setFirstName(newvalues.getFirstName());
		empdb.setLastName(newvalues.getLastName());
		empdb.setEmail(newvalues.getEmail());
		employeeservice.updateEmployee(empdb);
		return "redirect:/employees";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			    "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
