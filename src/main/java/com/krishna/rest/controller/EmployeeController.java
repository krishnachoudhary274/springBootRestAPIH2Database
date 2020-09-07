package com.krishna.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.rest.dao.EmployeeRepository;
import com.krishna.rest.model.Employee;
import java.util.List;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getAll")
	public List<Employee> getAll(){
		
		return employeeRepository.findAll();
	}
	
	 @PostMapping("/addEmployees")
	    public List<Employee> addProducts(@RequestBody List<Employee> products) {
	        return employeeRepository.saveAll(products);
	    }
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		
		 employeeRepository.save(employee);
		 return "Employee Saved...";
		
	}
	@GetMapping("/getEmployeeName/{name}")
	public List<Employee> getEmployee(@PathVariable String name)
	{
		return employeeRepository.findAllByName(name);
	}
	
	@DeleteMapping("/delete/{id}")
	 public String deleteProduct(@PathVariable int id) {
		employeeRepository.deleteById(id);
	        return "Employee removed !! " ;
	    }
	
		@PutMapping("/update")
	   public String updateProduct(@RequestBody Employee employee) {
			Employee existingProduct = employeeRepository.findById(employee.getId()).orElse(null);
	        existingProduct.setName(employee.getName());
	        existingProduct.setDept(employee.getDept());
	        existingProduct.setSalary(employee.getSalary());
	        employeeRepository.save(existingProduct);
	         return "employee deleted...";
	    }
		@GetMapping("/getEmployeeId/{id}")
		public Employee getProductById(@PathVariable int id) {
	        return employeeRepository.findById(id).orElse(null);
	    }

}
