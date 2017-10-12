package com.readingmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.readingmonitor.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/allBooks", method=RequestMethod.GET)
	public String displayAllBooksByTopic(Model model){
		model.addAttribute("topicList",bookService.getAllBooksByTopic());
		return "all-book-list-topicwise";
	}
}
