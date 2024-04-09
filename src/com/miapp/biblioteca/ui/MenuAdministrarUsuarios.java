package com.miapp.biblioteca.ui;

import java.util.Scanner;

import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;

public class MenuAdministrarUsuarios {

	
	public static boolean menuUsuarios(Scanner stdIn, UsuarioServicio usuarios) {
		
		// Variable de control para mantenerse dentro de este menu. 
		// Solo se hace false si ingreso la opcion de salir de este menu (0).
		boolean continuar = true;
		
		System.out.println("\n[Menu: Administracion de usuarios.}");
		System.out.println("Elija una opcion:");
		System.out.println("1 - Agregar usuario al sistema.");
		System.out.println("2 - Modificar usuario en sistema.");
		System.out.println("3 - Eliminar usuario de sistema.");
		System.out.println("4 - Mostrar usuario del sistema.");
		System.out.println("5 - Mostrar todos los usuarios del sistema");
		System.out.println("0 - Salir de este menu.");
		
		while(!stdIn.hasNextInt()) {
			System.out.println("Ingrese la opcion que desea elegir.");
		}
		
		int opcion = stdIn.nextInt();
		stdIn.nextLine(); // Aca me como el \n que quedo pendiente.
		
		switch (opcion) {
		
		case 1:
			// Menu para agregar usuario al sistema.
			agregarUsuario(stdIn, usuarios);
			
			break;

		case 2:
			// Menu para modificar usuario del sistema.
			// TODO
			
			break;
		case 3: 
			// Menu para eliminar un usuario del catalogo
			// TODO
						
			break;
		case 4:
			// Aca se muestra un solo usuario
			
			break;
			
		case 5:
			// Aca se muestran todos los usuarios.
			
		case 0:
			System.out.println("Saliendo del menu de administrador de usuarios.\n");
			continuar = false;
			break;
		default: 
			System.out.println("Error: Debe ingresar una opcion valida.");
			break;
		}
		
		return continuar;
		
	}
	
	
	/**
	 * Metodo interno que administra el menu de ingresar un usuario al sistema.
	 * @param stdIn
	 * @param usuarios
	 */
	private static void agregarUsuario(Scanner stdIn, UsuarioServicio usuarios) {
		
		System.out.println("Ingrese el identificador de usuario a agregar:");
		String userId = stdIn.nextLine();
		
		Usuario currentUser = usuarios.getUser(userId);
		
		// Si no se encontro el usuario entre los existentes, se lo agregara.
		if(currentUser==null) {
			System.out.println("Ingrese el nombre real del usuario:");
			String userNombre = stdIn.nextLine();
			usuarios.crearUsuario(userNombre, userId);
			
			System.out.println("El usuario ha sido agregado al sistema.");
			
		}
		else {
			// Si entre aca, es porque ya existe un usuario con ese ID.
			System.out.print("Ya existe un usuario con ese identificador. ");
			System.out.println("Operación abortada.");
		}
	}
	
	
	
	
	
	
	
}
