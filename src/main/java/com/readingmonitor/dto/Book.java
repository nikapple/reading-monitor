package com.readingmonitor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private int id;
	@Column(name="book_name")
	private String name;
	private String author;
	private Boolean borrowed;
	@ManyToOne
	private Topic topic;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Boolean isBorrowed() {
		return borrowed;
	}
	public void setBorrowed(Boolean borrowed) {
		this.borrowed = borrowed;
	}
	
}
