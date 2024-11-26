/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.entidades;

import java.util.Date;

/**
 *
 * @author hisam
 */
public class AdministradorEntity extends UsuarioEntity{

    public AdministradorEntity(String correo, String name, String lastName, String username, String contrasenia, String country, String gender, Date birthday, String avatar) {
        
    }

    public AdministradorEntity(String correo, String name, String lastName, String username, String contrasenia, String country, String gender, Date birthday, byte[] avatar) {
        super(correo, name, lastName, username, contrasenia, country, gender, birthday, avatar);
    }

    
    
    
    
}
