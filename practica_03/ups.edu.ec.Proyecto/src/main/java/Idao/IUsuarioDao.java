package Idao;

import java.util.List;

import Modelo.Usuario;

public interface IUsuarioDao {

	List<Usuario> obtenerUsuario();
    Usuario obtenerUsuario(int id);
    void crearUsuario(Usuario usuario);
    boolean actualizarUsuario(int id, Usuario usuario);
    boolean eliminarUsuario(int id);
}
