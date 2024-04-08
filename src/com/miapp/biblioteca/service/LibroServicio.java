package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;

public class LibroServicio {

	/**
	 * Atributos:
	 * -inventario: 		Lista interna que guarda todos los libros registrados en la 
	 * 						biblioteca.
	 */
	private ArrayList<Libro> inventario;	// Inventario de biblioteca.	
	
	/**
	 * Constructores que inicializan la biblioteca.
	 * @param biblioteca , una lista de Libro-s que inicia el inventario inicial.
	 */
	public LibroServicio(ArrayList<Libro> inventario) {
		this.inventario = inventario;
	}
	public LibroServicio() {
		
	}
	
	
	/**
	 * Metodo para crear un nuevo libro y almacenarlo
	 * en la biblioteca.
	 * @param titulo, el titulo del libro
	 * @param autor	, el autor del libro
	 * @param ISBN	, el codigo ISBN del libro
	 * @param genero, el genero de literatura del libro.
	 */
	public void crearLibro(String titulo, String autor,
							String ISBN, String genero) {
		
		Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
		this.inventario.add(nuevoLibro);	
	}
	
	/**
	 * Metodo para eliminar un libro del inventario de biblioteca:
	 */
	public void eliminarLibro(String ISBN) {
		
		Iterator<Libro> it = inventario.iterator();
		
		// Recorro la biblioteca hasta hallar el libro del ISBN,
		// y lo elimino si lo encuentro.
		while(it.hasNext()) {
			if(it.next().getISBN().equals(ISBN)) {	// Si encontre el libro con ese ISBN,
				it.remove();						// lo elimino de la lista de libros.
			}
		}	
	}
	
	/**
	 * Metodo getter para la lista de libros en inventario.
	 * @return La lista de libros que en inventario.
	 */
	public ArrayList<Libro> obtenerInventario(){
		return inventario;
	}
	
	/**
	 * Metodo que permite identificar un libro mediante el ISBN y reescribir sus otros
	 * atributos (excepto disponibilidad).
	 * @param ISBN
	 * @param newTitulo
	 * @param newAutor
	 * @param newGenero
	 */
	public void actualizarLibro(String ISBN, String newTitulo, String newAutor, String newGenero) {
		for(Libro book : this.inventario) {
			if(book.getISBN().equals(ISBN)) {	
				book.setTitulo(newTitulo);
				book.setAutor(newAutor);
				book.setGenero(newGenero);
			}
		}
	}
	

	/**
	 * Metodo que determina si el libro que se solicita esta disponible dentro del
	 * inventario de libros de la biblioteca.
	 * @param 	ISBN	, el codigo ISBN del libro solicitado.
	 * @return	'true' , si el libro esta en inventario Y esta disponible.
	 * 			'false', otherwise.
	 */
	public boolean libroDisponible(String ISBN) {
		
		boolean disponible = false;
		
		for(Libro book:inventario) {
			if(book.getISBN().equals(ISBN)) {
				disponible=book.getDisponible();
				break;
			}
		}
		return disponible;
	}
	
	/**
	 * Metodo para devolver un libro por ISBN.
	 * 
	 * 
	 */
	public void devolverLibro(String libroISBN) {
		
		for(Libro book:inventario) {
			if(book.getISBN().equals(libroISBN)) {
				book.setDisponible(true);
			}
		}
		
		
	}
	
	
	
	
	

	
	
	/**
	 * Metodo que itera sobre el inventario de libros y determina si hay
	 * libros disponibles para prestar.
	 * @return	'true' si hay libros disponibles,
	 * 			'false' otherwise.
	 */
	public boolean hayLibrosDisponibles() {
		
		// Variable de retorno. Inicia asumiendo que no hay libros disponibles.
		boolean hayDisponibles = false;
		
		// Para cada libro en el inventario, veo si hay alguno disponible.
		// Si al menos uno cumple, devuelvo que hay disponibles. El break es por
		// eficiencia, para no seguir iterando tras saber que hay libros para prestar.
		for(Libro book:inventario) {
			if(book.getDisponible()==true) {
				hayDisponibles = true;
				break;
			}
		}
		
		return hayDisponibles;
	}
	
	
	

	
	
	

	
		
}
