package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.inti.entities.Department;
import fr.formation.inti.services.DepartmentService;

@RestController
@RequestMapping("departement")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService ;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String findAll(Model model)
	{
		model.addAttribute("list", departmentService.findAll());
		return "departments";
	}
	
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody Department v)
	{
		if (v != null) {
			departmentService.savOrUpdate(v);
			return "{\"status\":\"success\"}";
		} else 
			return "{\"status\":\"error\"}";
	}
	
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable Integer id) {
		if (id != null) {
			departmentService.delete(id);	
			return "{\"status\":\"success\"}";
		} else 
			return "{\"status\":\"error\"}";
	}
	

}
