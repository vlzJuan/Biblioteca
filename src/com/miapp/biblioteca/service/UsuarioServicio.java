package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Usuario;


public class UsuarioServicio {

	private ArrayList<Usuario> userList;
	
	/**
	 * Constructor con lista de usuarios como parametro.
	 */
	public UsuarioServicio(ArrayList<Usuario> userList) {
		this.userList = userList;
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
	
	
}
