package org.itson.entidades;

import java.util.Date;
import org.bson.types.ObjectId;


public class UsuarioEntity {

    private ObjectId id;
    private String name;
    private String username;
    private String lastName;
    private String correo;
    private String contrasenia;
    private String avatar;
    private String pais;
    private Date fechaNacimiento;
    private String genero;
    private String rol;

    public UsuarioEntity(String name, String username, String lastName, String correo, String contrasenia) {
        this.name = name;
        this.username = username;
        this.lastName = lastName;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public UsuarioEntity() {
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    @Override
    public String toString() {
        return "Usuario{"
                + ""
                + "id=" + id
                + ", nombre=" + name
                + ", apellidoMaterno=" + lastName
                + ", correo=" + correo
                + ", contrasenia=" + contrasenia
                + ", avatar=" + avatar
                + ", ciudad=" + pais
                + ", fechaNacimiento=" + fechaNacimiento
                + ", genero=" + genero
                + '}';
    }

}
