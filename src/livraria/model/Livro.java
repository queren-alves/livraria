package livraria.model;

public class Livro extends Produto{
	
	private String gender, author, publisher;
	
	public Livro(int id, int stock, int category, float price, String name, String gender, String author, String publisher) {
		super(id, stock, category, price, name);
		this.gender = gender;
		this.author = author;
		this.publisher = publisher;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public void view() {
		super.view();
		System.out.printf("\tGênero: %s%n", this.gender);
		System.out.printf("\tAutor: %s%n", this.author);
		System.out.printf("\tEditora: %s%n", this.publisher);
	}
}