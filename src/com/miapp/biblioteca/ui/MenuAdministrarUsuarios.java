package com.miapp.biblioteca.ui;

import java.util.Scanner;

import com.miapp.biblioteca.Usuario;

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
			modificarUsuario(stdIn, usuarios);
			
			break;
		case 3: 
			// Menu para eliminar un usuario del catalogo
			eliminarUsuario(stdIn, usuarios);
						
			break;
		case 4:
			// Aca se muestra un solo usuario
			mostrarUsuario(stdIn, usuarios);
			break;
			
		case 5:
			// Aca se muestran todos los usuarios.
			mostrarAllUsuarios(usuarios);
			break;
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
	 * @param stdIn		, un Scanner heredado del main que apunta a System.in
	 * @param usuarios	, la instancia de UsuarioServicio que contiene los users registrados.
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
		System.out.println("Regresando al menu de administración de usuarios...");
	}
	
	/**
	 * Metodo que administra el menu de modificar un usuario.
	 * // TODO: FALTA CHEQUEAR SI QUIERO CAMBIAR EL ID
	 * @param stdIn		, un Scanner heredado del main que apunta a System.in
	 * @param usuarios	, la instancia de UsuarioServicio que contiene los users registrados.
	 */
	private static void modificarUsuario(Scanner stdIn, UsuarioServicio usuarios) {
		
		System.out.println("Ingrese el identificador del usuario a modificar:");
		String oldId = stdIn.nextLine();
		
		Usuario currentUser = usuarios.getUser(oldId);
		// TODO: CHEQUEO DE SI HAY QUE CAMBIAR EL ID, AL IGUAL QUE CON LOS LIBROS.
		// Si el usuario existe entre los registrados, se hace esto.
		
		if(currentUser!=null) {
			
			System.out.print("Ingrese el nuevo identificador del usuario a utilizar ");
			System.out.println("(Ingrese una cadena vacia para no modificar)");
			String nuevoId = stdIn.nextLine();
			
			if(nuevoId.equals("")) {
				nuevoId = oldId;
			}
			
			// Si no hay un usuario con nuevoId, OR, ese usuario que hay es el mismo...
			if(usuarios.getUser(nuevoId)==null || nuevoId.equals(oldId)) {
				
				System.out.println("El nombre actual del usuario es: " + currentUser.getNombre());
				System.out.print("Ingrese el nombre que quiere darle al usuario ");
				System.out.println("(ingrese una cadena vacia para no modificar):");
				String userNombre = stdIn.nextLine();
				
				usuarios.updateUsuario(oldId, nuevoId, userNombre);
			
				System.out.println("El usuario ha sido modificado.");
			}
		}
		else {
			// Si estoy aca, es porque el usuario no existia.
			System.out.println("El usuario a modificar no existe en el sistema.");
		}
		
		System.out.println("Regresando al menu de administración de usuarios...");
		
	}
	
	
	
	
	private static void eliminarUsuario(Scanner stdIn, UsuarioServicio usuarios) {
		
		System.out.println("Ingrese el ID del usuario que desea eliminar:");
		String userId = stdIn.nextLine();
		
		Usuario eliminable = usuarios.getUser(userId);
		
		if(eliminable!=null) {
			
			// Si el eliminable no tiene libros prestados... 
			if(eliminable.getLibrosPrestados().isEmpty()) {
				
				System.out.println("Va a eliminar al siguiente usuario:");
				System.out.println(eliminable.toString());
				System.out.print("¿Desea eliminar al usuario? ");
				System.out.print("(Ingrese \"SI\" para realizar la operación, ");
				System.out.println("o cualquier otra cadena para no hacerlo): ");
				
				// Hay que escribir "SI", case insensitive, para borrar. Por seguridad de
				// no borrar cosas por accidente.
				if(stdIn.nextLine().equalsIgnoreCase("SI")) {
					usuarios.eliminarUsuario(userId);
					System.out.println("El usuario ha sido eliminado con exito.");
				}
				else {
					System.out.println("Operacion cancelada. El usuario no fue eliminado.");
				}
			}
			else {
				// Si estoy aca, ese usuario tiene libros que devolver.
				System.out.println("El usuario tiene libros para devolver. NO puede ser "
						+ "eliminado hasta que los devuelva.");
			}
			
		}
		else {
			System.out.println("El usuario no se encuentra registrado, ergo, no se lo puede "
					+ "eliminar.");
		}
		
	
		
		
		
	}
	
	
	/**
	 * Metodo que imprime el usuario y sus libros prestados.
	 * @param stdIn		, Scanner heredado de main que apunta a System.in
	 * @param usuarios	, el objeto que guarda todos los usuarios registrados.
	 */
	private static void mostrarUsuario(Scanner stdIn, UsuarioServicio usuarios) {
		
		System.out.println("Ingrese el identificador del usuario que quiere mostrarse:");
		String userId = stdIn.nextLine();
		Usuario currentUser = usuarios.getUser(userId);
		
		if(currentUser!=null) {
			
			System.out.println(currentUser.toString());
			usuarios.mostrarLibrosPrestados(currentUser);
	
		}
		else {
			System.out.println("No se ha encontrado el usuario solicitado.");
		}
		
	}
	
	/**
	 * Metodo que imprime por consola todos los usuarios registrados, junto a sus libros
	 * prestados (si los tienen)
	 * @param usuarios	, el objeto donde se guardan todos los usuarios registrados.
	 */
	private static void mostrarAllUsuarios(UsuarioServicio usuarios) {
		
		// Si la lista de usuarios no esta vacia,
		if(!usuarios.getListaUsuarios().isEmpty()) {
			
			System.out.println("A continuación se muestran todos los usuarios registrados "
					+ "en el sistema:");
			for(Usuario user:usuarios.getListaUsuarios()) {
				
				System.out.println(user.toString());
				usuarios.mostrarLibrosPrestados(user);
			}
		}
		else {
			System.out.println("No hay usuarios registrados en el sistema.");
		}
	}
	
	
	
	
	
}
