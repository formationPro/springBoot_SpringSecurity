package fr.formation.inti.services;

import fr.formation.inti.entities.Department;

public interface DepartmentService{
	
	public Department savOrUpdate(Department department);
	public void delete(Integer id);
	public Iterable<Department> findAll();
	public Department findByID(Integer id);
}
