package Dao;

import java.util.ArrayList;
import java.util.List;

import Idao.IUsuarioDao;
import Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements IUsuarioDao {

    private List<Usuario> listaUsuarios;

    public UsuarioDao() {
        listaUsuarios= new ArrayList<>();
    }

    @Override
    public List<Usuario> obtenerUsuario() {
        return listaUsuarios;
    }

    @Override
    public Usuario obtenerUsuario(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdentificacion() == id) {
                return usuario;
            }
        }
        return null;
    }


    @Override
    public void crearUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    @Override
    public boolean actualizarUsuario(int id, Usuario usuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario us = listaUsuarios.get(i);
            if (us.getIdentificacion() == id) {
                listaUsuarios.set(i, usuario);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean eliminarUsuario(int id) {
        Usuario usuarioAEliminar = null;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdentificacion()== id) {
                usuarioAEliminar = usuario;
                break;
            }
        }
        if (usuarioAEliminar != null) {
            listaUsuarios.remove(usuarioAEliminar);
            return true;
        }
        return false;
    }
}

