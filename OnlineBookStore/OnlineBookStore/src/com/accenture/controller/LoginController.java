package com.accenture.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.accenture.domain.User;
import com.accenture.exception.AuthenticationException;
import com.accenture.service.AccountService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	public static final String ACCOUNT_ATTRIBUTE = "account";

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView login() {
     
		ModelAndView mv = new ModelAndView("login");

		return mv;
    }
	
	@Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    public String handleLogin(@RequestParam String username, @RequestParam String password,
            RedirectAttributes redirect, HttpSession session) throws AuthenticationException {
        try {
            User user = this.accountService.login(username, password);
            session.setAttribute(ACCOUNT_ATTRIBUTE, user);
            return "redirect:/index.htm";
        } catch (AuthenticationException ae) {
            redirect.addFlashAttribute("exception", ae);
            return "redirect:/login";
        }
    }
}
