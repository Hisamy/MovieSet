/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.mapeomovieset.daos;

import org.itson.mapeomovieset.entidades.ComentarioEntity;
import org.itson.mapeomovieset.excepciones.FindException;

/**
 *
 * @author castr
 */
public interface IComentarioDAO {

    boolean agregarComentario(ComentarioEntity comentario) throws FindException;
    
}
