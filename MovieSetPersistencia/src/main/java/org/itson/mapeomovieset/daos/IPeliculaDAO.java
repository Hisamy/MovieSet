/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.mapeomovieset.daos;

import org.itson.entidades.PeliculaEntity;
import org.itson.mapeomovieset.excepciones.PersistenciaException;

/**
 *
 * @author castr
 */
public interface IPeliculaDAO {

    boolean agregarPelicula(PeliculaEntity pelicula) throws PersistenciaException;
}
