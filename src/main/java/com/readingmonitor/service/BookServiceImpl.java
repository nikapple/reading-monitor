package com.readingmonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readingmonitor.dao.BookDao;
import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Topic;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<Topic> getAllTopics() {
		return bookDao.getAllTopics();
	}

	@Override
	public List<Topic> getAllBooksByTopic() {
		return bookDao.getAllBooksByTopic();
	}

}
