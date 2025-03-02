package com.example.to_do_project.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.to_do_project.service.AuthenticationService;







@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	@RequestMapping(value ="/login",method = RequestMethod.GET)
	public String gotoLoginPage() {
		
    return "login";	     
	     
    }	
	@RequestMapping(value ="/login",method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model ) {
		
		if(authenticationService.authenticate(name,  password)) {
			
		
		model.put("name", name);
		
	
		return "welcome";
	     
	}
		model.put("errormessage", "invalidCrdentials");
		return "login";
		}
}
