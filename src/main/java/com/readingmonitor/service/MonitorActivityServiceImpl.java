package com.readingmonitor.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.readingmonitor.dao.MonitorActivityDao;
import com.readingmonitor.dto.Activity;
import com.readingmonitor.dto.User;

@Service
@Transactional
public class MonitorActivityServiceImpl implements MonitorActivityService{

	@Autowired
	MonitorActivityDao activityDao;
	
	public MonitorActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(MonitorActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	@Override
	public int addActivity(User user, int bookId) {
		return activityDao.addActivity(user,bookId);
	}

	@Override
	public List<Activity> getActivities(User user, Date startDate, Date endDate) {
		return activityDao.getActivities(user,startDate,endDate);
	}

}
