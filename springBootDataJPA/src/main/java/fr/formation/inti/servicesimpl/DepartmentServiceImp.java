package fr.formation.inti.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.DepartmentRepository;
import fr.formation.inti.entities.Department;
import fr.formation.inti.services.DepartmentService;

@Service
public class DepartmentServiceImp implements DepartmentService {

	
	@Autowired
	@Qualifier("departmentRepository")
	DepartmentRepository departmentRep;
	
	
	@Override
	public Department savOrUpdate(Department department) {
		return departmentRep.save(department);
	}

	@Override
	public void delete(Integer id) {
		departmentRep.deleteById(id);
	}

	@Override
	public Iterable<Department> findAll() {
		return departmentRep.findAll();
	}

	@Override
	public Department findByID(Integer id) {
		return departmentRep.findById(id).get();
	}

}
