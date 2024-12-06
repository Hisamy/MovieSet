package org.itson.mapeomovieset.daos;

import org.itson.entidades.UsuarioEntity;
import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.mapeomovieset.excepciones.PersistenciaException;


public interface IUsuariosDAO {

    public boolean agregarUsuario(UsuarioEntity usuario) throws PersistenciaException;
    public UsuarioEntity buscarUsuarioPorCorreo(String correo) throws FindException;

}
