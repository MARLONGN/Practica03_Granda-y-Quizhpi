package Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Idao.IPrestamoDao;
import Modelo.Prestamo;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrestamoDao implements IPrestamoDao {

    private List<Prestamo> listaPrestamos;

    public PrestamoDao() {
        listaPrestamos = new ArrayList<>();
    }

    @Override
    public List<Prestamo> obtenerPrestamo() {
        return listaPrestamos;
    }

    @Override
    public List<Prestamo> obtenerPrestamosPorUsuario(Usuario usuario) {
        List<Prestamo> prestamosUsuario = new ArrayList<>();
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getUsuario().equals(usuario)) {
                prestamosUsuario.add(prestamo);
            }
        }
        return prestamosUsuario;
    }

    @Override
    public List<Prestamo> obtenerPedidosPorFecha(Date fecha) {
        List<Prestamo> prestamosPorFecha = new ArrayList<>();
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getFechaPrestamo().equals(fecha)) {
                prestamosPorFecha.add(prestamo);
            }
        }
        return prestamosPorFecha;
    }

    @Override
    public Prestamo obtenerPrestamo(Usuario usuario) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getUsuario().equals(usuario) && prestamo.esPrestamoVigente()) {
                return prestamo;
            }
        }
        return null;
    }

    @Override
    public void crearPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    @Override
    public boolean actualizarPedido(int id, Prestamo prestamo) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo p = listaPrestamos.get(i);
            if (p.getUsuario().equals(prestamo.getUsuario()) && p.esPrestamoVigente()) {
                listaPrestamos.set(i, prestamo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarPedido(Usuario usuario) {
        Prestamo prestamoAEliminar = null;
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getUsuario().equals(usuario) && prestamo.esPrestamoVigente()) {
                prestamoAEliminar = prestamo;
                break;
            }
        }
        if (prestamoAEliminar != null) {
            listaPrestamos.remove(prestamoAEliminar);
            return true;
        }
        return false;
    }
}
