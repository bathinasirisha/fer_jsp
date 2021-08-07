package com.rs.fer.bean;

public class Expense {

	private int id;
	private String expenseType;
	private String date;
	private float price;
	private int numberOfItems;
	private float total;
	private String byWhom;
	private int userId;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseType=" + expenseType + ", date=" + date + ", price=" + price
				+ ", numberOfItems=" + numberOfItems + ", total=" + total + ", byWhom=" + byWhom + ", userId=" + userId
				+ "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getByWhom() {
		return byWhom;
	}

	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
