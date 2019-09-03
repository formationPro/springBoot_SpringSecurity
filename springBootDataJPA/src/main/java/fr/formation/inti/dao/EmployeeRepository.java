package fr.formation.inti.dao;
 
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entities.Employee;
 

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { 
	
    Employee findByLastName(String lastName);
 
    List<Employee> findByLastNameLike(String fullName);
 
    List<Employee> findByStartDateGreaterThan(Date startDate);
 
    @Query("SELECT coalesce(max(e.id), 0) FROM Employee e")
    Long getMaxId();
 
}