package livraria.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInicial {
	
	private static final Scanner sc = new Scanner(System.in);

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
		boolean start = true;
        while(start) {
        	header();
        	System.out.println("\t╭─────────────────────────────────────────────────╮"
							+"\n\t│                  BEM VINDO(A)                   │"
							+"\n\t├─────────────────────────────────────────────────┤"
							+"\n\t│            ╭──────────────────────╮             │"
							+"\n\t│            │1. Menu Administrador │             │"
							+"\n\t│            ╰──────────────────────╯             │"
							+"\n\t│            ╭──────────────────────╮             │"
							+"\n\t│            │2. Menu Cliente       │             │"
							+"\n\t│            ╰──────────────────────╯             │"
							+"\n\t│            ╭──────────────────────╮             │"
							+"\n\t│            │0. Sair               │             │"
							+"\n\t│            ╰──────────────────────╯             │"
							+"\n\t╰─────────────────────────────────────────────────╯");

            System.out.print("Escolha uma opção: ");
            int op = readOp();

            switch(op) {
    		case 1:
    			login();
    			break;	
    		case 2:
    			MenuComum.mainMenu();
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
	
	private static void login() {
		try {
			System.out.print("Digite a senha: ");
			sc.skip("\\R");
			int password = sc.nextInt();
			if (password == 123) {
				MenuAdmin.mainMenu();
			}
			else
				System.out.println("\t╭──────────────────╮"
								+"\n\t│ Senha incorreta. │"
								+"\n\t╰──────────────────╯");
		} catch (InputMismatchException e) {
			System.out.println("\t╭──────────────────╮"
							+"\n\t│ Senha incorreta. │"
							+"\n\t╰──────────────────╯");
			sc.nextLine();
		}
	}
	
	public static String end() {
		return			   "\t╭──────────────────────────────╮"
						+"\n\t│ Sistema encerrado. Até logo! │"
						+"\n\t│                              │"
						+"\n\t│ Desenvolvido por Quéren Alves│"
						+"\n\t╰──────────────────────────────╯";
		
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
}
