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
import com.library.model.domain.LoginBean;
import com.library.model.services.loginservice.LoginServiceImpl;

@Controller
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("command", new LoginBean());
		return "login";
	}
	
	@RequestMapping(value = "/loginCustomer", method = RequestMethod.POST)
	public String loginCustomer(@ModelAttribute("command") @Valid LoginBean loginBean, BindingResult result) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		
		LoginServiceImpl lg = new LoginServiceImpl();
		if(result.hasErrors()) {
			return "login";
		}
		else {
			boolean LoginSuccess = false;
			LoginSuccess = lg.loginUser(loginBean);

			if(!LoginSuccess) {
				return "login";
			}
			else {
				return "welcome";
			}
		}
	}
}
