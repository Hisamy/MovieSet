package org.itson.mapeomovieset.daos;

import org.itson.mapeomovieset.entidades.UsuarioEntity;
import org.itson.mapeomovieset.excepciones.FindException;


public interface IUsuariosDAO {

    public boolean agregarUsuario(UsuarioEntity usuario) throws FindException;
    public UsuarioEntity buscarUsuarioPorCorreo(String correo) throws FindException;

}
