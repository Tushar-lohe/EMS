package com.TL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TL.model.Employee;
import com.TL.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Iterable<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}

	
	@Override
	public String registerEmployee(Employee emp) {
		return "Employee is Saved With Id-Value::"+empRepo.save(emp).getEmpno();
	}

	

	@Override
	public Employee getEmployeeByNo(int eno) {
		Employee emp=empRepo.findById(eno).orElseThrow(()->new IllegalArgumentException());
		return emp;
	}


	@Override
	public String updateEmployee(Employee emp) {
		
		return "Employee is Updated With id value::"+empRepo.save(emp).getEmpno();
	}


	@Override
	public String deleteEmployeeById(int eno) {
		empRepo.deleteById(eno);
		return eno+" Id Employee is Deleted.";
	}
	
	
	

}
