/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.io.IOException;
import org.itson.mapeomovieset.excepciones.PersistenciaException;
import org.itson.moviesetdtos.PostDTO;

/**
 *
 * @author hisam
 */
public interface ICreatePostFacade {
    Boolean sendPost(PostDTO postDTO) throws IOException, PersistenciaException;
}
