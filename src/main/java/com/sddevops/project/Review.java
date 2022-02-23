/**
 * 
 */
package com.sddevops.project;

/**
 * @author jaaxx
 *
 */
public class Review {
	
	private int id;
	private String username;
	private String reviews;
	private String ratings;
	private String book;
	private String bookid;

	public Review(int id, String username, String reviews, String ratings, String book, String bookid) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.username = username;
		this.reviews = reviews;
		this.ratings = ratings;
		this.book = book;
		this.bookid = bookid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	
	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

}
