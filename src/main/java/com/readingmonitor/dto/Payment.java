package com.readingmonitor.dto;

import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Payment {
	
	@Id
	private int id;
	@OneToMany
	Book book;
	double amount;
	
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
