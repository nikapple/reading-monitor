package com.readingmonitor.service;

import com.readingmonitor.dto.User;

public interface UserService {

	boolean validateUser(User user);
	int insertUser(User user);
	boolean checkUserExists(User user);
	User getUserInfo(User user);
}
