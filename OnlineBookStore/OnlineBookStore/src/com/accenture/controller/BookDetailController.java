package com.accenture.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.domain.Address;
import com.accenture.domain.Book;
import com.accenture.domain.User;
import com.accenture.service.BookstoreService;

@Controller
public class BookDetailController {

	@Autowired
	private BookstoreService bookstoreService;

	

	/**
	 * Method used to prepare our model and select the view to show the details
	 * of the selected book.
	 * 
	 * @param bookId
	 *            the id of the book
	 * @param model
	 *            the implicit model
	 * @return view name to render (book/detail)
	 */
	@RequestMapping(value = "/book/detail/{bookId}")
	public String details(@PathVariable("bookId") long bookId, Model model) {
		Book book = this.bookstoreService.findBook(bookId);
		model.addAttribute(book);
		return "book/detail";
	}

	@RequestMapping(value = "/book/add")
	public ModelAndView insertbookdetails() {

		Book book = new Book();
		ModelAndView mv = new ModelAndView("book/insertbookdetails");
		mv.addObject(book);

		return mv;
	}

	@RequestMapping(value = "/book/create" ,method = { RequestMethod.POST, RequestMethod.PUT })
	public String addbook(@Valid @ModelAttribute Book book, BindingResult result) {

		

		if (result.hasErrors()) {
			return "/book/insertbookdetails";
		}

		return "redirect:/book/detail/";
	}
}
