package com.library.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.library.model.domain.RegisterBean;
import com.library.model.services.registrationservice.RegistrationServiceImpl;

@Controller
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@RequestMapping(value="/registerCustomer", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("register", new RegisterBean());
		return "registration";
	}
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("register") @Valid RegisterBean registerBean, BindingResult result) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
    	RegistrationServiceImpl rg = new RegistrationServiceImpl();
		
    	boolean answer = rg.registerCustomer(registerBean.getUsername(), registerBean.getPassword());
    	
    	if(answer) {
    		return "welcome";
    	}
    	else {
    	return "welcome";
    	} 
    }


}
