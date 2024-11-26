package org.itson.entidades;

import java.util.Date;
import org.bson.types.ObjectId;


public class UsuarioEntity {

    private ObjectId id;
    private String correo;
    private String name;
    private String lastName;
    private String username;
    private String contrasenia;
    private String pais;
    private Date fechaNacimiento;
    private String genero;
    private String rol;
    private String country;
    private String gender;
    private Date birthday;
    private byte[] avatar;

    

    public UsuarioEntity() {
    }

    public void setAvatar(String avatar) {
    public UsuarioEntity(String correo, String name, String lastName, String username, String contrasenia, String country, String gender, Date birthday, byte[] avatar) {
        this.correo = correo;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.contrasenia = contrasenia;
        this.country = country;
        this.gender = gender;
        this.birthday = birthday;
        this.avatar = avatar;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
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
                + '}';
    }

}
