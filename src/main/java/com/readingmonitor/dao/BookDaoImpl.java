package com.readingmonitor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Topic;

@Repository
public class BookDaoImpl extends DaoImpl implements BookDao {

	@Override
	public List<Book> getAllBooks() {

		String sql = "SELECT "
				+ "b.id as book_id, b.book_name as book_name,"
				+ "b.author as author,t.id as topic_id,"
				+ "t.topic_name as topic_name "
				+ "FROM book b, topic t "
				+ "WHERE b.topic_id = t.id";
		List<Book> bookList = new ArrayList<Book>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,
				new HashMap<String, Object>());
		for(Map<String,Object> row: rows){
			Book book = new Book();
			book.setId((Integer)(row.get("book_id")));
			book.setName((String)(row.get("book_name")));
			book.setAuthor((String)(row.get("author")));
			book.setTopic(new Topic((Integer)(row.get("topic_id")),(String)(row.get("topic_name"))));
			bookList.add(book);
		}
		return bookList;
	}

	@Override
	public List<Topic> getAllTopics() {
		String sql = "SELECT "
				+ "topic_id,"
				+ "topic_name "
				+ "FROM topic ";
		List<Topic> topicList = new ArrayList<Topic>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,
				new HashMap<String, Object>());
		for(Map<String,Object> row: rows){
			topicList.add(new Topic((Integer)(row.get("topic_id")),(String)(row.get("topic_name"))));
		}
		return topicList;
	}

}
