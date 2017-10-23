package com.readingmonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.readingmonitor.dao.UserDao;
import com.readingmonitor.dto.User;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean validateUser(User user) {
		return userDao.validateUser(user);
	}

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public boolean checkUserExists(User user) {
		return userDao.checkUserExists(user);
	}

	@Override
	public User getUserInfo(User user) {
		return userDao.getUserInfo(user);
	}


}
