package com.sddevops.project;

public class Cart {
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", bookid=" + bookid + ", username=" + username + ", book=" + book + ", img=" + img
				+ ", paid=" + paid + ", price=" + price + ", quantity=" + quantity + ", totalcost=" + totalcost
				+ ", date=" + date + "]";
	}


	private int id;
	private int bookid;
	private String username;
	private String book;
	private String img;
	private String paid;
	private String price;
	private String quantity;
	private String totalcost;
	private String date;
	
	


	public Cart(int id, int bookid, String username, String book, String img, String paid, String price,
			String quantity, String totalcost, String date) {
		super();
		this.id = id;
		this.bookid = bookid;
		this.username = username;
		this.book = book;
		this.img = img;
		this.paid = paid;
		this.price = price;
		this.quantity = quantity;
		this.totalcost = totalcost;
		this.date = date;
	}


	public int getid() {
		return id;
	}


	public void setid(int id) {
		this.id = id;
	}

	public int getBookid() {
		return bookid;
	}


	public void setBookid(int bookid) {
		this.bookid = bookid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getBook() {
		return book;
	}


	public void setBook(String book) {
		this.book = book;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getPaid() {
		return paid;
	}


	public void setPaid(String paid) {
		this.paid = paid;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getTotalcost() {
		return totalcost;
	}


	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

}
