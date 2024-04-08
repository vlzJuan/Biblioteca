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
	public void recibeLibro(Usuario user, Libro book) {
		
		user.addLibro(book);
		
		
	}
	
	
	
	
}
