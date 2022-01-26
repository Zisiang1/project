public class Review {

	private int id;
	private String username;
	private String book;
	private String reviews;
	private String ratings;
	private int bookid;

	public Review(int id, String username, String book, String reviews, String ratings, int bookid) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.username = username;
		this.book = book;
		this.reviews = reviews;
		this.ratings = ratings;
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

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
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

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

}
