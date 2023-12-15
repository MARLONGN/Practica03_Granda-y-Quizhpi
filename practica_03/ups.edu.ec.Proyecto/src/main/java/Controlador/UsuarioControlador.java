package Controlador;

import java.util.List;

import Idao.IUsuarioDao;
import Modelo.Usuario;
import Vista.UsuarioVista;

public class UsuarioControlador {

	private IUsuarioDao usuarioDao;
	private UsuarioVista usuarioVista;
	private Usuario usuario;
	
	public UsuarioControlador(IUsuarioDao usuarioDao, UsuarioVista usuarioVista, Usuario usuario) {
		this.usuarioDao = usuarioDao;
		this.usuarioVista = usuarioVista;
		this.usuario = usuario;
	}
	
	public void crearUsuario() {
		usuario = usuarioVista.ingresarDatosUsuario();
		usuarioDao.crearUsuario(usuario);
	}
	
	public void actualizarUsuario() {
		usuario = usuarioVista.actualizarDatosUsuario();
		if(usuarioDao.actualizarUsuario(usuario.getIdentificacion(), usuario)==true) {
			usuarioVista.mostrarAlertas("Cliente actualizado");
		}else {
			usuarioVista.mostrarAlertas("Ha ocurrido un error");
		}
	}
	
	public void eliminarUsuario() {
		int id = usuarioVista.eliminarDatosUsuario();
		if(usuarioDao.eliminarUsuario(id)== true) {
			usuarioVista.mostrarAlertas("Usuario Eliminado");
		}else {
			usuarioVista.mostrarAlertas("Ha ocurrido un error");
		}
		
	}
	
	public void buscarUsuarioPorId() {
		int id = usuarioVista.buscarDatosUsuario();
		usuario = usuarioDao.obtenerUsuario(id);
		if(usuario == null) {
			usuarioVista.mostrarAlertas("Cliente no encontrado");
		}else {
			usuarioVista.mostrarInformacionUsuario(usuario.getIdentificacion(),usuario.getNombre(),usuario.getCorreo());
		}
	}
	
	public void listarUsuarios() {
		List<Usuario> listaUsuarios = usuarioDao.obtenerUsuario();
		for(Usuario usuario : listaUsuarios) {
			usuarioVista.mostrarInformacionUsuario(usuario.getIdentificacion(), usuario.getNombre(), usuario.getCorreo());
		}
	}
	
	
}
