package com.miapp.biblioteca.ui;

import java.util.Scanner;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.UsuarioServicio;

public class MenuMostrarPrestados {

	public static void mostrarPrestados(Scanner stdIn, UsuarioServicio usuarios) {
		
		System.out.println("Ingrese el id de usuario cuyos libros quiere ver.");
		String userId = stdIn.nextLine();
		Usuario currentUser = usuarios.getUser(userId);
		
		// Si el usuario esta en la lista,
		if(currentUser!=null) {
			// Si la lista de libros del usuario no esta vacia,
			if(!currentUser.getLibrosPrestados().isEmpty()) {
				for(Libro book:currentUser.getLibrosPrestados()) {
					System.out.println(book.toString()+"\n");
				}
			}
			else {
				System.out.println("El usuario no tenia libros prestados.");
			}
		}
		else {
			System.out.println("El usuario solicitado no existe. Volviendo a menu.");
		}
		
		
	}
	
	
}
