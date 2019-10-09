package com.library.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.library.model.domain.LibraryResultsDTO;
import com.library.model.services.exception.RetreivalException;
import com.library.model.services.fetchrenteditems.FetchRentedItemsImpl;
import com.library.model.services.loginservice.LoginServiceImpl;

@Controller
public class UserItemsRentedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@RequestMapping(value="/useritemsrented", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("command");
		return "useritemsrented";
	}
	
	@RequestMapping(value = "/getRentedStuff", method = RequestMethod.GET)
	protected ModelAndView getRentedStuff(@ModelAttribute("command") String useless,BindingResult result) throws ServletException, IOException, ClassNotFoundException {

		 System.out.println("User Is In UserItemsRentedController");		 
		 FetchRentedItemsImpl fService = new FetchRentedItemsImpl();
		 LoginServiceImpl lService = new LoginServiceImpl();
		 ModelAndView map = new ModelAndView("useritemsrented");
		 List<LibraryResultsDTO> resData = fService.getUserRentedItems(lService.getEmail());

		 map.addObject("resData", resData);
		 System.out.println("--" + resData.size());
		 return map;
	}


}
