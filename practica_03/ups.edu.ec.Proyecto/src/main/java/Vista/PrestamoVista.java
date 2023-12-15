package Vista;

import java.util.Date;
import java.util.Scanner;

import Idao.ILibroDao;
import Idao.IUsuarioDao;
import Modelo.Libro;
import Modelo.Prestamo;
import Modelo.Usuario;

import Idao.ILibroDao;
import Idao.IUsuarioDao;
import Modelo.Libro;
import Modelo.Prestamo;
import Modelo.Usuario;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrestamoVista {
    public Scanner entrada = new Scanner(System.in);

    public Prestamo ingresarDatosPrestamo(ILibroDao libroDao, IUsuarioDao usuarioDao) {
        System.out.println("------Ingreso de Nuevo Préstamo------");

        System.out.println("Ingresa el título del libro:");
        String tituloLibro = entrada.next();
        Libro libro = libroDao.obtenerLibro(tituloLibro);
        if (libro == null) {
            System.out.println("Libro no encontrado. Verifica el título.");
            return null;
        }

        System.out.println("Ingresa la identificación del usuario:");
        String identificacionUsuario = entrada.next();
        Usuario usuario = usuarioDao.obtenerUsuario(Integer.parseInt(identificacionUsuario));
        if (usuario == null) {
            System.out.println("Usuario no encontrado. Verifica la identificación.");
            return null;
        }

        return new Prestamo(libro, usuario, new Date(), null);
    }

    public void mostrarInformacionPrestamo(Prestamo prestamo) {
        if (prestamo != null) {
            System.out.println("Datos del Préstamo:");
            System.out.println("Libro: " + prestamo.getLibro().getTitulo());
            System.out.println("Usuario: " + prestamo.getUsuario().getIdentificacion());
            System.out.println("Fecha de Préstamo: " + prestamo.getFechaPrestamo());
            System.out.println("Fecha de Devolución: " + prestamo.getFechaDevolucion());
        }
    }

    public void mostrarAlertas(String mensaje) {
        System.out.println(mensaje);
    }

    public int actualizarDatosPrestamo() {
        System.out.println("------Actualizar Préstamo------");
        System.out.println("Ingresa la identificación del usuario:");
        return entrada.nextInt();
    }

    public void mostrarInformacionPrestamos(List<Prestamo> prestamos) {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos para mostrar.");
        } else {
            System.out.println("Lista de Préstamos:");
            for (Prestamo prestamo : prestamos) {
                System.out.println("Libro: " + prestamo.getLibro().getTitulo() +
                        ", Usuario: " + prestamo.getUsuario().getIdentificacion() +
                        ", Fecha de Préstamo: " + prestamo.getFechaPrestamo() +
                        ", Fecha de Devolución: " + prestamo.getFechaDevolucion());
            }
        }
    }
}
