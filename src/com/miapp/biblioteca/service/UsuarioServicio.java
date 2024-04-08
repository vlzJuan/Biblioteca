package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

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
	 */
	public void updateUsuario(String id, String nuevoNombre) {
		
		for(Usuario user: userList) {
			if(user.getId().equals(id)) {
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
	
	
	public boolean usuarioExiste(String userId) {
		
		boolean registrado = false;
		for(Usuario user:userList) {
			if(user.getId().equals(userId)) {
				registrado = true;
				break;
			}
		}
		
		return registrado;
		
	}
	
	/**
	 * Metodo que indica si un usuario tiene un libro en posesion.
	 * @param userId	, identificador del usuario.
	 * @param libroISBN	, ISBN del libro a devolver.
	 * @return 'true'	, si el usuario existe y el libro existe en su lista de libros
	 * 					que tiene prestados.
	 * @return 'false'	, si el libro no esta en la lista de libros prestados al usuario.
	 */
	public boolean usuarioDevuelveLibro(LibroServicio biblioteca, 
									String userId, String libroISBN) {
		
		boolean devolvioLibro=false;
		
		for(Usuario user:userList) {
			// Verifica si el usuario existe. If so, entra al if.
			if(user.getId().equals(userId)) {
				// Verifica que el usuario tenga ese libro. Si lo tiene, lo devuelve.
				
				Iterator <Libro> it = user.getLibrosPrestados().iterator();
				
				while(it.hasNext()) {
					if(it.next().getISBN().equals(libroISBN)) {
						
						biblioteca.devolverLibro(libroISBN);
						it.remove();
						devolvioLibro = true;
						break;
					}
				}
			}
		}
		
		return devolvioLibro;
		
	}
	
	
	
	
}
