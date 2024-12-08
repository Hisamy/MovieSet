/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.adapter.ComentarioAdapter;
import org.itson.entidades.ComentarioEntity;
import org.itson.mapeomovieset.daos.ComentariosDAO;
import org.itson.moviesetdtos.ComentarioDTO;

/**
 *
 * @author castr
 */
public class CommentFacade implements ICommentFacade {

    private ComentariosDAO comentariosDAO;
    private ComentarioAdapter comentarioAdapter;

    public CommentFacade() {
        this.comentariosDAO = new ComentariosDAO();
        this.comentarioAdapter = new  ComentarioAdapter();
    }

    @Override
    public boolean agregarComentario(ComentarioDTO comentario, String postId) {
        try {
            ComentarioEntity comentarioEntity = comentarioAdapter.DTOToEntity(comentario);
            return comentariosDAO.agregarComentario(comentarioEntity, postId);
        } catch (Exception ex) {
            Logger.getLogger(CommentFacade.class.getName()).log(Level.SEVERE, "Error al agregar comentario", ex);
            return false;
        }
    }

}
