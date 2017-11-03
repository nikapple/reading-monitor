package com.readingmonitor.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readingmonitor.dto.Activity;
import com.readingmonitor.dto.User;
import com.readingmonitor.service.MonitorActivityService;

@Controller
public class ActivityController {

	@Autowired
	MonitorActivityService activityService;

	public MonitorActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(MonitorActivityService activityService) {
		this.activityService = activityService;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/addActivity", method = RequestMethod.GET)
	public String addActivity(@RequestParam int bookId, Model model, HttpSession session){
		User user = (User) session.getAttribute("user");
		int id = activityService.addActivity(user, bookId);
		return (id >= 0) ? "true" : "false";
	}
	
	@RequestMapping(value = "/activityForm", method = RequestMethod.GET)
	public String displayActivityForm( Model model, @ModelAttribute("user") User user){
		return "activity-report-form";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getActivities", method = RequestMethod.GET)
	public List<Activity> getActivitiesByUser(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
			@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate, Model model, HttpSession session){
		User user = (User) session.getAttribute("user");
		System.out.println(startDate+" "+endDate+" "+user.getEmail());
		return activityService.getActivities(user, startDate, endDate);
	}
}
