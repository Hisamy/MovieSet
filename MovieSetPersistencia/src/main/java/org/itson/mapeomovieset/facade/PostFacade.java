/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.util.ArrayList;
import java.util.List;
import org.itson.adapter.PostAdapter;
import org.itson.mapeomovieset.daos.PostDAO;
import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.moviesetdtos.PostDTO;

/**
 *
 * @author castr
 */
public class PostFacade implements IPostFacade {

    private PostDAO postDAO;
    private PostAdapter adapter;

    public PostFacade() {
        this.postDAO = new PostDAO();
        this.adapter = new PostAdapter();
    }
    
    

    @Override
    public List<PostDTO> consultarPost() throws FindException {
        return adapter.entityListToDTOList(postDAO.consultarPosts());
        
    }

}
