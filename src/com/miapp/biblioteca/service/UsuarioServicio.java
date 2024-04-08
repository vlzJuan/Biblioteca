package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Usuario;


public class UsuarioServicio {

	private ArrayList<Usuario> usuarios;
	
	/**
	 * Constructor con lista de usuarios como parametro.
	 */
	public UsuarioServicio(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void crearUsuario(String nombre, String id) {
		
		Usuario nuevoUsuario = new Usuario(nombre,id);
		usuarios.add(nuevoUsuario);
	}
	
	/**
	 * Getter para la lista de usuarios:
	 */
	public ArrayList<Usuario> getListaUsuarios(){
		return usuarios;
	}
	
	/**
	 * Setter para actualizar un usuario, basado en su id:
	 */
	public void updateUsuario(String id, String nuevoNombre) {
		
		for(Usuario user: usuarios) {
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
		
		Iterator <Usuario> it = usuarios.iterator();
		
		while(it.hasNext()) {
			if(it.next().getId().equals(id)) {
				it.remove();
			}
		}
		
		
	}
	
	
	
}
