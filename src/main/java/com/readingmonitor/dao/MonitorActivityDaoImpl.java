package com.readingmonitor.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.readingmonitor.dto.Activity;
import com.readingmonitor.dto.Book;
import com.readingmonitor.dto.User;

@Repository
public class MonitorActivityDaoImpl extends DaoImpl implements MonitorActivityDao{


	@Override
	public int getActivitiesCount(){
		String hql = "select count(*) from Activity";
		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery(hql);
		int result = ((Long)query.uniqueResult()).intValue();
		
		session.getTransaction().commit();
		session.close();
		
		return result;
	}

	@Override
	public List<Activity> getActivities(User user, Date startDate, Date endDate) {
		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Activity> activityList =  (List<Activity>) session.createCriteria(Activity.class)
		.add(Restrictions.ge("readingDate", startDate))
		.add(Restrictions.le("readingDate", endDate))
		.createAlias("user", "u")
		.add(Restrictions.eq("u.id", user.getId()))
		.list();
		
		session.getTransaction().commit();
		session.close();
		
		return activityList;
	}

	@Override
	public int addActivity(User user, int bookId) {
		
		Activity activity = new Activity();
		activity.setUser(user);
		Book book = new Book();
		book.setId(bookId);
		activity.setBook(book);
		activity.setReadingDate(new Date());
		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(activity);
		
		session.getTransaction().commit();
		session.close();
		return activity.getId();
	}

}
