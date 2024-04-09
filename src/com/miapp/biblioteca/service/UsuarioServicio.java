package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;


public class UsuarioServicio {

	private ArrayList<Usuario> userList;
	
	/**
	 * Constructores que inicializan la lista de usuarios.
	 */
	public UsuarioServicio(ArrayList<Usuario> userList) {
		this.userList = userList;
	}
	public UsuarioServicio() {
		
	}
	
	public void crearUsuario(String nombre, String id) {
		
		Usuario nuevoUsuario = new Usuario(nombre,id);
		userList.add(nuevoUsuario);
	}
	
	/**
	 * Getter para la lista de usuarios:
	 */
	public ArrayList<Usuario> getListaUsuarios(){
		return userList;
	}
	
	/**
	 * Setter para actualizar un usuario, basado en su id:
	 * TODO : DOCUMENTAR ESTO MEJOR.
	 */
	public void updateUsuario(String oldId, String nuevoId, String nuevoNombre) {
		
		for(Usuario user: userList) {
			if(user.getId().equals(oldId)) {
				
				if(!nuevoId.equals(""))
					user.setId(nuevoId);
				
				if(!nuevoNombre.equals(""))
					user.setNombre(nuevoNombre);
				
				break;
			}
		}
	}
	
	/**
	 * Metodo para eliminar un usuario de la lista de usuarios.
	 */
	public void eliminarUsuario(String id) {
		
		Iterator <Usuario> it = userList.iterator();
		
		while(it.hasNext()) {
			if(it.next().getId().equals(id)) {
				it.remove();
			}
		}
	}
	
	/**
	 * Metodo que retorna el usuario con el Id parametro, si esta en la lista.
	 * @param userId	, el identificador de usuario.
	 * @return 'null'	, si el usuario no esta en la lista.
	 * @return 			, la instancia de Usuario que coincide con el Id dado
	 */
	public Usuario getUser(String userId) {
		
		Usuario currentUser = null;
		for(Usuario user:this.userList) {
			if(user.getId().equals(userId)) {
				currentUser = user;
			}
		}
		return currentUser;
	}
	
	/**
	 * Metodo que le agrega a un usuario un libro, en su lista de libros en posesion.
	 * NO VERIFICA que el libro este prestado. De eso se encarga la biblioteca.
	 * @param user
	 * @param book
	 */
	public static void recibeLibro(Usuario user, Libro book) {
		user.addLibro(book);
	}
	/**
	 * Metodo que remueve el libro de un usuario, si lo tiene en su posesion.
	 * NO VERIFICA que el libro este entre sus prestados. De eso se encarga la biblioteca.
	 */
	public static void devuelveLibro(Usuario user, Libro book) {
		user.removeLibro(book);
	}
	
	/**
	 * Metodo que muestra los libros que un usuario tiene prestados.
	 * 
	 */
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
