/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.moviesetdtos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author
 */
public class PostDTO {

    private String id;
    private String contenido;
    private Date fechaPublicacion;
    private UsuarioDTO autor;
    private Float stars;
    private Boolean Anclado;
    private List<ComentarioDTO> comentarios;

    public PostDTO() {
    }

    public PostDTO(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public UsuarioDTO getAutor() {
        return autor;
    }

    public void setAutor(UsuarioDTO autor) {
        this.autor = autor;
    }

    public Float getStars() {
        return stars;
    }

    public void setStars(Float stars) {
        this.stars = stars;
    }

    public Boolean getAnclado() {
        return Anclado;
    }

    public void setAnclado(Boolean Anclado) {
        this.Anclado = Anclado;
    }

    public String getId() {
        return id;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }

}
