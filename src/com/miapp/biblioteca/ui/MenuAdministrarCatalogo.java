package com.miapp.biblioteca.ui;


import java.util.Scanner;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.service.LibroServicio;

public class MenuAdministrarCatalogo {
	
	public static boolean menuCatalogo(Scanner stdIn, LibroServicio biblioteca) {
		
		// Variable de control para mantenerse dentro de este menu. 
		// Solo se hace false si ingreso la opcion de salir de este menu (0).
		boolean continuar = true;
		
		System.out.println("\n[Menu: Administracion del catalogo.]");
		System.out.println("Elija una opcion:");
		System.out.println("1 - Agregar libro al catalogo");
		System.out.println("2 - Modificar libro en catalogo");
		System.out.println("3 - Eliminar un libro del catalogo");
		System.out.println("4 - Mostrar todo el catalogo de libros actuales.");
		System.out.println("0 - Salir de este menu.");
		
		
		while(!stdIn.hasNextInt()) {
			System.out.println("Ingrese la opcion que desea elegir.");
		}
		
		int opcion = stdIn.nextInt();
		stdIn.nextLine(); // Aca me como el \n que quedo pendiente.
		
		switch (opcion) {
		
		case 1:
			// Menu para agregar libro al catalogo.
			// Metodo privado que pertenece a esta clase.
			agregarLibroAlCatalogo(stdIn, biblioteca);
			break;

		case 2:
			// Caso para modificar libro
			modificarLibroDeCatalogo(stdIn, biblioteca);
			
			break;
		case 3: 
			// Eliminar un libro del catalogo.
			eliminarLibroDeCatalogo(stdIn, biblioteca);			
			break;
		case 4:
			// Aca se muestra el inventario actual.
			biblioteca.mostrarInventario();
			break;
		case 0:
			System.out.println("Saliendo del menu de administrador de libros.\n");
			continuar = false;
			break;
		default: 
			System.out.println("Error: Debe ingresar una opcion valida.");
			break;
		}
		
		System.out.println("");	// Solo para dejar un espacio entre ejecuciones del menu.
		
		
		return continuar;
		
	}
	
	/**
	 * DECLARACION DE METODOS PARA ESTE MENU
	 */
	
	/**
	 * Metodo que administra la opcion de agregar un libro al catalogo de una biblioteca.
	 * @param stdIn			, el Scanner que se usara para las entrada (se le pasa el System.in ,
	 * 						arrastrado desde el main, en este caso).
	 * @param biblioteca	, la biblioteca a la que se le quiere agregar el libro.
	 */
	private static void agregarLibroAlCatalogo(Scanner stdIn, LibroServicio biblioteca) {
		
		System.out.println("Ingrese el ISBN del libro a agregar:");
		String libroNuevoISBN = stdIn.nextLine();
		
		// Si el libro, buscado por ISBN, no existe, sigo con el proceso 
		// de pedir los otros datos.
		if(biblioteca.getLibro(libroNuevoISBN)==null) {
			
			System.out.println("Ingrese el titulo del libro a agregar:");
			String libroNuevoTitulo = stdIn.nextLine();
			System.out.println("Ingrese el autor del libro a agregar:");
			String libroNuevoAutor = stdIn.nextLine();
			System.out.println("Ingrese el genero del libro a agregar:");
			String libroNuevoGenero = stdIn.nextLine();
			
			biblioteca.agregarLibro(libroNuevoTitulo, libroNuevoAutor, 
					libroNuevoISBN, libroNuevoGenero);
			
			System.out.println("El libro ha sido agregado al inventario "
					+ "de la biblioteca.");		
		}
		else {
			// Si el libro ya existe en biblioteca, doy aviso.
			
			System.out.println("Un libro con el ISBN correspondiente ya existe "
					+ "en esta biblioteca.");
		}
	}
	
	
	
