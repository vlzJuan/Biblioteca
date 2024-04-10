# Biblioteca
 Proyecto de Alkemy Labs para el curso de desarrollo en Java.

## Mini-manual de usuario:

Este programa simulara el control de prestamo de libros para una biblioteca. En este proyecto, usted
interactuara por consola con el sistema.

### Clases definidas para este proposito:
- Libro : Clase que permite instanciar libros del inventario de la biblioteca.
-- Atributos: Titulo, Autor, ISBN, Genero, Disponibilidad.
- Usuario: Clase que permitira instanciar usuarios del sistema.
-- Atributos: Nombre, Id, [Libros prestados].

### Clases definidas para la manipulacion de los objetos:
- LibroServicio : Clase que permite instanciar una biblioteca, con su inventario de libros y metodos
para manipular Libros.
- UsuarioServicio : Clase que permite instanciar una coleccion de usuarios registrados al sistema.

### Clases definidas para la interaccion con el usuario:
- Main : Punto de entrada del programa
- MenuPrincipal: Menu inicial del programa, accede a la funcionalidad de solicitar y devolver libros, 
y a otros menus dedicados a funcionalidades mas complejas.
- MenuBuscarLibro : Menu dedicado a la busqueda de un libro en inventario.
- MenuAdministrarCatalogo : Menu dedicado a administrar el inventario de la biblioteca.
Incluye funciones como agregar, modificar y eliminar libros, y mostrar el catalogo.

##

## Menu principal
El menu principal posee las siguientes opciones:

1. Solicitar el prestamo de un libro.   
- Permite a un usuario solicitar el prestamo de un libro.
2. Devolver un libro
- Permite a un usuario devolver un libro entre los que tiene prestados.
3. Ver catalogo de libros   
- Permite mostrar el catalogo de libros disponible actualmente.
4. Administrar catalogo 
- Agrega o quita libros del catalogo.
0. Salir
-Permite terminar la operacion del programa de catalogo.