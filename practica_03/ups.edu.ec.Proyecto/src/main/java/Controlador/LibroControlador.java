package Controlador;

import java.util.List;

import Idao.ILibroDao;
import Modelo.Libro;
import Vista.LibroVista;

public class LibroControlador {

    private ILibroDao libroDao;
    private LibroVista libroVista;
    private Libro libro;

    public LibroControlador(ILibroDao libroDao, LibroVista libroVista, Libro libro) {
        this.libroDao = libroDao;
        this.libroVista = libroVista;
        this.libro = libro;
    }

    public void crearLibro() {
        libro = libroVista.ingresarDatosLibro();
        libroDao.crearLibro(libro);
    }

    public void actualizarLibro() {
        libro = libroVista.actualizarDatosLibro();
        if (libroDao.actualizarLibro(libro.getAutor(), libro.getTitulo())) {
            libroVista.mostrarAlertas("Libro actualizado");
        } else {
            libroVista.mostrarAlertas("Ha ocurrido un error");
        }
    }

    public void eliminarLibro() {
        String titulo = libroVista.eliminarDatosLibro();
        if (libroDao.eliminarLibro(titulo)) {
            libroVista.mostrarAlertas("Libro Eliminado");
        } else {
            libroVista.mostrarAlertas("Ha ocurrido un error");
        }
    }

    public void buscarLibroPorTitulo() {
        String titulo = libroVista.buscarDatosLibro();
        libro = libroDao.obtenerLibro(titulo);
        if (libro == null) {
            libroVista.mostrarAlertas("Libro no encontrado");
        } else {
            libroVista.mostrarInformacionProducto(libro.getTitulo(), libro.getAutor(), libro.getAño());
        }
    }

    public void listarLibros() {
        List<Libro> listaLibros = libroDao.obtenerLibro();
        for (Libro libro : listaLibros) {
        	libroVista.mostrarInformacionProducto(libro.getTitulo(), libro.getAutor(), libro.getAño());
    }
}
    }

