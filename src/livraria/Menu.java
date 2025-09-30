package livraria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void header() {
		LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("\t╭─────────────────────────────────────────────────╮"
        				+"\n\t│         ─────── Books n' Coffee ───────         │"
        				+"\n\t│     Onde um bom livro encontra um bom café      │"
        				+"\n\t│        Data/Hora: "+ time + "           │"
        				+"\n\t╰─────────────────────────────────────────────────╯");
	}
	
	public static void mainMenu() {
		Menu.header();
		boolean start = true;
        while(start) {
        	
		System.out.println("\t╭─────────────────────────────────────────────────╮"
						+"\n\t│               ─────── MENU ───────              │"
						+"\n\t├─────────────────────────────────────────────────┤"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │1. Criar Produto               │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │2. Listar Todos os Produtos    │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │3. Buscar Produto por ID       │        │"
						+"\n\t│        ╰───────────────────────────────╯        │"
						+"\n\t│        ╭───────────────────────────────╮        │"
						+"\n\t│        │4. Atualizar Dados do Produto  │        │"
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
								+"\n\t│      Criar Produto      │"
								+"\n\t╰─────────────────────────╯");
    			break;
    		case 2:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│     Listar Produtos     │"
								+"\n\t╰─────────────────────────╯");
    			break;	
    		case 3:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│      Buscar por ID      │"
								+"\n\t╰─────────────────────────╯");
    			break;
    		case 4:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│    Atualizar Produto    │"
								+"\n\t╰─────────────────────────╯");
    			break;
    		case 5:
    			System.out.println("\t╭─────────────────────────╮"
								+"\n\t│     Apagar Produto      │"
								+"\n\t╰─────────────────────────╯");
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
        
        System.out.println(end());
        sc.close();
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
	
	public static String end() {
		return			   "\t╭──────────────────────────────╮"
						+"\n\t│ Sistema encerrado. Até logo! │"
						+"\n\t│                              │"
						+"\n\t│ Desenvolvido por Quéren Alves│"
						+"\n\t╰──────────────────────────────╯";
		
	}
	
	public static void keyPress() {
		System.out.println("\t╭────────────────────────────────╮"
						+"\n\t│ Pressione ENTER para continuar │"
						+"\n\t╰────────────────────────────────╯");
		sc.nextLine();
	}
}