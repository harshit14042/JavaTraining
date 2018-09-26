package com.training;

import java.util.ArrayList;
import java.util.List;

public class AddNumber<T,E> {
	private T digit;
	private List<E> list;
	
	public void addObject(E element){
		list.add(element);
	}

	public AddNumber(T digit, List<E> list) {
		super();
		this.digit = digit;
		this.list = list;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public T getDigit() {
		return digit;
	}

	public void setDigit(T digit) {
		this.digit = digit;
	}

	@Override
	public String toString() {
		return "AddNumber [digit=" + digit + "]";
	}

	public AddNumber(T digit) {
		super();
		this.digit = digit;
	}

	public AddNumber() {
		super();
		this.list=new ArrayList<E>();
	}
	
}
