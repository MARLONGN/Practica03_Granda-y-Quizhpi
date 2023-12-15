package Dao;


import java.util.List;

import Idao.IBibliotecaDao;
import Modelo.Biblioteca;
import Modelo.Libro;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDao implements IBibliotecaDao {

    private List<Biblioteca> listaBibliotecas;

    public BibliotecaDao() {
        listaBibliotecas = new ArrayList<>();
    }

    @Override
    public List<Biblioteca> obtenerBibliotecas() {
        return listaBibliotecas;
    }

    @Override
    public Biblioteca obtenerBiblioteca(String nombre) {
        for (Biblioteca biblioteca : listaBibliotecas) {
            if (biblioteca.getNombre().equalsIgnoreCase(nombre)) {
                return biblioteca;
            }
        }
        return null;
    }

    @Override
    public void crearBiblioteca(Biblioteca biblioteca) {
        listaBibliotecas.add(biblioteca);
    }

    @Override
    public boolean actualizarBiblioteca(String nombre, String nuevoNombre) {
        for (int i = 0; i < listaBibliotecas.size(); i++) {
            Biblioteca b = listaBibliotecas.get(i);
            if (b.getNombre().equalsIgnoreCase(nombre)) {
                Biblioteca bibliotecaActualizada = new Biblioteca(nuevoNombre, b.getDireccion());
                listaBibliotecas.set(i, bibliotecaActualizada);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean eliminarBiblioteca(String nombre) {
        Biblioteca bibliotecaAEliminar = null;
        for (Biblioteca biblioteca : listaBibliotecas) {
            if (biblioteca.getNombre().equalsIgnoreCase(nombre)) {
                bibliotecaAEliminar = biblioteca;
                break;
            }
        }
        if (bibliotecaAEliminar != null) {
            listaBibliotecas.remove(bibliotecaAEliminar);
            return true;
        }
        return false;
    }
}

