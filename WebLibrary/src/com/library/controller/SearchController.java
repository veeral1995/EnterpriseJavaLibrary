package com.library.controller;

import java.util.List;
import javax.servlet.http.HttpServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.library.model.domain.LibraryResultsDTO;
import com.library.model.domain.SearchBean;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;
import com.library.model.services.retreivalservice.RetreivalServiceImpl;

@Controller
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value= "/search" , method = RequestMethod.GET)
	public String search(Model model) {
		model.addAttribute("command", new SearchBean());
		return "search";
	}
	
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/searchLibrary", method = RequestMethod.GET)
	protected ModelAndView searchLibrary(@ModelAttribute("command") SearchBean searchBean, BindingResult result) throws Exception {
		 String searchString = searchBean.getSearchString();
		 List<LibraryResultsDTO> resData = null;
		 RetreivalServiceImpl rService = new RetreivalServiceImpl();
		 ModelAndView map = new ModelAndView("search");
		 
		 if (searchString != "")
		 {	 
			 try {
				 resData = rService.returnSearchResult(searchString);
			} catch (ClassNotFoundException | RetreivalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else {
			 try {
				 resData = rService.getAllItems();
			} catch (ClassNotFoundException | RetreivalException | AvailibilityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 map.addObject("resData", resData);
		 System.out.println("--");
		 return map;
	}
		

}

