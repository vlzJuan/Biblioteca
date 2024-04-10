package com.miapp.biblioteca.ui;


import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.service.LibroServicio;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBuscarLibro {
	
	public static boolean menuBuscar(Scanner stdIn, LibroServicio biblioteca) {
	
		// Variable de control para mantenerse dentro de este menu. 
		// Solo se hace false si ingreso la opcion de salir de este menu (0).
		boolean continuar = true;
		
		System.out.println("\n[Menu: Buscador de libros.]");
		System.out.println("Elija una opcion:");
		System.out.println("1 - Buscar un libro por título");
		System.out.println("2 - Buscar un libro por autor");
		System.out.println("3 - Buscar un libro por genero");
		System.out.println("4 - Mostrar todo el catalogo de libros actuales.");
		System.out.println("0 - Salir de este menu.");
		
		
		while(!stdIn.hasNextInt()) {
			System.out.println("Ingrese la opcion que desea elegir.");
		}
		
		int opcion = stdIn.nextInt();
		stdIn.nextLine(); // Aca me como el \n que quedo pendiente.
		
		
		ArrayList<Libro> coincidencias = new ArrayList<Libro>();
		String entrada;
		
		switch (opcion) {
		
		case 1:
			// Busqueda por titulo
			System.out.println("Ingrese el titulo con el que buscar un libro:");
			entrada = stdIn.nextLine();
			
			for(Libro book:biblioteca.getInventario()) {	
				if(book.getTitulo().toLowerCase().contains(entrada.toLowerCase())) {
					coincidencias.add(book);
				}
			}
			mostrarCoincidencias(coincidencias,"titulo");
			
			break;
	
		case 2:
			// Busqueda por autor
			System.out.println("Ingrese el autor con el que buscar un libro:");
			entrada = stdIn.nextLine();
		
			for(Libro book:biblioteca.getInventario()) {			
				if(book.getAutor().toLowerCase().contains(entrada.toLowerCase())) {
					coincidencias.add(book);
				}
			}
			mostrarCoincidencias(coincidencias,"autor");
		
			break;
		case 3: 
			// Busqueda por autor
			System.out.println("Ingrese el genero con el que buscar un libro:");
			entrada = stdIn.nextLine();
		
			for(Libro book:biblioteca.getInventario()) {			
				if(book.getGenero().toLowerCase().contains(entrada.toLowerCase())) {
					coincidencias.add(book);
				}
			}
			mostrarCoincidencias(coincidencias, "genero");			
			
			break;
		case 4:
			// Aca se muestra el inventario actual.
			biblioteca.mostrarInventario();
			break;
		case 0:
			System.out.println("Saliendo del menu de busqueda de libros.\n");
			continuar = false;
			break;
		default: 
			System.out.println("Error: Debe ingresar una opcion valida.");
			break;
		}
		System.out.println("");	// Solo para dejar un espacio entre ejecuciones del menu.
		
		return continuar;
	}
	
	
	private static void mostrarCoincidencias(ArrayList<Libro> coincidencias, String criterio) {
		
		// Si la lista de coincidencias no esta vacia,
		if(!coincidencias.isEmpty()) {
			System.out.println("Los siguientes libros coinciden con la busqueda por "
					+ criterio + ":");
			for(Libro book:coincidencias) {
				System.out.println(book.toString());
			}
		}
		else {
			System.out.println("Ningun libro coincide con la busqueda.");
		}
	}
	
}
