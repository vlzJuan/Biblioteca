package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;

public class LibroServicio {

	/**
	 * Atributos:
	 * -biblioteca: Parametro interno que guarda los libros en biblioteca.
	 */
	private ArrayList<Libro> biblioteca; // Inventario de biblioteca.
	
	/**
	 * Constructor que inicializa la biblioteca.
	 * @param biblioteca , una lista de Libro-s que inicia el inventario inicial.
	 */
	public LibroServicio(ArrayList<Libro> biblioteca) {
		this.biblioteca = biblioteca;
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
		this.biblioteca.add(nuevoLibro);
		
	}
	
	public ArrayList<Libro> obtenerInventario(){
		return biblioteca;
	}
	
	public void actualizarLibro(String ISBN, String newTitulo, String newAutor, String newGenero) {
		for(Libro book : this.biblioteca) {
			if(book.getISBN().equals(ISBN)) {	
				book.setTitulo(newTitulo);
				book.setAutor(newAutor);
				book.setGenero(newGenero);
			}
		}
	}
	
	
	/**
	 * Metodo para eliminar un libro del inventario de biblioteca:
	 */
	public void eliminarLibro(String ISBN) {
		
		Iterator<Libro> it = biblioteca.iterator();
		
		// Recorro la biblioteca hasta hallar el libro del ISBN,
		// y lo elimino si lo encuentro.
		while(it.hasNext()) {
			if(it.next().getISBN().equals(ISBN)) {	// Si encontre el libro con ese ISBN,
				it.remove();						// lo elimino de la lista de libros.
			}
		}
		
		
	}
	
	
	/* Comento todo esto porque seguro va en el package de UI.
	public void mostrarInventario() {
		// Si la biblioteca no esta vacia,
		if(!this.biblioteca.isEmpty()) {
			System.out.println("Los libros disponibles son:");
			for(Libro book:this.biblioteca) {
				System.out.println(book.toString());
			}
		}
		else {
			System.out.println("La biblioteca esta vacia. No hay libros disponibles.");
		}

	}*/
	
		
}
