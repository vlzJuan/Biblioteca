package com.miapp.biblioteca.ui;

import java.util.Scanner;

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
			MenuPedir.pedirLibro(stdIn, biblioteca, usuarios);
			break;
		case 2:
			// Solicito devolver un libro.
			MenuDevolver.devolverLibro(stdIn, biblioteca, usuarios);
			break;
		case 3:
			// Aca hacer lo necesario para buscar libros.
			// TODO
			//MenuMostrarPrestados.mostrarPrestados(stdIn,usuarios);
			break;
		case 4:
			// Aca, accedo al menu para administrar el inventario.
			// Esta dentro de un while para que se ejecute HASTA que, dentro de ese
			// menu, se elija salir del administrador de catalogo.
			while(MenuAdministrarCatalogo.menuCatalogo(stdIn, biblioteca));
			break;
		case 5:
			// Hago un menu para administrar los usuarios
			System.out.println("DEBUG. Aca llamo a administrar usuarios.");
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
	
	

}
