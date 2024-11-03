/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.itson.mapeomovieset.daos;

import org.itson.mapeomovieset.entidades.Usuario;
import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.mapeomovieset.facade.AuthFacade;

import java.util.Date;

/**
 *
 * @author castr
 */
public class PruebasMovieSet {

    public static void main(String[] args) throws FindException {

        AuthFacade authFacade = new AuthFacade();

        // Prueba de registro de usuario con datos validos
//        try {
//            Usuario usuario = authFacade.registrarUsuario(
//                    "Oli Inzunza",
//                    "oli-finance@gmail.com",
//                    "oliinzunza123",
//                    "687314322",
//                    "avatar.png",
//                    "Guasave",
//                    new Date(2004-8-2),
//                    "Masculino"
//            );
//            System.out.println("Usuario registrado: " + usuario.getNombreCompleto());
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error en el registro: " + e.getMessage());
//        }

//        // Prueba de inicio de sesion
//        try {
//            Usuario usuario = authFacade.iniciarSesion("hisamyfive@gmail.com", "hisamy123");
//            if (usuario != null) {
//                System.out.println("Inicio de sesion exitoso: " + usuario.getNombreCompleto());
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error en el inicio de sesion: " + e.getMessage());
//        }


    }
}
