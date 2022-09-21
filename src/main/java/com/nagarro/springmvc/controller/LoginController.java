/**
 * 
 */
package com.nagarro.springmvc.controller;

import java.util.Arrays;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.nagarro.springmvc.entity.BookData;
import com.nagarro.springmvc.entity.UserModel;
import com.nagarro.springmvc.services.LoginService;

/**
 * This class is use for user controller
 * 
 * @author ravikumar05
 *
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private RestTemplate restTemplate;

	ModelAndView mv = new ModelAndView();

	@GetMapping("/")
	public ModelAndView user() {
		ModelAndView modelandview = new ModelAndView("login");
		modelandview.addObject("user", new UserModel());
		return modelandview;
	}

	@PostMapping("/login")
	public ModelAndView loginUser(@ModelAttribute UserModel usermodel) {
		UserModel oauthUser = loginService.login(usermodel.getUserid(), usermodel.getPassword());
		if (Objects.nonNull(oauthUser)) {
			// External apis call
			BookData[] bookdata = restTemplate.getForObject("http://localhost:4000/books", BookData[].class);
			Iterable<BookData> book = Arrays.asList(bookdata);
			mv.addObject("bookdata", book);
			mv.setViewName("home");
			return mv;

		} else {
			mv.setViewName("/");
			return mv;
		}
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/";
	}

	@PostMapping("/addbook")
	public ModelAndView addBook() {
		mv.setViewName("addbook");
		return mv;
	}

	@PostMapping("/bookadded")
	public ModelAndView bookAdded(@ModelAttribute BookData book) {
		BookData savebook = restTemplate.postForObject("http://localhost:4000/books", book, BookData.class);
		BookData[] bookdata = restTemplate.getForObject("http://localhost:4000/books", BookData[].class);
		Iterable<BookData> booklist = Arrays.asList(bookdata);
		mv.addObject("bookdata", booklist);
		mv.setViewName("home");
		return mv;
	}

	@GetMapping("/edit/{bookcode}")
	public ModelAndView editBookDetails(@PathVariable("bookcode") int bookcode) {
		// First get data from database
		BookData book = restTemplate.getForObject("http://localhost:4000/books/" + bookcode, BookData.class);
		mv.addObject("data", book);
		mv.setViewName("editbook");
		return mv;
	}

	@PostMapping("/edit/bookupdated")
	public ModelAndView bookupdate(@ModelAttribute BookData book) {
		BookData savedata = restTemplate.postForObject("http://localhost:4000/books", book, BookData.class);
		BookData[] bookdata = restTemplate.getForObject("http://localhost:4000/books", BookData[].class);
		Iterable<BookData> booklist = Arrays.asList(bookdata);
		mv.addObject("bookdata", booklist);
		mv.setViewName("home");
		return mv;
	}

	
	@PostMapping("/delete/{bookcode}")
	public ModelAndView deleteBook(@RequestParam("bookcode") int bookcode) {
		BookData deletedata = restTemplate.getForObject("http://localhost:4000/books/" + bookcode,
				BookData.class);
		mv.setViewName("home");
		return mv;
	}

}
