package fr.formation.inti.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.services.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeControlleur {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        model.addAttribute("activePage", "employee");
        model.addAttribute("employees", this.employeeService.findAllEmployees());
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        
        Collection<? extends GrantedAuthority> authorities = loginedUser.getAuthorities();
        boolean isAdmin = false;
       for (GrantedAuthority grantedAuthority : authorities){
    	   if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
               isAdmin = true;
               break;
           }
       }
        model.addAttribute("isAdmin", isAdmin);
        return "employee/index";
    }
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addEmployeeForm(Employee employee, Model model) {
        model.addAttribute("activePage", "employee");
        return "employee/add";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@Valid Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "employee");
            return "employee/add";
        }
        
        this.employeeService.savOrUpdate(employee);
        return "redirect:/employee";
    }
	@RequestMapping(value = "/view/{id}")
    public String viewEmployee(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", this.employeeService.findByID(id));
        model.addAttribute("activePage", "employee");
        return "employee/view";
    }
	@GetMapping(path = "/edit/{id}")
    public String editEmployee(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", this.employeeService.findByID(id));
        model.addAttribute("activePage", "employee");
        return "employee/edit";
    }
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(Employee employee) {
        this.employeeService.savOrUpdate(employee);
        return "redirect:/employee/view/" + employee.getEmpId();
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable Integer id) {
        this.employeeService.deleteEmployee(id);;
        return "redirect:/employee";
    }
	
	

	
	
	
}
