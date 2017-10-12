package com.readingmonitor.dao;

import java.util.List;

import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Topic;

public interface BookDao {
	List<Topic> getAllTopics();
	List<Book> getAllBooks();
	List<Topic> getAllBooksByTopic();
	List<Book> getBooksByTopic(String topicName);
}
