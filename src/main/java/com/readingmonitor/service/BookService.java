package com.readingmonitor.service;

import java.util.List;

import com.readingmonitor.dto.Topic;

public interface BookService {
	List<Topic> getAllTopics();
	List<Topic> getAllBooksByTopic();
}
