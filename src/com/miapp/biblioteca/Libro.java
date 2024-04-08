package com.miapp.biblioteca;


/**
 * Clase Libro:
 * Creada para instanciar los libros que existen en la biblioteca.
 */
public class Libro {

	/**
	 * Declaro los atributos de un libro:
	 */
	private String titulo;
	private String autor;
	private String ISBN;
	private String genero;
	private boolean disponible;
	
	// Metodo constructor:
	// Inicializo con todos los parametros pasados como dato, y asumo que el libro
	// inicia disponible para ser retirado.
	public Libro(String titulo, String autor, String ISBN, String genero) {
		
		this.titulo=titulo;
		this.autor=autor;
		this.ISBN=ISBN;
		this.genero=genero;
		this.disponible = true;
		
	}
	
	// Constructor sin parametros
	public Libro() {
		
	}
	
	// Metodos getter:
	// La convencion de nombres que uso es 'get'+(Atributo), camelCased.
	// El unico que no lo sigue es el correspondiente a disponible, que 
	// se llama 'isAvailable' (TL: 'estaDisponible').
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getISBN() {
		return ISBN;
	}
	public String getGenero() {
		return genero;
	}
	public boolean getDisponible() {
		return disponible;
	}
	
	// Metodos setter:
	// Sigo la misma convencion de nombres que en getter, con prefijo 'set'.
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setISBN (String ISBN) {
		this.ISBN = ISBN;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	// Sobreescribo el toString por defecto, para mostrar el libro en el
	// formato que quiero mostrarlo.
	@Override
	public String toString() {
		return "Libro:\tTitulo = " + this.titulo + "\n\t\t"
				+ "Autor = " + this.autor + "\n\t\t"
				+ "ISBN = " + this.ISBN + "\n\t\t"
				+ "Genero = " + this.genero + "\n\t\t"
				+ "Disponible = " + this.disponible;
	}
}
