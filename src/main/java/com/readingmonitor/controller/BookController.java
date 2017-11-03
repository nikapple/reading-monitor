package com.readingmonitor.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Topic;
import com.readingmonitor.dto.User;
import com.readingmonitor.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@ResponseBody
	@RequestMapping(value="/allBooks", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> displayAllBooksByTopic(Model model){
		List<Topic> topicList = bookService.getAllBooksByTopic();
		System.out.println(topicList.size());
		return topicList;
	}
	
	@RequestMapping(value="/borrowBook",method=RequestMethod.GET)
	public String borrowBook(@RequestParam int bookId, Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		Book book = new Book();
		book.setId(bookId);
		bookService.borrowBook(user, book, 50.0);
		return "borrowed-book";
	}
}
