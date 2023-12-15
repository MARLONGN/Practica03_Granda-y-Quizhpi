package Idao;

import java.util.List;

import Modelo.Libro;

public interface ILibroDao {
	List<Libro> obtenerLibro();
    Libro obtenerLibro(String titulo);
    void crearLibro(Libro libro);
    boolean actualizarLibro(String autor, String libro);
    boolean eliminarLibro(String titulo);

}
