/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.itson.entidades.UsuarioEntity;
import org.itson.mapeomovieset.facade.AuthFacade;
import org.itson.mapeomovieset.facade.IAuthFacade;

/**
 *
 * @author castr
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class SVLogin extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        // Si ya hay una sesión activa, redirigir a moviedle.jsp
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute("email") != null) {//Falta logica por definir aqui todavia
//            response.sendRedirect(request.getContextPath() + "/moviedle.jsp");
//            return;
//        }
//        // Si no hay sesión, redirigir al login
//        response.sendRedirect(request.getContextPath() + "/signIn.jsp");
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

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("Email recibido: " + request.getParameter("email"));
        System.out.println("Password recibido: " + request.getParameter("password"));

        IAuthFacade fachada = new AuthFacade();

        UsuarioEntity usuarioEntity = fachada.iniciarSesion(email, password);
        System.out.println(usuarioEntity.getCorreo());

        // Redirigir al usuario a la página principal
        response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
