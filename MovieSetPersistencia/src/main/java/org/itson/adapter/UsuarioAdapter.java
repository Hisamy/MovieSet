/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.entidades.UsuarioEntity;
import org.itson.moviesetdtos.UsuarioDTO;

/**
 *
 * @author hisam
 */
public class UsuarioAdapter {

    private static final Logger LOGGER = Logger.getLogger(UsuarioAdapter.class.getName());

    public UsuarioEntity usuarioDTOToEntity(UsuarioDTO usuarioDTO) throws IOException {

        byte[] avatarBytes = null;

        if (usuarioDTO.getAvatar() != null && !usuarioDTO.getAvatar().isEmpty()) {
            // Construir la ruta completa desde la raíz de la aplicación web
            String baseWebAppPath = System.getProperty("catalina.base")
                    + File.separator + "webapps"
                    + File.separator + "MovieSet";

            // Combinar la ruta base con la ruta relativa del avatar
            String rutaCompleta = baseWebAppPath + File.separator + usuarioDTO.getAvatar();

            LOGGER.log(Level.INFO, "Intentando acceder al archivo: " + rutaCompleta);
            File avatarFile = new File(rutaCompleta);
            System.out.println("Ruta del archivo " + avatarFile.getAbsolutePath());
            if (avatarFile.exists()) {
                try (FileInputStream fileInputStream = new FileInputStream(avatarFile)) {
                    avatarBytes = fileInputStream.readAllBytes();
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Error al leer el archivo del avatar: " + usuarioDTO.getAvatar(), ex);
                    throw new IOException("Error al leer el archivo del avatar: " + usuarioDTO.getAvatar(), ex);
                }
            } else {
                throw new IOException("El archivo especificado no existe: " + usuarioDTO.getAvatar());
            }
        }

        return new UsuarioEntity(
                usuarioDTO.getCorreo(),
                usuarioDTO.getRol(),
                usuarioDTO.getName(),
                usuarioDTO.getLastName(),
                usuarioDTO.getUsername(),
                usuarioDTO.getContrasenia(),
                usuarioDTO.getCountry(),
                usuarioDTO.getGender(),
                usuarioDTO.getBirthday(),
                avatarBytes
        );

    }

    public UsuarioDTO usuarioEntityToDTO(UsuarioEntity usuarioEntity) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setCorreo(usuarioEntity.getCorreo());
        usuarioDTO.setUsername(usuarioEntity.getUsername());
        usuarioDTO.setContrasenia(usuarioEntity.getContrasenia());
        usuarioDTO.setName(usuarioEntity.getName());
        usuarioDTO.setLastName(usuarioEntity.getLastName());
        usuarioDTO.setBirthday(usuarioEntity.getBirthday());
        usuarioDTO.setCountry(usuarioEntity.getCountry());
        usuarioDTO.setGender(usuarioEntity.getGender());

        return usuarioDTO;
    }
}
