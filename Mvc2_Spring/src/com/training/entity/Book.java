package com.training.entity;

import java.time.LocalDate;

import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

@Component
public class Book {

	@NotNull
	@Max(value=1000,message="Max value should be 1000")
	@Min(value=10,message="Min value should be 10")
	private long bookNumber;
	
	
	private String bookName;
	private String author;
	private String category;
	
	@Past
	@DateTimeFormat(iso=ISO.DATE)
	public LocalDate dateOfPublish;
	private double ratePerUnit;
	public long getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDate getDateOfPublish() {
		return dateOfPublish;
	}
	public void setDateOfPublish(LocalDate dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", author=" + author + ", category="
				+ category + ", dateOfPublish=" + dateOfPublish + ", ratePerUnit=" + ratePerUnit + "]";
	}
	public Book(long bookNumber, String bookName, String author, String category, LocalDate dateOfPublish,
			double ratePerUnit) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.dateOfPublish = dateOfPublish;
		this.ratePerUnit = ratePerUnit;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
}
