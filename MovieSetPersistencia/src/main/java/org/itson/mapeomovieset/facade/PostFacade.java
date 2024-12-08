/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.util.ArrayList;
import java.util.List;
import org.itson.adapter.PostAdapter;
import org.itson.entidades.PostEntity;
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
        // Recuperar los posts desde el DAO
        List<PostEntity> posts = postDAO.consultarPosts();

        // Ordenar los posts para poner primero los anclados
        posts.sort((p1, p2) -> Boolean.compare(p2.isAnclado(), p1.isAnclado()));

        // Convertir la lista de PostEntity a PostDTO
        return adapter.entityListToDTOList(posts);
    }

    public PostDTO fijarPost(String postId, boolean anclado) throws FindException {
        // Busca el post por id
        PostEntity postEntity = postDAO.consultarPostPorId(postId);
        if (postEntity == null) {
            throw new FindException("Post no encontrado");
        }
        // Actualiza el estado de 'anclado'
        postEntity.setAnclado(true);
        // Guarda el cambio
        postDAO.actualizarPost(postEntity);
        // Convierte a DTO y devuelve
        return adapter.entityToDTO(postEntity);
    }

}
