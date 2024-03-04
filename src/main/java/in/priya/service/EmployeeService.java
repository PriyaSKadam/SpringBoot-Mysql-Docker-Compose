package in.priya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.priya.model.Employee;
import in.priya.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository empRepo;

	public EmployeeService(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}
	
	
	/*public List<Employee> getAllEmployee()
	{
		return empRepo.findAll();
		
	}*/

	/*//Hard Delete
	public void deleteEmployee(Integer id)
	{
		empRepo.deleteById(id);;
	}*/
	//Soft Delete
	public boolean saveEmployees(Employee employee)
	{
		employee.setActiveStatus("Y");
		empRepo.save(employee);
		
		return true;
	}
	//Hard Delete
	
	/*public boolean saveEmployees(Employee employee)
	{
		empRepo.save(employee);
		
		return true;
	}*/

	public Employee updateEmp(Integer id)
	{
		Employee emp=empRepo.getById(id);
		return emp;
	}
	
	
	//Soft Delete
	
	public void deleteUpdateEmp(Integer id)
	{

	       Optional<Employee> employee=empRepo.findById(id);
	       if(employee.isPresent())
	       {
	    	   Employee emp=employee.get();
	    	   emp.setActiveStatus("N");
	    	   
	    	   empRepo.save(emp);
	    			   
	       }
	   
	}

   public List<Employee> findByStatus()
   {
	     return empRepo.findByActiveStatus("Y");
   }
	 
	 
}
