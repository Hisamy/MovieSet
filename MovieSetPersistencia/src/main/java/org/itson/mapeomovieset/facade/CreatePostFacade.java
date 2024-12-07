/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;
import org.itson.adapter.PostAdapter;
import org.itson.mapeomovieset.daos.IPostDAO;
import org.itson.mapeomovieset.daos.PostDAO;
import org.itson.mapeomovieset.excepciones.PersistenciaException;
import org.itson.moviesetdtos.PostDTO;

/**
 *
 * @author hisam
 */
public class CreatePostFacade implements ICreatePostFacade {

    private IPostDAO postDAO;
    private PostAdapter adapter;

    public CreatePostFacade() {
        postDAO = new PostDAO();
        adapter = new PostAdapter();
    }

    @Override
    public Boolean sendPost(PostDTO postDTO) throws IOException, PersistenciaException {
        try {
            postDAO.agregarPost(adapter.DTOToEntity(postDTO));
            return true;
        } catch (PersistenciaException e) {
            return false;
        }
    }

    @Override
    public boolean deletePost(String id) throws IOException, PersistenciaException {
        try {
            ObjectId idPost = new ObjectId(id);
            postDAO.eliminarPost(idPost);
            return true;
        } catch (PersistenciaException ex) {
            Logger.getLogger(CreatePostFacade.class.getName()).log(Level.SEVERE, "Error al eliminar el post", ex);
            return false;
        }
    }

}
