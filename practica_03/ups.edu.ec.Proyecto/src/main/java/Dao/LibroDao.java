package Dao;

import java.util.ArrayList;
import java.util.List;

import Idao.ILibroDao;
import Modelo.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroDao implements ILibroDao {

    private List<Libro> listaLibros;

    public LibroDao() {
        listaLibros = new ArrayList<>();
    }

    @Override
    public List<Libro> obtenerLibro() {
        return listaLibros;
    }

    @Override
    public Libro obtenerLibro(String titulo) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public void crearLibro(Libro libro) {
        listaLibros.add(libro);
    }

    @Override
    public boolean actualizarLibro(String titulo, String nuevoTitulo) {
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro l = listaLibros.get(i);
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                l.setTitulo(nuevoTitulo);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean eliminarLibro(String titulo) {
        Libro libroAEliminar = null;
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(libroAEliminar.getTitulo())) {
                libroAEliminar = libro;
                break;
            }
        }
        if (libroAEliminar != null) {
            listaLibros.remove(libroAEliminar);
            return true;
        }
        return false;
    }
}
