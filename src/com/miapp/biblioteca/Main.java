package com.miapp.biblioteca;

import java.util.Scanner;

import com.miapp.biblioteca.ui.Menu;

public class Main {

	public static void main(String[] args) {
		
		// Inicio un Scanner que mire la entrada por consola.
		Scanner stdIn = new Scanner(System.in);

		/* Aca hacer el codigo para inicializar el inventario y los usuarios iniciales.
		*
		**
		**
		*/
		
		System.out.println("¡Bienvenido al programa de biblioteca!");
		
		while(Menu.menuPrincipal(stdIn));	// Loop para la ejecucion constante del codigo.
		
		System.out.println("Programa finalizado. ¡Gracias por usar nuestro sistema!");
		
		stdIn.close();


		
	}

}
