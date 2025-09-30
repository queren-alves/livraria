package livraria.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import livraria.controller.ProdutoController;
import livraria.model.Caneca;
import livraria.model.Livro;
import livraria.model.Produto;

public class MenuAdmin {

	private static final Scanner sc = new Scanner(System.in);
	private static final ProdutoController produtoController = new ProdutoController();
	
	public static void mainMenu() {
		boolean start = true;
        while(start) {
        	
		System.out.println("\t╭─────────────────────────────────────────────────╮"
						+"\n\t│        ─────── MENU ADMINISTRADOR───────        │"
						+"\n\t├─────────────────────────────────────────────────┤"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │1. Cadastrar Produto           │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │2. Listar Todos os Produtos    │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │3. Buscar Produto por ID       │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │4. Atualizar Preço do Produto  │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │5. Apagar Produto              │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │0. Sair                        │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t╰─────────────────────────────────────────────────╯"); 

            System.out.print("Escolha uma opção: ");
            int op = readOp();

            switch(op) {
    		case 1:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│    Cadastrar Produto    │"
								+"\n\t╰─────────────────────────╯");
    			register();
    			keyPress();
    			break;
    		case 2:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│     Listar Produtos     │"
								+"\n\t╰─────────────────────────╯");
    			viewAll();
    			keyPress();
    			break;	
    		case 3:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│      Buscar por ID      │"
								+"\n\t╰─────────────────────────╯");
    			searchById();
    			keyPress();
    			break;
    		case 4:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│    Atualizar Preço      │"
								+"\n\t╰─────────────────────────╯");
    			update();
    			keyPress();
    			break;
    		case 5:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│     Apagar Produto      │"
								+"\n\t╰─────────────────────────╯");
    			delete();
    			keyPress();
    			break;
    		case 0:
    			start = false;
    			break;
    		default:
    			System.err.println("\t╭────────────────────────────────────╮"
        						+"\n\t│ Opção inválida! Escolha novamente. │"
        						+"\n\t╰────────────────────────────────────╯");
            }
        }
	}
	
	private static void viewAll() {
		produtoController.viewAll();
		sc.nextLine();
	}
	
	private static void register() {
		try {
			System.out.print("\tDigite a categoria (1- Livro | 2- Caneca): ");
			int category = sc.nextInt();
			System.out.print("\tDigite o nome: ");
			sc.skip("\\R");
			String name = sc.nextLine();
			System.out.print("\tDigite a quantidade em estoque: ");
			int stock = sc.nextInt();
			System.out.print("\tDigite o preço: ");
			float price = sc.nextFloat(); 
		
			switch(category) {
			case 1 ->{
				System.out.print("\tDigite o gênero: ");
				sc.skip("\\R");
				String gender = sc.nextLine();
				System.out.print("\tDigite o nome do autor: ");
				String author = sc.nextLine();
				System.out.print("\tDigite a editora: ");
				String publisher = sc.nextLine();
				produtoController.register(new Livro(produtoController.generateId(), stock, category, price, name, gender, author, publisher));
				System.out.println("\t╭─────────────────────────────────╮"
				   				+"\n\t│ Produto cadastrado com sucesso. │"
				   				+"\n\t╰─────────────────────────────────╯");
			}
			case 2 -> {
				System.out.print("\tDigite a cor: ");
				sc.skip("\\R");
				String color = sc.nextLine();
				produtoController.register(new Caneca(produtoController.generateId(), stock, category, price, name, color));
				System.out.println("\t╭─────────────────────────────────╮"
				   				+"\n\t│ Produto cadastrado com sucesso. │"
				   				+"\n\t╰─────────────────────────────────╯");
			}
			default -> System.err.println("\t╭─────────────────────╮"
			 						   +"\n\t│ Categoria inválida. │"
			 						   +"\n\t╰─────────────────────╯");
			}
		} catch (InputMismatchException e) {
			System.err.println("\t╭───────────────────────────────────────╮"
					   		+"\n\t│ Digite os dados pedidos corretamente. │"
					   		+"\n\t╰───────────────────────────────────────╯");
			sc.nextLine();
		}
	}
	
	private static void update() {
		try {
			System.out.print("\n\tDigite o ID do produto: ");
			int id = sc.nextInt();
			sc.nextLine();
		
			Produto p = produtoController.search(id);
			if (p != null) {
				int stock = p.getStock();
				String name = p.getName();
				int category = p.getCategory();
				float price = p.getPrice();
				
				System.out.printf("\tPreço atual: %.2f\n\tNovo preço (Pressione ENTER para manter o valor atual): ", price);
				String input = sc.nextLine();
				price = input.isEmpty() ? price : Float.parseFloat(input);
				
				switch(category) {
				case 1 ->{
					String gender = ((Livro) p).getGender(); 
					String author = ((Livro) p).getAuthor(); 
					String publisher = ((Livro) p).getPublisher(); 
					
					produtoController.update(new Livro(id, stock, category, price, name, gender, author, publisher));
				}
				case 2 -> {
					String color = ((Caneca) p).getColor();
					produtoController.update(new Caneca(id, stock, category, price, name, color));
				}
				default -> System.err.println("\t╭─────────────────────╮"
				 						   +"\n\t│ Categoria inválida. │"
				 						   +"\n\t╰─────────────────────╯");
				}
			} else 
				 	System.err.println("\t╭───────────────────────────────╮"
				 				    +"\n\t│ O produto não foi encontrado. │"
				 					+"\n\t╰───────────────────────────────╯");
		} catch (InputMismatchException e) {
			System.err.println("\t╭───────────────────────────────────────╮"
			   				+"\n\t│ Digite os dados pedidos corretamente. │"
			   				+"\n\t╰───────────────────────────────────────╯");
			sc.nextLine();
		}
	}
	
	private static void delete() {
		try {
			System.out.print("\n\tDigite o ID do produto: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			Produto p = produtoController.search(id);
			if (p != null) {
				System.out.print("\n\tTem certeza que deseja excluir este produto? (S/N): ");
				String confirm = sc.nextLine();
				
				if (confirm.equalsIgnoreCase("s")) 
					produtoController.delete(id);
				else
					System.out.println("\t╭─────────────────────╮"
							   		+"\n\t│ Operação cancelada. │"
							   		+"\n\t╰─────────────────────╯");
			} else 
				System.err.println("\t╭───────────────────────────────╮"
						 		+"\n\t│ O produto não foi encontrado. │"
						 		+"\n\t╰───────────────────────────────╯");
		} catch (InputMismatchException e) {
			System.err.println("\t╭───────────────────────────────────────╮"
			   				+"\n\t│ Digite os dados pedidos corretamente. │"
			   				+"\n\t╰───────────────────────────────────────╯");
			sc.nextLine();
		}
	}
	
	private static void searchById() {
		try {
			System.out.print("\n\tDigite o ID do produto: ");
			int id = sc.nextInt();
			produtoController.searchById(id);
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.err.println("\t╭───────────────────────────────────────╮"
							+"\n\t│ Digite os dados pedidos corretamente. │"
							+"\n\t╰───────────────────────────────────────╯");
			sc.nextLine();
		}
	}
	
	public static int readOp() {
        while (!sc.hasNextInt()) {
        	 System.err.println("\n\t╭──────────────────────────╮"
             				   +"\n\t│ Digite um número válido! │"
             				   +"\n\t╰──────────────────────────╯");
            sc.next();
            System.out.print("Escolha novamente: ");
        }
        return sc.nextInt();
    }
	
	public static void keyPress() {
		System.out.println("\t╭────────────────────────────────╮"
						+"\n\t│ Pressione ENTER para continuar │"
						+"\n\t╰────────────────────────────────╯");
		sc.nextLine();
	}
	
	public static void init() {
		produtoController.register(new Livro(produtoController.generateId(), 10, 1, 85, "Jogos Vorazes: Livro Um", "Ficção", "Suzanne Collins", "Galera"));
		produtoController.register(new Livro(produtoController.generateId(), 10, 1, 85, "Jogos Vorazes: Livro Dois", "Ficção", "Suzanne Collins", "Galera"));
		produtoController.register(new Livro(produtoController.generateId(), 10, 1, 85, "Jogos Vorazes: Livro Três", "Ficção", "Suzanne Collins", "Galera"));
		produtoController.register(new Caneca(produtoController.generateId(), 10, 2, 45, "Jogos Vorazes", "Preto"));
		produtoController.register(new Caneca(produtoController.generateId(), 10, 2, 45, "Harry Potter", "Preto"));
	}
}
