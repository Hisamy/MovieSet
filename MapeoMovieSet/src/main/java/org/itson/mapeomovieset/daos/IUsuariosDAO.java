package org.itson.mapeomovieset.daos;

import org.itson.mapeomovieset.entidades.Usuario;
import org.itson.mapeomovieset.excepciones.FindException;


public interface IUsuariosDAO {

    public boolean agregarUsuario(Usuario usuario) throws FindException;
    public Usuario buscarUsuarioPorCorreo(String correo) throws FindException;

}
