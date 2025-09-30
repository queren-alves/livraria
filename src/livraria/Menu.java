package livraria;

import livraria.view.MenuAdmin;
import livraria.view.MenuComum;
import livraria.view.MenuInicial;

public class Menu {
	
	public static void main(String[] args) {
		MenuAdmin.init();
		MenuComum.init();
		MenuInicial.mainMenu();
	}
	
}