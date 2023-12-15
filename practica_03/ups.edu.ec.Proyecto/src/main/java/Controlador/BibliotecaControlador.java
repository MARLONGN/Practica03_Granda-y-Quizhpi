package Controlador;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.BibliotecaDao;
import Idao.IBibliotecaDao;
import Modelo.Biblioteca;
import Vista.BibliotecaVista;

import java.util.List;

public class BibliotecaControlador {

    private IBibliotecaDao bibliotecaDao;
    private Biblioteca bliblioteca;
    private BibliotecaDao biblio;
    private BibliotecaVista bibliotecaVista;

    public BibliotecaControlador(IBibliotecaDao bibliotecaDao, BibliotecaVista bibliotecaVista) {
        this.bibliotecaDao = bibliotecaDao;
        this.bibliotecaVista = bibliotecaVista;
    }

    public void crearBiblioteca() {
        Biblioteca biblioteca = bibliotecaVista.ingresarDatosDeBiblioteca();
        if (biblioteca != null) {
            bibliotecaDao.crearBiblioteca(biblioteca);
            bibliotecaVista.mostrarAlertas("Biblioteca creada exitosamente");
        } else {
            bibliotecaVista.mostrarAlertas("No se pudo crear la biblioteca");
        }
    }

    public void actualizarBiblioteca() {
        String nombreBiblioteca = bibliotecaVista.actualizarDatosDeBiblioteca();
        Biblioteca biblioteca = bibliotecaDao.obtenerBiblioteca(nombreBiblioteca);
        if (biblioteca != null) {
            String nuevaBiblioteca = bibliotecaVista.actualizarDatosDeBiblioteca();
            if (bibliotecaDao.actualizarBiblioteca(nombreBiblioteca, nuevaBiblioteca)) {
                bibliotecaVista.mostrarAlertas("Biblioteca actualizada exitosamente");
            } else {
                bibliotecaVista.mostrarAlertas("No se pudo actualizar la biblioteca");
            }
        } else {
            bibliotecaVista.mostrarAlertas("Biblioteca no encontrada");
        }
    }



    public void eliminarBiblioteca() {
        String nombreBiblioteca = bibliotecaVista.eliminarDatosProducto();
        Biblioteca biblioteca = bibliotecaDao.obtenerBiblioteca(nombreBiblioteca);
        if (biblioteca != null) {
            if (bibliotecaDao.eliminarBiblioteca(nombreBiblioteca)) {
                bibliotecaVista.mostrarAlertas("Biblioteca eliminada exitosamente");
            } else {
                bibliotecaVista.mostrarAlertas("No se pudo eliminar la biblioteca");
            }
        } else {
            bibliotecaVista.mostrarAlertas("Biblioteca no encontrada");
        }
    }

    public void buscarBiblioteca() {
        String nombreBiblioteca = bibliotecaVista.buscarDatosDeBiblioteca();
        String direccionBiblioteca = bibliotecaVista.buscarDatosDeBiblioteca();
        Biblioteca biblioteca = bibliotecaDao.obtenerBiblioteca(nombreBiblioteca);
        if (biblioteca != null) {
            bibliotecaVista.mostrarInformacionBiblioteca(nombreBiblioteca, direccionBiblioteca);
        } else {
            bibliotecaVista.mostrarAlertas("Biblioteca no encontrada");
        }
    }

}

