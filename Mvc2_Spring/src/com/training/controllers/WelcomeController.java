package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.scenario.effect.Blend.Mode;
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
	public String submit(@ModelAttribute("command")Book b, Model model) {
		model.addAttribute("bookAdded",b);
		return "Success";
	}
	
	@ModelAttribute("catList")
	public String[] getCategories() {
		return new String[] {"Fiction","Scientific","Novel"};
	}
}
