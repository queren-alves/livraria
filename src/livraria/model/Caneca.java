package livraria.model;

public class Caneca extends Produto {

	String color;

	public Caneca(int id, int stock, int category, float price, String name, String color) {
		super(id, stock, category, price, name);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void view() {
		super.view();
		System.out.printf("\tCor: %s%n", this.color);
	}
}