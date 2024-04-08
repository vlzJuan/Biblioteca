package com.miapp.biblioteca.ui;

import java.util.Scanner;

public class Menu {
	
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
	public static boolean menuPrincipal(Scanner stdIn) {
		
		// Variable de retorno. Solo sera false cuando ingrese la opcion de 'Salir'.
		boolean continuar = true;
		
		System.out.println("Ingrese el numero de la operacion que quiere realizar:");
		System.out.println("\t1-Solicitar prestamo de libro.");
		System.out.println("\t2-Devolver un libro.");
		System.out.println("\t3-Ver catalogo.");
		System.out.println("\t4-Administrar catalogo.");
		System.out.println("\t0-Salir.");
		// Mientras no se ingresa una opcion valida, se sigue solicitando.
		while(!stdIn.hasNextInt()) {
			System.out.println("Error: Debe ingresar un entero correspondiente"
					+ "a una de las opciones.");
		}
		// Cuando se puede interpretar la entrada como int, la guardo como
		// la opcion ingresada.
		switch(stdIn.nextInt()) {
		case 1:	
			System.out.println("DEBUG. Aca llamo a la funcion de prestamo");
			break;
		case 2:
			System.out.println("DEBUG. Aca llamo a la funcion de devolver.");
			break;
		case 3:
			System.out.println("DEBUG. Aca llamo a la funcion de catalogo.");
			break;
		case 4:
			System.out.println("DEBUG. Aca llamo a administrar catalogo.");
			break;
		case 0:
			System.out.println("Programa finalizado. ¡Que tenga un buen día!");
			continuar=false;
			break;
		default:	
			System.out.println("Opcion ingresada no reconocida. Regresando "
					+ "al menu principal.");
			break;
		}
		
		return continuar;
		
	}
	
	public static void prestarLibro() {
		// ToDo
	}
	public static void devolverLibro() {
		
	}
	
	
	
	
	
	

}
