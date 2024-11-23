/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.itson.mapeomovieset.daos;

import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.mapeomovieset.facade.AuthFacade;

import java.util.Date;
import org.itson.entidades.UsuarioEntity;

/**
 *
 * @author castr
 */
public class PruebasMovieSet {

    public static void main(String[] args) throws FindException {

        AuthFacade authFacade = new AuthFacade();

//        // Prueba de registro de usuario con datos validos
//        try {
//            UsuarioEntity usuario = authFacade.registrarUsuario(
//                    "Oli",
//                    "Inzunza",
//                    "Valle",
//                    "oli-finance@gmail.com",
//                    "oliinzunza123",
//                    "687314322",
//                    "Guasave",
//                    new Date(2004-8-2),
//                    "Masculino"
//            );
//            System.out.println("Usuario registrado: " + usuario.getNombre());
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error en el registro: " + e.getMessage());
//        }
//        
      

//        // Prueba de inicio de sesion
        try {
            UsuarioEntity usuario = authFacade.iniciarSesion("oli-finance@gmail.com", "oliinzunza123");
            if (usuario != null) {
                System.out.println("Inicio de sesion exitoso: " + usuario.getNombre());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error en el inicio de sesion: " + e.getMessage());
        }


    }
}
