package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.entity.Monument;

@Controller
public class FirstController {

	@Autowired
	Monument monument;
	
	@Autowired
	ModelAndView mdlView;
	
	@RequestMapping("/")
	public ModelAndView init() {
		mdlView.setViewName("index");
		return mdlView;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add() {
		mdlView.addObject("command",monument);
		mdlView.setViewName("AddMonument");
		return mdlView;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String added(@ModelAttribute("command")Monument mon,BindingResult result) {
		if(result.hasErrors()) {
			return "AddMonument";
		}
		else {
			return "success";
		}
	}
	
	@ModelAttribute("continentList")
	public String[] continentList() {
		return new String[] {"Asia","Africa","Europe","Australia","North America","South America","Antarctica"};
	}
}
