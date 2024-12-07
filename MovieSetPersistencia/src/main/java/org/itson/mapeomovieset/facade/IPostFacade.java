/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.util.List;
import org.itson.entidades.PostEntity;
import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.moviesetdtos.PostDTO;

/**
 *
 * @author castr
 */
public interface IPostFacade {

    List<PostDTO> consultarPost() throws FindException;

}
