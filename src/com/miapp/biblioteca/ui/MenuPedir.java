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
			
			// Invoco el metodo que presta libros.
			if(biblioteca.prestarLibro(currentLibro, usuarios, currentUser)) {
				System.out.println("Libro prestado exitosamente.");
			}
			else {
				System.out.println("No se pudo prestar el libro al usuario solicitado.");
			}
		}
		else {
			System.out.println("El libro solicitado no esta disponible.");
		}
		
	}

}
