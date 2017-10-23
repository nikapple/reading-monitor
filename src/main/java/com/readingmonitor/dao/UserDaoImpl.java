package com.readingmonitor.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.readingmonitor.dto.User;


@Repository
public class UserDaoImpl extends DaoImpl implements UserDao {

	@Override
	public boolean validateUser(User user) {
		if (checkPasswordMatch(user)) {
			return true;
		}
		return false;
	}

	private boolean checkPasswordMatch(User user) {
		
		Session session = getEntityManager().unwrap(Session.class);
		
		String email =  (String) session.createCriteria(User.class)
				.setProjection(Projections.property("email"))
				.add(Restrictions.eq("email", user.getEmail()))
				.add(Restrictions.eq("password", user.getPassword()))
				.uniqueResult();

		return email != null;
	}

	@Override
	public int insertUser(User user) {
		
		Session session = getEntityManager().unwrap(Session.class);
		
		session.save(user);

		return user.getId();
	}

	@Override
	public boolean checkUserExists(User user) {
		
		Session session = getEntityManager().unwrap(Session.class);
		
		String email = (String) session.createCriteria(User.class)
		.setProjection(Projections.property("email"))
		.add(Restrictions.eq("email", user.getEmail()))
		.uniqueResult();
		
		return email != null;

	}

	@Override
	public User getUserInfo(User user) {
		
		Session session = getEntityManager().unwrap(Session.class);
		
		user = (User) session.createCriteria(User.class)
				.add(Restrictions.eq("email", user.getEmail())).uniqueResult();
		
		return user;
	}

}
