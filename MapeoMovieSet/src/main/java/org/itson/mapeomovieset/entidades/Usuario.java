package org.itson.mapeomovieset.entidades;

import com.mongodb.gridfs.GridFS;
import org.bson.types.ObjectId;

import java.util.Date;

public class Usuario {

    private ObjectId id;
    private String nombreCompleto;
    private String correo;
    private String contrasenia;
    private String telefono;
    private GridFS avatar;
    private String ciudad;
    private Date fechaNacimiento;
    private String genero;

    public Usuario() {}

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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public GridFS getAvatar() {
        return avatar;
    }

    public void setAvatar(GridFS avatar) {
        this.avatar = avatar;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", telefono='" + telefono + '\'' +
                ", avatar='" + avatar + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", genero='" + genero + '\'' +
                '}';
    }
}
