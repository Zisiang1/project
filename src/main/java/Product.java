public class Product {
	private int id;
	//private String id;
	private String title;
	private String author;
	private String description;
	private String genre;
	private String image;
	
	public Product(int id, String title, String author, String description, String genre, String image)
	{
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.genre = genre;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
