package com.readingmonitor.service;

import java.util.Date;
import java.util.List;

import com.readingmonitor.dto.Activity;
import com.readingmonitor.dto.User;

public interface MonitorActivityService {
	int addActivity(User user, int bookId);
	List<Activity> getActivities(User user, Date startDate, Date endDate);
}
