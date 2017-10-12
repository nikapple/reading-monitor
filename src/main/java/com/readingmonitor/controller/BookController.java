package com.readingmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.readingmonitor.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping()
	public String displayBooks(Model model){
		model.addAttribute("bookList",bookService.getAllBooks());
		model.addAttribute("topicList",bookService.getAllTopics());
		return "all-book-list-topicwise";
	}
}
