package project;

public class Favourite {
	protected String title;
	protected String author;
	protected String name;
	public Favourite(String title, String author, String name) {
		super();
		this.title = title;
		this.author = author;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
