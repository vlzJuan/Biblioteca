package com.miapp.biblioteca;

//Importo los servicios necesarios para 'manejar' mi biblioteca.
import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;

//Importo la herramienta Scanner para leer entrada por consola.
import java.util.Scanner;

import com.miapp.biblioteca.ui.MenuPrincipal;

public class Main {

	public static void main(String[] args) {
		
		// Inicio un Scanner que mire la entrada por consola.
		Scanner stdIn = new Scanner(System.in);
		
		LibroServicio biblioteca= new LibroServicio();
		biblioteca.agregarLibro("Calculo 1", "Spivak", "001", "Educacion");
		biblioteca.agregarLibro("Juegos de Ingenio", "Katzenbach", "002", "Policial");
		biblioteca.agregarLibro("Fundacion", "Aasimov", "003", "Ciencia ficcion");
		
		UsuarioServicio usuarios = new UsuarioServicio();
		usuarios.crearUsuario("Juan Manuel", "Juan5");
		usuarios.crearUsuario("Martin Fernandez","MFernandez");
		usuarios.crearUsuario("Pablo Cortez", "C90");
		
		
		/**
		 * Secuencia de comandos para inventario inicial van aca
		 */
	

		/**
		 * Secuencia de comandos para lista de usuarios inicial va aca.
		 */
		
		System.out.println("¡Bienvenido al programa de biblioteca!");
		while(MenuPrincipal.menuPrincipal(stdIn, biblioteca, usuarios));	// Loop para la ejecucion constante del codigo.
		System.out.println("Programa finalizado. ¡Gracias por usar nuestro sistema!");
		
		// Cierro el scanner.
		stdIn.close();


		
	}

}
