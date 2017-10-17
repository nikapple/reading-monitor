package com.readingmonitor.dao;

import java.util.Date;
import java.util.List;

import com.readingmonitor.dto.Activity;
import com.readingmonitor.dto.User;

public interface MonitorActivityDao {

	public List<Activity> getActivities(User user, Date startDate, Date endDate);
	public int addActivity(User user, int bookId);
	int getActivitiesCount();

}
