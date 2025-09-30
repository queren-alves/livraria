package livraria.model;

public abstract class Produto {
	
	private int id, stock, category;
	private float price;
	private String name;
	
	public Produto(int id, int stock, int category, float price, String name) {
		this.id = id;
		this.stock = stock;
		this.category = category;
		this.price = price;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void view() {
		String category = "";

		switch (this.category) {
			case 1 -> category = "Livro";
			case 2 -> category = "Caneca";
			default -> category = "Desconhecido";
		}

		System.out.println("\t╭──────────────────────────╮"
				 		+"\n\t│     Dados do Produto     │"
				 		+"\n\t╰──────────────────────────╯");
		System.out.printf("\tID: %d%n", this.id);
		System.out.printf("\tNome: %s%n", this.name);
		System.out.printf("\tCategoria: %s%n", category);
		System.out.printf("\tPreço: R$ %.2f%n", this.price);
	}
}