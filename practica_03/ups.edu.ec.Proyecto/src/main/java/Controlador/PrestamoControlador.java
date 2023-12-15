package Controlador;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Dao.LibroDao;
import Idao.ILibroDao;
import Idao.IPrestamoDao;
import Idao.IUsuarioDao;
import Modelo.Libro;
import Modelo.Prestamo;
import Modelo.Usuario;
import Vista.LibroVista;
import Vista.PrestamoVista;
import Vista.UsuarioVista;

public class PrestamoControlador {

    private ILibroDao libroDao;
    private LibroDao libro;
    private LibroVista libroVista;
    private IUsuarioDao usuarioDao;
    private Usuario usuario;
    private UsuarioVista usuarioVista;
    private IPrestamoDao prestamoDao;
    private PrestamoVista prestamoVista;

    public PrestamoControlador(ILibroDao libroDao, IUsuarioDao usuarioDao, IPrestamoDao prestamoDao, PrestamoVista prestamoVista) {
        this.libroDao = libroDao;
        this.usuarioDao = usuarioDao;
        this.prestamoDao = prestamoDao;
        this.prestamoVista = prestamoVista;
    }

    public void crearPrestamo() {
        Prestamo prestamo = prestamoVista.ingresarDatosPrestamo(libroDao, usuarioDao);
        if (prestamo != null) {
            prestamoDao.crearPrestamo(prestamo);
            prestamoVista.mostrarAlertas("Préstamo creado exitosamente");
        } else {
            prestamoVista.mostrarAlertas("No se pudo crear el préstamo");
        }
    }

    public void actualizarPrestamo() {
        int identificacionUsuario = prestamoVista.actualizarDatosPrestamo();
        Usuario usuario = usuarioDao.obtenerUsuario(identificacionUsuario);
        if (usuario != null) {
            List<Prestamo> prestamosUsuario = prestamoDao.obtenerPrestamosPorUsuario(usuario);
            prestamoVista.mostrarInformacionPrestamos(prestamosUsuario);

            if (!prestamosUsuario.isEmpty()) {
                System.out.println("Ingrese el título del libro a devolver:");
                String tituloLibro = prestamoVista.entrada.next();
                Libro libro = libroDao.obtenerLibro(tituloLibro);

                Prestamo prestamo = new Prestamo(libro, usuario, prestamosUsuario.get(0).getFechaPrestamo(), new Date());
                if (prestamoDao.actualizarPedido(identificacionUsuario, prestamo)) {
                    prestamoVista.mostrarAlertas("Préstamo actualizado exitosamente");
                } else {
                    prestamoVista.mostrarAlertas("No se pudo actualizar el préstamo");
                }
            }
        } else {
            prestamoVista.mostrarAlertas("Usuario no encontrado");
        }
    }

    private Prestamo obtenerPrestamoVigente(Usuario usuario) {
        return prestamoDao.obtenerPrestamo(usuario);
    }
}

