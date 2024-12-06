/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.io.IOException;
import org.itson.adapter.PostAdapter;
import org.itson.mapeomovieset.daos.IPostDAO;
import org.itson.mapeomovieset.daos.PostDAO;
import org.itson.mapeomovieset.excepciones.PersistenciaException;
import org.itson.moviesetdtos.PostDTO;

/**
 *
 * @author hisam
 */
public class CreatePostFacade implements ICreatePostFacade{

    private IPostDAO postDAO;
    private PostAdapter adapter;
    public CreatePostFacade() {
        postDAO = new PostDAO();
        adapter = new PostAdapter();
    }

    
    @Override
    public void sendPost(PostDTO postDTO) throws IOException, PersistenciaException {
        postDAO.agregarComentario(adapter.DTOToEntity(postDTO));
    }
    
}
