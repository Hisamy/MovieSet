package org.itson.moviesetdto;


import java.time.Duration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author castr
 */
public class PeliculaDTO {

    private String movieName;
    private String directorName;
    private int ano;
    private double rating;
    private Duration duracion;  // Para almacenar horas y minutos

    public PeliculaDTO() {
        super();
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public int getAno() {
        return ano;
    }

    public double getRating() {
        return rating;
    }

    public Duration getDuracion() {
        return duracion;
    }

}
