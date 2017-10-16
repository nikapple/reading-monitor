package com.readingmonitor.dto;

import java.util.Date;

public class Activity {
	
	private int id;
	private Book book;
	private User user;
	private Date readingDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getReadingDate() {
		return readingDate;
	}
	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}
	
	
}
