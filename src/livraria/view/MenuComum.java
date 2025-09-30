package livraria.view;

import java.util.Scanner;

import livraria.controller.ProdutoController;
import livraria.model.Caneca;
import livraria.model.Livro;

public class MenuComum {

	private static final Scanner sc = new Scanner(System.in);
	private static final ProdutoController produtoController = new ProdutoController();
	
	public static void mainMenu() {
		boolean start = true;
        while(start) {
        	
		System.out.println("\t╭─────────────────────────────────────────────────╮"
						+"\n\t│           ─────── MENU CLIENTE───────           │"
						+"\n\t├─────────────────────────────────────────────────┤"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │1. Listar Todos os Produtos    │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │2. Adicionar no carrinho       │        │"
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
								+"\n\t│     Listar Produtos     │"
								+"\n\t╰─────────────────────────╯");
    			viewAll();
    			keyPress();
    			break;	
    		case 2:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│  Adicionar no carrinho  │"
								+"\n\t╰─────────────────────────╯");
    			
    			keyPress();
    			break;
    		case 0:
    			start = false;
    			sc.nextLine();
    			keyPress();
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
