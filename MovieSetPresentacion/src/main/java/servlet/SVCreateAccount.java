/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.mapeomovieset.excepciones.PersistenciaException;
import org.itson.mapeomovieset.facade.CreateAccountFacade;
import org.itson.mapeomovieset.facade.ICreateAccountFacade;
//import org.itson.moviesetdtos.UsuarioDTO;

public class SVCreateAccount extends HttpServlet {

//    private UsuarioDTO usuarioDTO;
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
//        try {
//            //Obtener los datos del formulario
//            String username = request.getParameter(
//                    "username");
//            String email = request.getParameter(
//                    "email");
//            String password = request.getParameter(
//                    "password");
//            System.out.println(username + email + password);
////            usuarioDTO = new UsuarioDTO();
////
////            
////
////            usuarioDTO.setContrasenia(password);
////            usuarioDTO.setCorreo(email);
////            usuarioDTO.setUsername(username);
//            
//            createAccountFacade = new CreateAccountFacade();
//            createAccountFacade.sendCreateAccountForm(usuarioDTO);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(SVCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    
    

}
