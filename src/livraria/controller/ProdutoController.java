package livraria.controller;

import java.util.ArrayList;
import java.util.List;

import livraria.model.Produto;
import livraria.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository{
	
	private List<Produto> produtos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void viewAll() {
		if (!produtos.isEmpty()) {
			for (var p : produtos) {
				p.view();
			}
		} else 
			System.out.println("\t╭──────────────────────────────╮"
			   				+"\n\t│ Não há produtos cadastrados. │"
			   				+"\n\t╰──────────────────────────────╯");
	}

	@Override
	public void register(Produto produto) {
		produtos.add(produto);
	}

	@Override
	public void update(Produto produto) {
		var search = search(produto.getId());
		
		if (search != null) {
			produtos.set(produtos.indexOf(search), produto);
			System.out.println("\t╭───────────────────────────────────────╮"
						   	+"\n\t│ O Produto foi atualizado com sucesso. │"
						   	+"\n\t╰───────────────────────────────────────╯");
		} else
			System.err.println("\t╭───────────────────────────────╮"
							+"\n\t│ O Produto não foi encontrado. │"
							+"\n\t╰───────────────────────────────╯");
		
	}

	@Override
	public void searchById(int id) {
		var p = search(id);
		if(p != null) 
			p.view();
		else 
			System.err.println("\t╭───────────────────────────────╮"
					  		+"\n\t│ O Produto não foi encontrado. │"
					  		+"\n\t╰───────────────────────────────╯");
		
	}

	@Override
	public void delete(int id) {
		var p = search(id);
		if (p != null) {
			if (produtos.remove(p)) 
				System.out.println("\t╭─────────────────────────────────────╮"
						  		+"\n\t│ O Produto foi deletado com sucesso. │"
						  		+"\n\t╰─────────────────────────────────────╯");
		} else 
			System.err.println("\t╭───────────────────────────────╮"
						    +"\n\t│ O Produto não foi encontrado. │"
							+"\n\t╰───────────────────────────────╯");
		
	}
	
	public int generateId() {
		return ++id;
	}
	
	public Produto search(int id) {
		for(var p : produtos) {
			if(p.getId() == id) 
				return p;
		}	
		return null;
	}
}