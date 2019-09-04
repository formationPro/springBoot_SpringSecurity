package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.inti.entities.Employee;

//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
	List<Employee> findByFirstName(@Param("firstName") String name);
}