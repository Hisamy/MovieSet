/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.adapter.UsuarioAdapter;
import org.itson.mapeomovieset.conexion.Conexion;
import org.itson.mapeomovieset.conexion.IConexion;
import org.itson.mapeomovieset.daos.IUsuariosDAO;
import org.itson.mapeomovieset.daos.UsuariosDAO;
import org.itson.mapeomovieset.excepciones.PersistenciaException;
import org.itson.moviesetdtos.UsuarioDTO;

/**
 *
 * @author hisam
 */
public class CreateAccountFacade implements ICreateAccountFacade {

    private final IUsuariosDAO usuarioDAO;
    private UsuarioAdapter adapter;

    public CreateAccountFacade() {
        usuarioDAO = new UsuariosDAO();
        adapter = new UsuarioAdapter();
    }

    @Override
    public void sendCreateAccountForm(UsuarioDTO usuarioForm) throws PersistenciaException {
        try {
            usuarioDAO.agregarUsuario(adapter.usuarioDTOToEntity(usuarioForm));
        } catch (IOException ex) {
            Logger.getLogger(CreateAccountFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
