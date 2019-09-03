package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	
	@GetMapping(path="/login")
	public String index() {
		return "login/loginPage";
	}
}
