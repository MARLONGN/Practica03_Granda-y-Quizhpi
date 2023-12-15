package Idao;

import java.util.Date;
import java.util.List;

import Modelo.Prestamo;
import Modelo.Usuario;

public interface IPrestamoDao {
	List<Prestamo> obtenerPrestamo();
    List<Prestamo> obtenerPrestamosPorUsuario(Usuario usuario);
    List<Prestamo> obtenerPedidosPorFecha(Date fecha);
    Prestamo obtenerPrestamo(Usuario usuario);
    void crearPrestamo(Prestamo prestamo);
    boolean actualizarPedido(int id, Prestamo prestamo);
    boolean eliminarPedido(Usuario usuario);

}
