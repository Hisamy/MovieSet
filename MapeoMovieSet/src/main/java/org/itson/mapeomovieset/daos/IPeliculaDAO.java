/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.mapeomovieset.daos;

import org.itson.mapeomovieset.entidades.PeliculaEntity;
import org.itson.mapeomovieset.excepciones.FindException;

/**
 *
 * @author castr
 */
public interface IPeliculaDAO {

    boolean agregarPelicula(PeliculaEntity pelicula) throws FindException;
}
