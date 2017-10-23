package com.readingmonitor.dao;

import java.util.List;

import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Topic;
import com.readingmonitor.dto.User;

public interface BookDao {
	List<Topic> getAllTopics();
	List<Topic> getAllBooksByTopic();
	List<Book> getBooksByTopic(String topicName);
	Book borrowBook(User user,Book book, double paymentAmount);
}
