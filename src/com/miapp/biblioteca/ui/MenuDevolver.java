package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.Scanner;

import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;


public class MenuDevolver {

	
	public static void devolverLibro(Scanner stdIn, LibroServicio biblioteca,
										UsuarioServicio usuarios) {
		
		System.out.println("Ingresar el ISBN del libro que se quiere devolver.");
		String libroISBN = stdIn.nextLine();
		Libro currentLibro = biblioteca.getLibro(libroISBN);
		
		if(currentLibro!=null) {
			
			System.out.println("Ingrese el Id del usuario que lo tiene.");
			
			String userId = stdIn.nextLine();
			Usuario currentUser = usuarios.getUser(userId);
			
			if(biblioteca.aceptarDevolucionLibro(currentLibro,usuarios, currentUser)) {
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