	/**
	 * Metodo privado que administra la opcion de modificar un libro del catalogo de biblioteca.
	 * @param stdIn			, el Scanner que se usara para las entrada (se le pasa el System.in ,
	 * 						arrastrado desde el main, en este caso).
	 * @param biblioteca	, la biblioteca a la que se le quiere agregar el libro.
	 */
	private static void modificarLibroDeCatalogo(Scanner stdIn, LibroServicio biblioteca) {
		
		System.out.println("Ingrese el ISBN del libro que desea modificar:");
		String libroISBN = stdIn.nextLine();
		
		Libro modificable = biblioteca.getLibro(libroISBN);
		
		// Si puede identificar un libro con ese ISBN, puede modificarlo.
		if(modificable!=null) {
			
			System.out.print("Ingrese el nuevo ISBN a asignarle ");
			System.out.println("(Dejar en blanco para no modificar):");
			System.out.println("(Si el ISBN es repetido con otro libro en inventario, "
					+ "la operación será cancelada)");
			String nuevoISBN = stdIn.nextLine();
			
			if(nuevoISBN.equals("")) {
				nuevoISBN = libroISBN;
			}
			
			// En este IF, verifico que no haya OTRO libro en inventario 
			// con el nuevo ISBN.
			// Al usar biblioteca.getLibro(nuevoISBN), recibo si el ISBN 'pisa' el ISBN
			// de algun libro en catalogo.
			// Al comparar el nuevo ISBN con el ingresado inicial, me aseguro que estoy
			// tratando de modificar el mismo libro en inventario.
			// Los conecto con un 'or', mi idea es:
			// "[(Si el ISBN nuevo no pisa un libro en inventario), OR 
			//  (Pisa un libro, pero es el mismo que quiero modificar)], hago esto.
			if(biblioteca.getLibro(nuevoISBN)==null || 
					nuevoISBN.equals(libroISBN)) {
				
				System.out.println("Ingrese el nuevo título a asignarle ");
				System.out.println("(Dejar en blanco para no modificar):");
				String nuevoTitulo = stdIn.nextLine();
				System.out.println("Ingrese el nuevo autor a asignarle ");
				System.out.println("(Dejar en blanco para no modificar):");
				String nuevoAutor = stdIn.nextLine();
				System.out.println("Ingrese el nuevo genero a asignarle ");
				System.out.println("(Dejar en blanco para no modificar):");
				String nuevoGenero = stdIn.nextLine();
				
				
				if(biblioteca.actualizarLibro(	libroISBN, nuevoISBN, nuevoTitulo, 
												nuevoAutor, nuevoGenero)) {
					System.out.println("La operacion de modificar un libro fue "
							+ "realizada con exito.");
				}
				else {
					// Si llegue aca, el libro estaba prestado y no tiene sentido
					// modificarlo.
					System.out.println("El libro está prestado, no se lo puede modificar "
							+ "hasta que lo devuelvan.");
				}
			}
			else {
				// Con ese if, me evito modificar un libro que no queria modificar.
				// Si llegue aca, es porque iba a cometer un error y lo evité.
				System.out.println("Esta operacion sobreescribiria un libro que ya "
						+ "existe en el inventario, pero no es el libro que se "
						+ "pretendía modificar. Operación abortada.");
			}		
		}
		else {
			// Si no encontro un libro con ese ISBN, no se lo puede 'modificar'
			// porque nunca estuvo registrado en primer lugar.
			System.out.println("No se puede 'modificar' el libro solicitado, porque "
					+ "ese libro no esta registrado en biblioteca.");
		}
	}
	
	
	
	/**
	 * Metodo privado que administra la opcion de eliminar un libro del catalogo de biblioteca.
	 * @param stdIn			, el Scanner que se usara para las entrada (se le pasa el System.in ,
	 * 						arrastrado desde el main, en este caso).
	 * @param biblioteca	, la biblioteca a la que se le quiere agregar el libro.
	 */
	private static void eliminarLibroDeCatalogo(Scanner stdIn, LibroServicio biblioteca) {
		
		System.out.println("Ingrese el codigo ISBN del libro a eliminar:");
		String ISBN = stdIn.nextLine();
		
		Libro eliminable = biblioteca.getLibro(ISBN);
		
		// Si el libro esta en la biblioteca, se procede
		if(eliminable!=null) {
			// Verifico si esta prestado o no.
			if(eliminable.getDisponible()) {
				// Si esta disponible, lo puedo borrar.
				System.out.println("El libro a borrar sera:");
				System.out.println(eliminable.toString());
				System.out.print("¿Está seguro de que quiere borrarlo? ");					
				System.out.print("(Escriba \"SI\"para confirmar, ");
				System.out.println("o cualquier otra cosa para cancelar la operación).");

				// Hay que escribir "SI", case insensitive, para borrar. Por seguridad de
				// no borrar cosas por accidente.
				if(stdIn.nextLine().equalsIgnoreCase("SI")) {
					biblioteca.eliminarLibro(ISBN);
					System.out.println("El libro ha sido eliminado con exito.");
				}
				else {
					System.out.println("Operacion cancelada. El libro no fue eliminado.");
				}
			}
			else {
				// Si no esta esta disponible, no lo puedo borrar.
				System.out.println("El libro actualmente lo tiene un usuario. No "
						+ "se lo puede borrar hasta que sea devuelto.");
			}
		}
		else {
			// Si llegue aca, el libro no estaba en la biblioteca.
			System.out.println("El libro solicitado no esta en esta biblioteca.");
		}
	}
	
	
	

}
