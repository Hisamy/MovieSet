/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.entidades;

import java.time.Duration;

/**
 *
 * @author castr
 */
public class PeliculaEntity {

    private String movieName;
    private String directorName;
    private int ano;
    private double rating;
    private Duration duracion;  // Para almacenar horas y minutos

    public PeliculaEntity() {
        super();
    }

    public String getMovieName() {
        return movieName;
    }
    
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    
    public String getDirectorName() {
        return directorName;
    }
    
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    
    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public Duration getDuracion() {
        return duracion;
    }
    
    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }
    
}
