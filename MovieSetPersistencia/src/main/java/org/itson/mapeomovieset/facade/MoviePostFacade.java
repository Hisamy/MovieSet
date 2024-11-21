/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import org.itson.mapeomovieset.daos.PeliculaDAO;
import org.itson.moviesetdto.PeliculaDTO;

/**
 *
 * @author castr
 */
public class MoviePostFacade implements IMoviePostFacade {

    private PeliculaDAO peliculaDAO;

    @Override
    public boolean agregarPelicula(PeliculaDTO pelicula) {
//        peliculaDAO.agregarPelicula();
        return false;
    }

}
