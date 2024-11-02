/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.entidades;

/**
 *
 * @author castr
 */
public class Comentario extends Post {

    private int rating;       // Valoración con estrellas (1-5)
    private boolean anclado; // Para comentarios anclados

    public Comentario() {
        super();
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("El rating debe ser entre 1 y 5");
        }
        this.rating = rating;
    }

    public boolean isAnclado() {
        return anclado;
    }

    public void setAnclado(boolean anclado) {
        this.anclado = anclado;
    }
    
}
