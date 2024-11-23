/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.entidades.PeliculaEntity;
import org.itson.mapeomovieset.conexion.Conexion;
import org.itson.mapeomovieset.conexion.IConexion;
import org.itson.mapeomovieset.daos.PeliculaDAO;
import org.itson.mapeomovieset.excepciones.PersistenciaException;

/**
 *
 * @author castr
 */
public class MoviePostFacade implements IMoviePostFacade {

    private PeliculaDAO peliculaDAO;

    public MoviePostFacade() {
        peliculaDAO = new PeliculaDAO();
        
    }

    
    @Override
    public boolean agregarPelicula(PeliculaEntity pelicula) {
        try {
            return peliculaDAO.agregarPelicula(pelicula);
        } catch (PersistenciaException ex) {
            Logger.getLogger(MoviePostFacade.class.getName()).log(Level.SEVERE, "Error al agregar película", ex);
            return false;
        }
    }

}
