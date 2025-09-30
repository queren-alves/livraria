package livraria.repository;

import livraria.model.Produto;

public interface ProdutoRepository {
	
	void viewAll();
	void register(Produto produto);
	void update(Produto produto);
	void searchById(int id);
	void delete(int id);
	void searchByTitle(String title);
	
}
