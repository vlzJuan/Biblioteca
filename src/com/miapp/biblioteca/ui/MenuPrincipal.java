package com.miapp.biblioteca.ui;

import java.util.Scanner;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;

public class MenuPrincipal {
	
	/**
	 * menuPrincipal();
	 * Un metodo utilizado para mostrar las opciones principales de quien use
	 * el programa. Esto mostrara un listado de opciones por consola, y permitira
	 * elegir que opcion usar. Dentro del switch se llamaran a las funciones
	 * correspondientes.
	 * @param stdIn	, un Scanner pasado como parametro. Solo lo hago de esta forma para
	 * 				declarar una vez el Scanner en el main y no volver a iniciar un
	 * 				Scanner de entrada interna cada vez que uso una nueva funcion del menu.
	 * @return		'true'	, cuando quiero que el programa siga corriendo,
	 * 				'false	, cuando quiero que el programa se detenga.
	 */
	public static boolean menuPrincipal(Scanner stdIn,LibroServicio biblioteca,
										UsuarioServicio usuarios) {
		
		// Variable de retorno. Solo sera false cuando ingrese la opcion de 'Salir'.
		boolean continuar = true;
		System.out.println("\n[Menu Principal]");
		System.out.println("Ingrese el numero de la operacion que quiere realizar:");
		System.out.println("\t1-Solicitar prestamo de libro.");
		System.out.println("\t2-Devolver un libro.");
		System.out.println("\t3-Buscar un libro.");
		System.out.println("\t4-Administrar catalogo");
		System.out.println("\t5-Administrar usuarios");
		//System.out.println("\t3-Ver libros que un usuario tiene.");
		//System.out.println("\t4-Ver catalogo.");
		//System.out.println("\t4-Administrar catalogo.");
		//System.out.println("\t5-Administrar usuarios.");
		System.out.println("\t0-Salir.");
		// Mientras no se ingresa una opcion valida, se sigue solicitando.
		while(!stdIn.hasNextInt()) {
			System.out.println("Ingrese el numero de la opcion que desea usar.");
		}
		// Cuando se puede interpretar la entrada como int, la guardo como
		// la opcion ingresada.
		
		int opcion = stdIn.nextInt();
		stdIn.nextLine(); // Limpio el \n
		
		switch(opcion) {
		case 1:	
			// Solicito el prestamo de un libro.
			pedirLibro(stdIn, biblioteca, usuarios);
			break;
		case 2:
			// Solicito devolver un libro.
			devolverLibro(stdIn, biblioteca, usuarios);
			break;
		case 3:
			// Aca hacer lo necesario para buscar libros.
			MenuBuscarLibro.menuBuscar(stdIn, biblioteca);
			break;
		case 4:
			// Aca, accedo al menu para administrar el inventario.
			// Esta dentro de un while para que se ejecute HASTA que, dentro de ese
			// menu, se elija salir del administrador de catalogo.
			while(MenuAdministrarCatalogo.menuCatalogo(stdIn, biblioteca));
			break;
		case 5:
			// Hago un menu para administrar los usuarios
			while(MenuAdministrarUsuarios.menuUsuarios(stdIn, usuarios));
			break;
		case 0:
			continuar=false;
			break;
		default:	
			System.out.println("Opcion ingresada no reconocida. Regresando "
					+ "al menu principal.");
			break;
		}
		
		return continuar;
		
	}
	
	/**
	 * Metodo privado que administra lo necesario para que un usuario pida un libro.
	 * @param stdIn
	 * @param biblioteca
	 * @param usuarios
	 */
	private static void pedirLibro(Scanner stdIn, LibroServicio biblioteca, 
									UsuarioServicio usuarios) {
		
		System.out.println("Ingrese el codigo ISBN del libro a solicitar:");
		String libroISBN = stdIn.nextLine();
		
		Libro currentLibro = biblioteca.getLibro(libroISBN);
		
		
		if(currentLibro!=null) {
		
			System.out.println("Ingrese el identificador de usuario.");
			String userId = stdIn.nextLine();
			
			Usuario currentUser = usuarios.getUser(userId);
			
			// Invoco el metodo que presta libros.
			if(biblioteca.prestarLibro(currentLibro, currentUser)) {
				System.out.println("Libro prestado exitosamente.");
			}
			else {
				System.out.println("No se pudo prestar el libro al usuario solicitado.");
			}
		}
		else {
			System.out.println("El libro solicitado no esta disponible. Volviendo a menu.");
		}
	}
	
	
	/**
	 * Metodo privado que administra lo necesario para que un usuario devuelva un libro.
	 * @param stdIn
	 * @param biblioteca
	 * @param usuarios
	 */
	private static void devolverLibro(Scanner stdIn, LibroServicio biblioteca,
			UsuarioServicio usuarios) {

		System.out.println("Ingresar el ISBN del libro que se quiere devolver.");
		String libroISBN = stdIn.nextLine();
		Libro currentLibro = biblioteca.getLibro(libroISBN);

		if(currentLibro!=null) {

			System.out.println("Ingrese el Id del usuario que lo tiene.");

			String userId = stdIn.nextLine();
			Usuario currentUser = usuarios.getUser(userId);

			if(biblioteca.aceptarDevolucionLibro(currentLibro, currentUser)) {
				System.out.println("Devolucion realizada con exito.");
			}
			else {
				System.out.println("El usuario no poseia el libro a devolver.");
			}
		}
		else {
			System.out.println("El libro a devolver no existe. Volviendo a menu.");
		}
	}
	
	

}
