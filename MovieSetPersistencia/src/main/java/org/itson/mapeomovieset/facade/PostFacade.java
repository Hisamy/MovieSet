/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.entidades.PostEntity;
import org.itson.mapeomovieset.daos.PostDAO;

/**
 *
 * @author castr
 */
public class PostFacade implements IPostFacade {

    private PostDAO postDAO;

    @Override
    public boolean agregarComentario(PostEntity postEntity) {
        try {
            return postDAO.agregarComentario(postEntity);
        } catch (Exception ex) {
            Logger.getLogger(PostFacade.class.getName()).log(Level.SEVERE, "Error al agregar película", ex);
            return false;
        }

    }

}
