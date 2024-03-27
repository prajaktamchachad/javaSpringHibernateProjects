package com.luv2code.springboot.thymeLeafDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeLeafDemo.entity.Employee;
import com.luv2code.springboot.thymeLeafDemo.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theemployeeService)
	{
		employeeService = theemployeeService;
	}
	
	//To get the list of all employees 
	@GetMapping("/list")
	public String listEmployees(Model theModel)
	{
		//get the employee from database
		java.util.List<Employee> theEmployees = employeeService.findAll();
		
		theModel.addAttribute("employees", theEmployees);
		//add to the spring model
		return "employees/list-employees";
	}
	
	//To add a new employee
	@GetMapping("/showFormForAdd")
	public String showFormToAddEmployee(Model theModel)
	{
		//create the model attribute to bind the form
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	//Save the employee
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
	{
		//save the employee
		employeeService.save(theEmployee);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	//Prepopulate employee details to update
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("employeeId") int theEmpId, Model theModel)
	{
		//Find and Get Employee and get results from DB
		Employee theEmployee =  employeeService.findById(theEmpId);
		System.out.println(theEmployee);
		
		//Set the Employee in the Model to Prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		
		//send over to our form
		return "employees/employee-form";
	}
	
	//Delete the employee
	@GetMapping("/deleteTheEmployee")
	public String deleteTheEmployee(@RequestParam("employeeId") int theEmpId)
	{
		//delete the employee
		employeeService.deleteById(theEmpId);

		//redirect to employee/list
		return "redirect:/employees/list";
	}
	
	
	
}
