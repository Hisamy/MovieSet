/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.mapeomovieset.excepciones.PersistenciaException;
import org.itson.mapeomovieset.facade.CreateAccountFacade;
import org.itson.mapeomovieset.facade.ICreateAccountFacade;
import org.itson.moviesetdtos.UsuarioDTO;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
public class SVCreateAccount extends HttpServlet {

    private UsuarioDTO usuarioDTO;
    private ICreateAccountFacade createAccountFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            //Obtener los datos del formulario
            String name = request.getParameter("name");
            String lastName = request.getParameter("last-name");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String repeatPassword = request.getParameter("repeat-password");
            Part avatarPart = request.getPart("avatar");
            String country = request.getParameter("country");
            String birthdateStr = request.getParameter("birthdate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthdate = dateFormat.parse(birthdateStr);
            String gender = request.getParameter("gender");

            if (!password.equals(repeatPassword)) {
                response.sendRedirect("jsp/create-account.jsp?error=password");
            } else {
                String avatar = procesarAvatar(avatarPart);

                //Se guardan en una DTO y se mandan.
                usuarioDTO = new UsuarioDTO();
                usuarioDTO.setContrasenia(password);
                usuarioDTO.setCorreo(email);
                usuarioDTO.setUsername(username);
                usuarioDTO.setName(name);
                usuarioDTO.setLastName(lastName);
                usuarioDTO.setBirthday(birthdate);
                usuarioDTO.setCountry(country);
                usuarioDTO.setGender(gender);
                usuarioDTO.setAvatar(avatar);
                usuarioDTO.setRol("user");

                createAccountFacade = new CreateAccountFacade();
                createAccountFacade.sendCreateAccountForm(usuarioDTO);

                response.sendRedirect("jsp/create-account.jsp?success=true");

            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(SVCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("jsp/create-account.jsp?error=general");
        } catch (ParseException ex) {
            Logger.getLogger(SVCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("jsp/create-account.jsp?error=general");
        }

    }

    private String procesarAvatar(Part avatar) throws IOException {
        String baseWebAppPath = System.getProperty("catalina.base")
                + File.separator + "webapps"
                + File.separator + "MovieSet";
        String uploadPath = baseWebAppPath + File.separator + "uploads";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String avatarFileName = UUID.randomUUID().toString() + "_" + avatar.getSubmittedFileName();
        String avatarFilePath = uploadPath + File.separator + avatarFileName;

        avatar.write(avatarFilePath);

        return "uploads/" + avatarFileName;

    }

}
