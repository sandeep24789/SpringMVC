package com.accenture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value="/index")
	public ModelAndView indexPage()
	{
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("welcomemsg", "Welcome to online book store");
		
		return mv;
	}
}
