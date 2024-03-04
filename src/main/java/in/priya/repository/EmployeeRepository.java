package in.priya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.priya.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByActiveStatus(String status);

}
