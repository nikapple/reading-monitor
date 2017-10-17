package com.readingmonitor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Topic;

@Repository
public class BookDaoImpl extends DaoImpl implements BookDao {

	@Override
	public List<Book> getBooksByTopic(String topicName) {

		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Book> bookList = session.createCriteria(Book.class)
				.createAlias("topic", "t")
				.add(Restrictions.eq("t.name",topicName))
				.list();
		
		session.getTransaction();
		session.close();
		
		return bookList;
	}

	@Override
	public List<Topic> getAllTopics() {
		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Topic> topicList = session.createCriteria(Topic.class).list();
		
		session.getTransaction();
		session.close();
		
		return topicList;
	}

	@Override
	public List<Topic> getAllBooksByTopic() {
		List<Topic> topicList = getAllTopics();
		for(Topic topic : topicList)
		{
			topic.setBookList(getBooksByTopic(topic.getName()));
		}
		return topicList;
	}

}
