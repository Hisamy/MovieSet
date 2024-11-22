/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author castr
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class SVLogin extends HttpServlet {

    private static final String VALID_EMAIL = "correo@prueba.com";
    private static final String VALID_PASSWORD = "1234";

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
        // Si ya hay una sesión activa, redirigir a moviedle.jsp
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("email") != null) {//Falta logica por definir aqui todavia
            response.sendRedirect(request.getContextPath() + "/moviedle.jsp");
            return;
        }
        // Si no hay sesión, redirigir al login
        response.sendRedirect(request.getContextPath() + "/signIn.jsp");
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

        // Validar que los campos no estén vacíos
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/jsp/signIn.jsp?error=empty");
            return;
        }

        // Verificar las credenciales
        if (VALID_EMAIL.equals(email) && VALID_PASSWORD.equals(password)) {
            // Crear sesión y guardar información del usuario
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setMaxInactiveInterval(5 * 60); // 5 minutos de timeout

            // Redirigir al usuario a la página principal
            response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
        } else {
            // Redirigir de vuelta al login con mensaje de error
            response.sendRedirect(request.getContextPath() + "/jsp/signIn.jsp?error=invalid");
        }
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
