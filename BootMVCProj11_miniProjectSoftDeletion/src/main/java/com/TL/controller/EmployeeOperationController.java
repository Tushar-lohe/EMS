package com.TL.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TL.model.Employee;
import com.TL.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationController {

	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public String showHomepage() {
		return "welcome";
	}
	
	@GetMapping("/home")
	public String showHome() {
		//return lvn
		return "home";
	}

	@GetMapping("report")
	public String showEmployeeReport(Map<String,Object>map) {
		System.out.println("EmployeeOperationController.showEmployeeReport()");
		//use service
		Iterable<Employee> itEmps=empService.getAllEmployee();
		//keep in shared memory
		map.put("empsList", itEmps);
		//return lvn
		return "show_employee_report";
	}
	
	@GetMapping("/emp_add")
	public String showFormForregisterEmployee(@ModelAttribute("emp")Employee emp) {
		//return lvn
		return "register_employee";
		
	}
	
	
	/*@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,Map<String,Object>map) {
		
		//use Service
		String msg=empService.registerEmployee(emp);
		 Iterable<Employee> itEmps=empService.getAllEmployee();
		//Keep result in model attribute
		map.put("resultMsg", msg);
		 map.put("empsList", itEmps);
		//return lvn
		return "show_employee_report";
	} */
	

	//USING PRG PATTERN
	/*@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,Map<String,Object>map) {
		System.out.println("EmployeeOperationController.saveEmployee()");
		//use Service
		String msg=empService.registerEmployee(emp);
		 
		//Keep result in model attribute
		map.put("resultMsg", msg);
		
		//return lvn
		return "redirect:report";
	} */
	
	 
	
	//USING FLASHATTRIBUTE   (BEST)
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,RedirectAttributes attrs) {
		System.out.println("EmployeeOperationController.saveEmployee()");
		//use Service
		String msg=empService.registerEmployee(emp);
		 
		//Keep result in flash attribute
	    attrs.addFlashAttribute("resultMsg", msg);
		
		//return lvn
		return "redirect:report";
	
    }  
	
	//USING FLASHATTRIBUTE SHOW MSG OF ADDING WHEN REFRESHED 
	/*	@PostMapping("/emp_add")
		public String saveEmployee(@ModelAttribute("emp")Employee emp,HttpSession ses) {
			System.out.println("EmployeeOperationController.saveEmployee()");
			//use Service
			String msg=empService.registerEmployee(emp);
			 
			//Keep result in flash attribute
		    ses.setAttribute("resultMsg", msg);
			
			//return lvn
			return "redirect:report";
		
	    }   */
	
	
	//edit Operation
	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@RequestParam("no")int no,@ModelAttribute("emp")Employee emp) {
		
		//use service
		Employee emp1=empService.getEmployeeByNo(no);
		//copy data
		BeanUtils.copyProperties(emp1, emp);
		//return lvn
		return "update_employee";
	}
	
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp) {
		//use service
		String msg=empService.updateEmployee(emp);
		//add  the result msg as flash attributes
		attrs.addFlashAttribute("resultMsg",msg);
		//redirect the request
		return "redirect:report";
	}
	
	@GetMapping("/emp_delete")
	public String deleteEmployeeById(RedirectAttributes attrs,@RequestParam int no) {
		//use service 
		String msg=empService.deleteEmployeeById(no);
		//keep result in flash attributes
		attrs.addFlashAttribute("resultMsg", msg);
	//redirect the request
		return "redirect:report";
	}
	
}