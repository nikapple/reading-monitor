package com.readingmonitor.service;

import java.util.List;

import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Topic;

public interface BookService {
	List<Topic> getAllTopics();
	List<Book> getAllBooks();
	List<Topic> getAllBooksByTopic();
}
