package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.Scanner;

import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;


public class MenuDevolver {

	
	public static void devolverLibro(Scanner stdIn, LibroServicio biblioteca,
										UsuarioServicio usuarios) {
		
		System.out.println("Ingresar id de usuario");
		String userId = stdIn.nextLine();
		Usuario currentUser = usuarios.getUser(userId);
		
		// Si el usuario esta en la lista de usuarios
		if(currentUser!=null) {
			
			System.out.println("Ingrese el codigo ISBN del libro que desea devolver:");
			
			String libroISBN = stdIn.nextLine();
			Libro currentLibro = biblioteca.getLibro(libroISBN);
			
			if(currentLibro!=null) {
				// ACA GESTIONAR ENTREGA DE LIBRO
			}
			else {
				System.out.println("El usuario no poseia el libro a devolver.");
			}
			
			
		}
		else {
			System.out.println("El usuario solicitado no existe. Volviendo a menu.");
		}
		
		
		
		
	}
	
	
	
	
	
}
