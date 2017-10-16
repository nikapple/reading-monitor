package com.readingmonitor.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.readingmonitor.dto.Activity;
import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.Topic;
import com.readingmonitor.dto.User;

@Repository
public class MonitorActivityDaoImpl extends DaoImpl implements MonitorActivityDao{

	@Override
	public List<Activity> getActivities(User user, Date startDate, Date endDate) {
		String sql = "SELECT a.id as activityId, a.book_id as bookId , a.read_date as readDate, b.book_name as bookName, t.topic_name as topicName, t.id as topicId , b.author as author FROM book b, activity a, topic t WHERE read_date >= :startDate AND read_date <=:endDate AND user_id = :userId AND a.book_id = b.id  AND b.id = t.id";
		List<Activity> activityList = new ArrayList<Activity>();
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		paramMap.put("userId", user.getId());
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,
				paramMap);
		for(Map<String,Object> row: rows){
			Activity activity = new Activity();
			activity.setId((Integer)(row.get("activityId")));
			Book activityBook = new Book();
			activityBook.setId((Integer)(row.get("bookId")));
			activityBook.setAuthor((String) (row.get("author")));
			activityBook.setName((String) (row.get("bookName")));
			activityBook.setTopic(new Topic(
					(Integer) (row.get("topicId")) ,
					(String) (row.get("topicName"))
					));
			activity.setBook(activityBook);
			activity.setUser(user);
			activity.setReadingDate((Date) (row.get("readDate")));
			activityList.add(activity);
		}
		return activityList;
	}

	@Override
	public int addActivity(User user, int bookId) {
		String sql = "INSERT INTO activity(book_id,user_id,read_date) "
				+ "VALUES(:bookId, :userId, :readDate)";
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bookId", bookId);
		paramMap.put("userId", user.getId());
		paramMap.put("readDate", new Date());
		
		return getJdbcTemplate().update(sql, paramMap);
	}

}
