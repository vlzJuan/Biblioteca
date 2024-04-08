package com.miapp.biblioteca.ui;

import java.util.Scanner;
import com.miapp.biblioteca.service.*;


public class MenuSolicitarPrestamo {
	
	// Menu principal de solicitar un prestamo de libro.
	public static void menuPrestamo(Scanner stdIn, LibroServicio biblioteca, 
									UsuarioServicio usuarios) {
		
		System.out.println("Ingrese el codigo ISBN del libro a solicitar:");
		String libroISBN = stdIn.nextLine();
		
		if(biblioteca.libroDisponible(libroISBN)) {
		
			System.out.println("Ingrese el identificador de usuario.");
			String userId = stdIn.nextLine();
			
			if(usuarios.usuarioExiste(userId)) {
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
