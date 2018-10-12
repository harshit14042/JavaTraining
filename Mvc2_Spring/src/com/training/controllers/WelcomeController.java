package com.training.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.entity.Book;

@Controller
public class WelcomeController {
	
	@Autowired
	Book book;
	
	@Autowired
	ModelAndView mdlView; 
	@RequestMapping("/")
	public ModelAndView init() {
		mdlView.addObject("heading", "Spring MVC");
		mdlView.setViewName("index");
		return mdlView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details() {
		mdlView.setViewName("details");
		return mdlView;
	}
	
	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public ModelAndView initAddBook() {
		mdlView.addObject("command",book);
		mdlView.setViewName("AddBook");
		
		return mdlView;
	}
	
	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("command")Book b, BindingResult result)
	{
		System.out.println("Submit");
		
		if(result.hasErrors()) {
			System.out.println("Error Occured");
			return "AddBook";
		}
		else {
			System.out.println("Error not Occured");
			//model.addAttribute("bookAdded",b);
			return "Success";
		}
		
	}
	
	@ModelAttribute("catList")
	public String[] getCategories() {
		return new String[] {"Fiction","Scientific","Novel"};
	}
}
