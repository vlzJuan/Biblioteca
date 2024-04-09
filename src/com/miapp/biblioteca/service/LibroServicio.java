package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

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
	public void agregarLibro(String titulo, String autor,
							String ISBN, String genero) {
		
		Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
		inventario.add(nuevoLibro);	
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
	public ArrayList<Libro> getInventario(){
		return inventario;
	}
	
	/**
	 * Metodo que permite identificar un libro mediante el ISBN y reescribir sus otros
	 * atributos (excepto disponibilidad). 
	 * 
	 * Si un parametro es "", ese parametro no sera modificado por esta funcion. 
	 * 
	 * La verificacion de que modificar un libro no sobreescriba otro por accidente se hace
	 * antes de invocar a esta funcion.
	 * 
	 * Si el libro esta prestado, no podra modificarse el libro.
	 * 
	 * // NOTA: Desde el punto de vista de programacion, se podria. Pero si yo tengo el libro
	 * // 'Fisica 1' prestado, modificarlo a 'Matematica 3' en el inventario no cambia el
	 * // libro que yo tengo en mis manos. Y no podria devolverlo. Por eso, hago esta
	 * // consideracion para evitar modificar libros prestados.
	 * 
	 * @param ISBN			, el ISBN del libro a modificar.
	 * @param nuevoISBN		, el nuevo ISBN del libro que se esta modificando	
	 * @param nuevoTitulo	, el nuevo titulo del libro que se esta modificando
	 * @param nuevoAutor	, el nuevo autor del libro que se esta modificando
	 * @param nuevoGenero	, el nuevo genero del libro que se esta modificando.
	 * 
	 * @return 'true'	, si se pudo modificar el libro solicitado (incluso aunque todos los
	 * 					parametros nuevos hayan sido "").
	 * @return 'false'	, si el libro estaba prestado.
	 * 
	 */
	public boolean actualizarLibro(String ISBN, String nuevoISBN, String nuevoTitulo, 
								String nuevoAutor, String nuevoGenero) {
		
		boolean operacionRealizada = false;
		
		for(Libro book : inventario) {
			// Si encontre el libro con el ISBN inicial, entro aca y empiezo a analizar.
			if(book.getISBN().equals(ISBN)) {	
				// Si el libro estaba disponible, lo puedo modificar.
				if(book.getDisponible()==true) {
					
					// Para cada parametro, 
					// lo modifico si no le pase una cadena vacia como nuevo parametro.
					
					if(!nuevoISBN.equals("")) 
						book.setISBN(nuevoISBN);
					
					if(!nuevoTitulo.equals(nuevoTitulo))
						book.setTitulo(nuevoTitulo);
					
					if(!nuevoAutor.equals(""))
						book.setAutor(nuevoAutor);
					
					if(!nuevoGenero.equals(""))
						book.setGenero(nuevoGenero);
					
					// Cuando terminé con esta asignacion, afirmo que realice la operacion
					// y devuelvo true con la funcion.
					operacionRealizada = true;
				}
			}
		}
		
		return operacionRealizada;
		
	}
	

	/** getLibro(String libroISBN)
	 * Metodo que retorna el objeto libro que se busca, si esta en inventario.
	 * @param libroISBN	, el identificador ISBN del libro.
	 * @return	'null' si el libro no se encontro, o el objeto libro si se lo encontro.
	 */
	public Libro getLibro(String libroISBN) {

		Libro currentLibro = null;
		for(Libro book:inventario) {
			if(book.getISBN().equals(libroISBN)) {
				currentLibro=book;
				break;
			}
		}
		return currentLibro;
	}
	
	/**
	 * Metodo usado para prestar un libro a un usuario. Es boolean porque permite identificar
	 * si el libro esta disponible y y el usuario es correcto.
	 * @param book
	 * @param usuarios
	 * @param user
	 * @return
	 */
	public boolean prestarLibro(Libro book , Usuario user) {
		
		boolean operacionRealizada = false;
		
		if(book.getDisponible()==true && user!=null) {
			book.setDisponible(false);
			UsuarioServicio.recibeLibro(user, book);
			operacionRealizada = true;
			
		}
		
		return operacionRealizada;
	}
	
	/**
	 * 
	 */
	public boolean aceptarDevolucionLibro(Libro book,
											Usuario user) {
		
		boolean operacionRealizada = false;
		
		if(book.getDisponible()==false && user!=null) {
			// Si el usuario tiene el libro,
			if(user.getLibrosPrestados().contains(book)) {
				book.setDisponible(true);
				UsuarioServicio.devuelveLibro(user, book);
				operacionRealizada = true;
			}
		}
		
		return operacionRealizada;
	}
	
	/**
	 * Metodo utilizado para mostrar los libros disponibles en sistema.
	 */
	public void mostrarInventario() {
		System.out.println("\nLos libros registrados en la biblioteca son:");
		for(Libro book:inventario) {
			System.out.println(book.toString());
		}
		System.out.println("");
	}
	
	
	
		
}
