package com.miapp.biblioteca.ui;


import java.util.Scanner;
import com.miapp.biblioteca.service.LibroServicio;

public class MenuAdministrarCatalogo {
	
	public static boolean menuCatalogo(Scanner stdIn, LibroServicio biblioteca) {
		
		// Variable de control para mantenerse dentro de este menu. 
		// Solo se hace false si ingreso la opcion de salir de este menu (0).
		boolean continuar = true;
		
		System.out.println("Administracion del catalogo.");
		System.out.println("Elija una opcion:");
		System.out.println("1 - Buscar un libro");
		System.out.println("2 - Agregar un libro al catalogo");
		System.out.println("3 - Eliminar un libro del catalogo");
		System.out.println("4 - Mostrar todo el catalogo de libros actuales.");
		System.out.println("0 - Salir de este menu.");
		
		
		while(!stdIn.hasNextInt()) {
			System.out.println("Ingrese la opcion que desea elegir.");
		}
		
		int opcion = stdIn.nextInt();
		
		switch (opcion) {
		
		case 1:
			// Aca hacer lo necesario para buscar un libro.
			break;
		case 2:
			// Aca hacer lo necesario para agregar un libro al catalogo.
			break;
		case 3: 
			// Eliminar un libro del catalogo.
			break;
		case 4:
			// Aca usar lo necesario para mostrar todos los libros.
			break;
		case 0:
			System.out.println("Saliendo del menu de administrador de libros.\n");
			continuar = false;
			break;
		default: 
			System.out.println("Error: Debe ingresar una opcion valida.");
			break;
		}
		
		return continuar;
		
	}
	
	

}
