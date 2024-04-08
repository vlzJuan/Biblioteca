package com.miapp.biblioteca.ui;

import java.util.Scanner;

import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;

public class MenuDevolverLibro {

	
	public static void devolverLibro(Scanner stdIn, LibroServicio biblioteca,
										UsuarioServicio usuarios) {
		
		System.out.println("Ingresar id de usuario");
		String userId = stdIn.nextLine();
		
		if(usuarios.usuarioExiste(userId)) {
			
			System.out.println("Ingrese el codigo ISBN del libro que desea devolver:");
			
			String libroISBN = stdIn.nextLine();
			
			if(usuarios.usuarioDevuelveLibro(biblioteca,userId,libroISBN)) {
				System.out.println("El usuario "+ userId + " devolvio el libro "
						+ libroISBN + " con exito.");
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
