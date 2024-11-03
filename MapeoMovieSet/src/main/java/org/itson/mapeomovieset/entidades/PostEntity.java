/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author castr
 */
public class PostEntity {
    private String contenido;
    private ArrayList<ComentarioEntity> comentario;
    private Date fechaPublicacion;
    private Date fechaModificacion;
    private UsuarioEntity autor;
    private Float stars;     
    private boolean anclado;


    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    public UsuarioEntity getAutor() {
        return autor;
    }

    public void setAutor(UsuarioEntity autor) {
        this.autor = autor;
    }

    public List<ComentarioEntity> getComentario() {
        return comentario;
    }

    public void setComentario(ArrayList<ComentarioEntity> comentario) {
        this.comentario = comentario;
    }

    public Float getStars() {
        return stars;
    }

    public void setStars(Float stars) {
        this.stars = stars;
    }


    public boolean isAnclado() {
        return anclado;
    }

    public void setAnclado(boolean anclado) {
        this.anclado = anclado;
    }
 
    
    
}