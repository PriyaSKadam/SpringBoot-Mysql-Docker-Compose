package in.priya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.priya.model.Employee;
import in.priya.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/emp")
	public ModelAndView getAllEmp()
	{
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("emplist",empService.findByStatus());
		mav.setViewName("employee");
		
		return mav;
	}
	
	@GetMapping("/newEmployee")
	public ModelAndView newEmployee()
	{
		ModelAndView mav=new ModelAndView();
		
		
		mav.addObject("employee", new Employee());
		
		mav.setViewName("newEmployee");
		
		return mav;
	}
	
    @GetMapping("/update")
	
	public ModelAndView updateEmployee(@RequestParam("id") Integer id)
	{
		ModelAndView mav=new ModelAndView();
		
		  Employee emp=empService.updateEmp(id);
		  
		  mav.addObject("employee",emp);
		  
		mav.setViewName("newEmployee");
		
		return mav;
	}

	@PostMapping("/save")
	public ModelAndView saveData(Employee employee)
	{
		ModelAndView mav=new ModelAndView();
		   
		   boolean status=empService.saveEmployees(employee);
		  
		   
		   
		   if(status)
		   {
			   mav.addObject("sucsmsg","Employee saved Successfully");  
		   }
		   else
		   {
			   mav.addObject("failmsg","Record Fail to save...Please try again...");
		   }
		 
		mav.setViewName("newEmployee");
		
		return mav;
	}
	
	
	/*
	 //Hard Delete
	@GetMapping("/delete")
	
	public ModelAndView deleteEmployee(@RequestParam("id") Integer id)
	{
		ModelAndView mav=new ModelAndView();
		  
		empService.deleteEmployee(id);
		
		mav.addObject("emplist",empService.getAllEmployee());
		
		mav.setViewName("/employee");
		
		return mav;
	}*/
	
	//SoftDelete
	@GetMapping("/delete")
	public ModelAndView deleteEmployee(@RequestParam("id") Integer id)
	{
		ModelAndView mav=new ModelAndView();
		
		empService.deleteUpdateEmp(id);
			mav.addObject("emplist",empService.findByStatus());
			mav.setViewName("/employee");
		
		
		return mav;
	}
	
	
}
