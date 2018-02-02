package com.accenture.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.domain.Address;
import com.accenture.domain.User;
import com.accenture.service.AccountService;
import com.accenture.validation.UsrerValidation;


@Controller
@RequestMapping("/customer/register")
public class RegisterController {

	@Autowired
	private AccountService accountService;
	
	@ModelAttribute("countries")
	public Map<String, String> CounList(Locale currentLocale) {
		
		Map<String, String> countries = new TreeMap<String, String>();
		Locale[] loc = currentLocale.getAvailableLocales();
		for(Locale locale: loc) {
			countries.put(locale.getCountry(),locale.getDisplayCountry());
		}
		return countries;
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView register(Locale currentLocale) {

		ModelAndView mv = new ModelAndView();

		User account = new User();
		Address add = new Address();
		account.setAddress(add);

		mv.addObject(account);

		mv.setViewName("/customer/register");
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String handleReg(@Valid @ModelAttribute User user, BindingResult result) {
		if(result.hasErrors()) {
			return "/customer/register";
		}
		return "/customer/success";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		CustomDateEditor editor = new CustomDateEditor(formatter, true);
		binder.registerCustomEditor(Date.class, "dateOfBirth",editor);
		binder.setValidator(new UsrerValidation());
	}

}
