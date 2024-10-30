package org.itson.mapeomovieset.daos;

import org.bson.types.ObjectId;
import org.itson.mapeomovieset.entidades.Usuario;
import org.itson.mapeomovieset.excepciones.FindException;

import java.util.List;

public interface IUsuariosDAO {

    public boolean agregarUsuario(Usuario usuario) throws FindException;
    public Usuario buscarUsuarioPorCorreo(String correo) throws FindException;

}
