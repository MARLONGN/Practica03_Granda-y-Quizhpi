package Idao;

import java.util.ArrayList;

import Modelo.Biblioteca;
import Modelo.Libro;
import Modelo.Usuario;
import java.util.List;

import java.util.List;

public interface IBibliotecaDao {
    List<Biblioteca> obtenerBibliotecas();
    Biblioteca obtenerBiblioteca(String nombreBiblioteca);
    void crearBiblioteca(Biblioteca biblioteca);
    boolean actualizarBiblioteca(String nombre, String biblioteca);
    boolean eliminarBiblioteca(String nombre);
}


