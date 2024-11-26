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
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
    import org.itson.mapeomovieset.facade.AuthFacade;
import org.itson.mapeomovieset.facade.IAuthFacade;
import org.itson.moviesetdtos.UsuarioDTO;

/**
 *
 * @author castr
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class SVLogin extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(SVLogin.class.getName());
    private static final String LOGIN_PAGE = "/jsp/sign-in.jsp";
    private static final String INDEX_PAGE = "/jsp/index.jsp";
    private final IAuthFacade authFacade;

    public SVLogin() {
        this.authFacade = new AuthFacade();
    }

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

        try {
            // Verificación básica de campos vacíos
            if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                setErrorMessage(request, "Por favor complete todos los campos");
                redirectToLogin(request, response);
                return;
            }

            UsuarioDTO usuarioForm = new UsuarioDTO();
            usuarioForm.setCorreo(email);
            usuarioForm.setContrasenia(password);

            // Intentar autenticar al usuario
            usuarioForm = authenticateUser(email, password);

            if (usuarioForm == null) {
                setErrorMessage(request, "Email o contraseña incorrectos");
                redirectToLogin(request, response);
                return;
            }

            // Iniciar sesión
            initializeUserSession(request, usuarioForm);

            // Redirigir al índice
            response.sendRedirect(request.getContextPath() + INDEX_PAGE);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error durante el inicio de sesión", e);
            setErrorMessage(request, "Error del sistema. Por favor intente más tarde");
            redirectToLogin(request, response);
        }
    }

    private UsuarioDTO authenticateUser(String email, String password) {
        try {
            return authFacade.iniciarSesion(email, password);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al autenticar usuario", e);
            return null;
        }
    }

    private void initializeUserSession(HttpServletRequest request, UsuarioDTO usuario) {
        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario);
        System.out.println("Este es el nombre " + usuario.getUsername());
        System.out.println("Este es el rol " + usuario.getRol());

        // Establecer tiempo de expiración de la sesión (30 minutos)
        session.setMaxInactiveInterval(30 * 60);
    }

    private void setErrorMessage(HttpServletRequest request, String message) {
        request.setAttribute("errorMessage", message);
    }

    private void redirectToLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
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
