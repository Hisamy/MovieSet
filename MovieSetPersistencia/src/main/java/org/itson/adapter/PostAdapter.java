/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.adapter;

import java.io.IOException;
import org.itson.entidades.PostEntity;
import org.itson.moviesetdtos.PostDTO;

/**
 *
 * @author hisam
 */
public class PostAdapter {
    UsuarioAdapter usuarioAdapter = new UsuarioAdapter();
    public PostDTO entityToDTO(PostEntity postEntity){
        PostDTO postDTO = new PostDTO();
        postDTO.setAutor(usuarioAdapter.usuarioEntityToDTO(postEntity.getAutor()));
        postDTO.setContenido(postEntity.getContenido());
        postDTO.setFechaPublicacion(postEntity.getFechaPublicacion());
        return postDTO;
    }
    
    public PostEntity DTOToEntity(PostDTO postDTO) throws IOException{
        return new PostEntity(
                postDTO.getContenido(), 
                postDTO.getFechaPublicacion(), 
                usuarioAdapter.usuarioDTOToEntity(postDTO.getAutor()));   
        
    }
}
