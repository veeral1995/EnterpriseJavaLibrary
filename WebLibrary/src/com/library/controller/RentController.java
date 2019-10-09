package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.model.domain.RentalBean;
import com.library.model.services.loginservice.LoginServiceImpl;
import com.library.model.services.rentalservice.RentalServiceImpl;


@Controller
public class RentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value="/rent", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("command", new RentalBean());
		return "rent";
	}
	
	@RequestMapping(value = "/rentItem", method = RequestMethod.GET)
	protected ModelAndView rentItem(@ModelAttribute("command") RentalBean rentalBean, BindingResult result) throws ServletException, IOException {
		 String rentString = rentalBean.getCatalogNumber();
		 String SQLTable = rentalBean.getMediaType();
		 LoginServiceImpl lService = new LoginServiceImpl();
		 
		boolean rentOutput = false;
		 RentalServiceImpl rentalService = new RentalServiceImpl();
		 
		 ModelAndView map = new ModelAndView("rent");
		 
		 try {
			rentOutput = rentalService.rentItem(rentString, SQLTable, lService.getEmail());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		map.addObject("rentOutput", rentOutput);
		System.out.println("--");
		return map;
	}
}
