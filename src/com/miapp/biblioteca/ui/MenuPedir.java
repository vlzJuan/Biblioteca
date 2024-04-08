package com.miapp.biblioteca.ui;

import java.util.Scanner;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.*;


public class MenuPedir {
	
	// Menu principal de solicitar un prestamo de libro.
	public static void pedirLibro(Scanner stdIn, LibroServicio biblioteca, 
									UsuarioServicio usuarios) {
		
		System.out.println("Ingrese el codigo ISBN del libro a solicitar:");
		String libroISBN = stdIn.nextLine();
		
		Libro currentLibro = biblioteca.getLibro(libroISBN);
		
		
		if(currentLibro!=null) {
		
			System.out.println("Ingrese el identificador de usuario.");
			String userId = stdIn.nextLine();
			
			Usuario currentUser = usuarios.getUser(userId);
			
			if(currentUser!=null) {
				// ACA GESTIONAR PRESTAMO DEL LIBRO.
			}
			else {
				System.out.println("El identificador de usuario no coincide con un usuario "
						+ "registrado en el sistema.");
			}
		}
		else {
			System.out.println("El libro solicitado no esta disponible.");
		}
		
	}

}
