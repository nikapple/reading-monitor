package com.readingmonitor.dao;

import com.readingmonitor.dto.User;

public interface UserDao {
	boolean validateUser(User user);
	int insertUser(User user);
	boolean checkUserExists(User user);
	User getUserInfo(User user);

}
