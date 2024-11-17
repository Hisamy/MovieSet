package org.itson.mapeomovieset.facade;

import com.mongodb.gridfs.GridFS;
import org.itson.mapeomovieset.daos.IUsuariosDAO;
import org.itson.mapeomovieset.daos.UsuariosDAO;
import org.itson.mapeomovieset.entidades.UsuarioEntity;
import org.itson.mapeomovieset.excepciones.FindException;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthFacade implements IAuthFacade {

    IUsuariosDAO usuariosDAO;

    public AuthFacade() {
        this.usuariosDAO = new UsuariosDAO();
    }

    @Override
    public UsuarioEntity registrarUsuario(
            String nombre, 
            String correo, 
            String contrasenia, 
            String telefono, 
            String ciudad, 
            Date fechaNacimiento, 
            String genero) {
        // Validar los datos de registro
        validarDatosRegistro(nombre, correo, contrasenia);

        // Verificar si el correo ya está registrado
        if (existeCorreo(correo)) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        // Crear un nuevo usuario
        UsuarioEntity nuevoUsuario = new UsuarioEntity();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setContrasenia(contrasenia);
        nuevoUsuario.setTelefono(telefono);
        nuevoUsuario.setCiudad(ciudad);
        nuevoUsuario.setFechaNacimiento(fechaNacimiento);
        nuevoUsuario.setGenero(genero);

        try {
            // Intentar agregar el nuevo usuario a la base de datos
            boolean registrado = usuariosDAO.agregarUsuario(nuevoUsuario);
            return registrado ? nuevoUsuario : null;
        } catch (FindException ex) {
            Logger.getLogger(AuthFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public UsuarioEntity iniciarSesion(String correo, String contrasenia) {
        try {
            UsuarioEntity usuario = usuariosDAO.buscarUsuarioPorCorreo(correo);
            if (usuario != null && usuario.getContrasenia().equals(contrasenia)) {
                return usuario;
            } else {
                System.out.println("Correo o contraseña incorrectos.");
                return null;
            }
        } catch (FindException ex) {
            Logger.getLogger(AuthFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean existeCorreo(String correo) {
        try {
            return usuariosDAO.buscarUsuarioPorCorreo(correo) != null;
        } catch (FindException ex) {
            Logger.getLogger(AuthFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void validarDatosRegistro(String nombre, String correo, String contrasenia) {
        // Validación del nombre
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        // Validación del correo utilizando regex
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (correo == null || correo.isEmpty() || !correo.matches(emailRegex)) {
            throw new IllegalArgumentException("El correo es inválido.");
        }

        // Validación de la contraseña
        String passwordRegex = "^(?=.*[0-9])(?=.{8,}).*$";
        if (contrasenia == null || !contrasenia.matches(passwordRegex)) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres y al menos un número.");
        }
    }
}
