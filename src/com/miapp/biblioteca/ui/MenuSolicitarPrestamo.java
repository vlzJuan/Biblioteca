package com.miapp.biblioteca.ui;

import java.util.Scanner;
import com.miapp.biblioteca.*;
import com.miapp.biblioteca.service.*;


public class MenuSolicitarPrestamo {
	
	// Menu principal de solicitar un prestamo de libro.
	public void menuPrestamo(Scanner stdIn, LibroServicio biblioteca, 
									UsuarioServicio usuarios) {
		
		System.out.println("Ingrese el codigo ISBN del libro a solicitar:");
		String libroISBN = stdIn.nextLine();
		
		if(biblioteca.seleccionarLibro(libroISBN)==true) {
			
			// ACA IMPLEMENTAR SOLICITUD DE USUARIO PARA PRESTAMO.
			
		}
		else {
			System.out.println("El libro solicitado no esta registrado en la biblioteca.");
		}
		
	}
	
	
	
	
	
	
	

}
