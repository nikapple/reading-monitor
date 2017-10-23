package com.readingmonitor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Payment;
import com.readingmonitor.dto.Topic;
import com.readingmonitor.dto.User;

@Repository
public class BookDaoImpl extends DaoImpl implements BookDao {

	@Override
	public List<Book> getBooksByTopic(String topicName) {

		Session session = getEntityManager().unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		List<Book> bookList = session.createCriteria(Book.class)
				.createAlias("topic", "t")
				.add(Restrictions.eq("t.name",topicName))
				.list();
		
		return bookList;
	}

	@Override
	public List<Topic> getAllTopics() {
		
		Session session = getEntityManager().unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		List<Topic> topicList = session.createCriteria(Topic.class).list();
		
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

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public Book borrowBook(User user,Book book, double paymentAmount) {
		removeBook(book);
		makePayment();
	
		return book;
	}

	private void removeBook(Book book) {
		System.out.println("Removing Book From Shelf");
		Session session = getEntityManager().unwrap(Session.class);
		book = (Book )session.get(Book.class,book.getId());
		book.setBorrowed(true);
		session.update(book);
		/*Map<String,Object> paramMap = new HashMap<>();   
		paramMap.put("bookId", book.getId());   
		getJdbcTemplate().update("UPDATE book SET borrowed = 1 WHERE id = :bookId", paramMap);*/
	}

	private void makePayment() {
		System.out.println("Making Payment for borrowing book");
		Session session = getEntityManager().unwrap(Session.class);
		Payment payment  = new Payment();
		session.save(payment);
	}

	
}
