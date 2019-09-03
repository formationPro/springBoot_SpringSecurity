package fr.formation.inti.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.EmployeeRepository;
import fr.formation.inti.entities.Employee;
import fr.formation.inti.services.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository  employeeRepository;
	
	@Override
	public Employee savOrUpdate(Employee c) {
		return employeeRepository.save(c);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findByID(Integer id) {
		return employeeRepository.findById(id).get();
	}

}
