package com.miapp.biblioteca;

import java.util.ArrayList;

/**
 * Clase Usuario:
 * Clase creada para instanciar usuarios de la biblioteca.
 */
public class Usuario{
	
	//Atributos
	private String nombre;
	private String id;
	private ArrayList<Libro> librosPrestados;
	
	/**
	 * Constructor con parametros, para instanciar un nuevo usuario.
	 */
	public Usuario(String nombre, String id) {
		
		this.nombre = nombre;
		this.id = id;
		this.librosPrestados = new ArrayList<>();
		
	}

	/**
	 * Metodos getter:
	 */
	public String getNombre() {
		return this.nombre;
	}
	public String getId() {
		return this.id;
	}
	public ArrayList<Libro> getLibrosPrestados() {
		return this.librosPrestados;
	}
	
	/**
	 * Metodos setter:
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// Sobreescribo el toString por defecto, para mostrar el usuario en el
	// formato que quiero mostrarlo.
	@Override
	public String toString() {
		return "Usuario:\tNombre = " + this.nombre + "\n\t\t\t"
				+ "Id = " + this.id;

	}
	
	/**
	 * Metodos para interactuar con la lista de libros:
	 * Retornan true si se pudo realizar la accion solicitada.
	 */
	public boolean addLibro(Libro book) {
		boolean agregado = false;
		
		if(!this.librosPrestados.contains(book)) {
			this.librosPrestados.add(book);
			agregado = true;
		}
		return agregado;
	}
	public boolean removeLibro(Libro book) {
		
		boolean removido = false;
		
		if(this.librosPrestados.contains(book)) {
			this.librosPrestados.remove(book);
			removido = true;
		}
		
		return removido;
	}
	
	
}
