package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
 
	
}
