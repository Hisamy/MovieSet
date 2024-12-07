/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.entidades.ComentarioEntity;
import org.itson.mapeomovieset.daos.ComentariosDAO;

/**
 *
 * @author castr
 */
public class CommentFacade implements ICommentFacade {

    private ComentariosDAO comentariosDAO;

    @Override
    public boolean agregarComentario(ComentarioEntity comentario, String postId) {
        try {
            return comentariosDAO.agregarComentario(comentario, postId);
        } catch (Exception ex) {
            Logger.getLogger(CommentFacade.class.getName()).log(Level.SEVERE, "Error al agregar comentario", ex);
            return false;
        }
    }

}
