package com.readingmonitor.service;

import java.util.List;

import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Topic;
import com.readingmonitor.dto.User;

public interface BookService {
	List<Topic> getAllTopics();
	List<Topic> getAllBooksByTopic();
	//to test transactions
	Book borrowBook(User user,Book book, double paymentAmount);
}
