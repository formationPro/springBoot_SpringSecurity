package fr.formation.inti.services;

import java.util.List;

import fr.formation.inti.entities.Employee;

public interface EmployeeService {

	public Employee savOrUpdate(Employee c);
	public void deleteEmployee(Integer id);
	public List<Employee> findAllEmployees();
	public Employee findByID(Integer id);
}
