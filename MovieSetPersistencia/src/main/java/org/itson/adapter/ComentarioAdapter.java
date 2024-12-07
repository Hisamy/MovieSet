/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.adapter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.entidades.ComentarioEntity;
import org.itson.entidades.UsuarioEntity;
import org.itson.moviesetdtos.ComentarioDTO;
import org.itson.moviesetdtos.UsuarioDTO;

/**
 *
 * @author asielapodaca
 */
public class ComentarioAdapter {
    private UsuarioAdapter usuarioAdapter;

    public ComentarioAdapter() {
        this.usuarioAdapter = new UsuarioAdapter();
    }
    
    public ComentarioDTO entityToDTO(ComentarioEntity entity) {
        UsuarioDTO usuarioDTO = usuarioAdapter.usuarioEntityToDTO(entity.getAutor());
        String contenido = entity.getContenido();
        String postId = entity.getPostId();
        ComentarioDTO dto = new ComentarioDTO(contenido, usuarioDTO);
        dto.setPostId(postId);
        return dto;
    }
    
    public ComentarioEntity DTOToEntity(ComentarioDTO dto) {
        ComentarioEntity entity = new ComentarioEntity();
        try {
            UsuarioEntity usuarioEntity = usuarioAdapter.usuarioDTOToEntity(dto.getAutor());
            String contenido = dto.getContenido();
            String postId = dto.getPostId();
            entity.setAutor(usuarioEntity);
            entity.setContenido(contenido);
            entity.setPostId(postId);
        } catch (IOException ex) {
            Logger.getLogger(ComentarioAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
    
}
