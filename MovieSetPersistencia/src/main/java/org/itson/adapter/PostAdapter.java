/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.itson.entidades.PostEntity;
import org.itson.moviesetdtos.PostDTO;

/**
 *
 * @author hisam
 */
public class PostAdapter {

    UsuarioAdapter usuarioAdapter = new UsuarioAdapter();     

    public PostAdapter() {
        this.usuarioAdapter = new UsuarioAdapter();
    }
    
    public PostDTO entityToDTO(PostEntity postEntity) {
        PostDTO postDTO = new PostDTO();
        postDTO.setAutor(usuarioAdapter.usuarioEntityToDTO(postEntity.getAutor()));
        postDTO.setContenido(postEntity.getContenido());
        postDTO.setFechaPublicacion(postEntity.getFechaPublicacion());
        return postDTO;
    }
    
    public PostEntity DTOToEntity(PostDTO postDTO){
        try {
            return new PostEntity(
                    postDTO.getContenido(),
                    postDTO.getFechaPublicacion(),        
                    usuarioAdapter.usuarioDTOToEntity(postDTO.getAutor()));
        } catch (IOException ex) {
            Logger.getLogger(PostAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        
    }
    
    /**
     * Converts a list of PostEntities to a list of PostDTOs
     * 
     * @param entities List of entities to convert
     * @return List of converted DTOs
     */
    public List<PostDTO> entityListToDTOList(List<PostEntity> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }
        
        return entities.stream()
            .map(this::entityToDTO)
            .collect(Collectors.toList());
    }

    /**
     * Converts a list of PostDTOs to a list of PostEntities
     * 
     * @param dtos List of DTOs to convert
     * @return List of converted entities
     * @throws IOException if there's an error converting any user
     */
    public List<PostEntity> dtoListToEntityList(List<PostDTO> dtos) throws IOException {
        if (dtos == null) {
            return new ArrayList<>();
        }
        
        return dtos.stream()
            .map(this::DTOToEntity)
            .collect(Collectors.toList());
    }
}
