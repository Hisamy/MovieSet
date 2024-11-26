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
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.mapeomovieset.excepciones.PersistenciaException;
import org.itson.mapeomovieset.facade.CreatePostFacade;
import org.itson.mapeomovieset.facade.ICreatePostFacade;
import org.itson.moviesetdtos.PostDTO;
import org.itson.moviesetdtos.UsuarioDTO;

/**
 *
 * @author hisam
 */
public class SVCreatePost extends HttpServlet {

    private ICreatePostFacade createPostFacade;
    private PostDTO postDTO;
    private UsuarioDTO autor;

    public SVCreatePost() {
        createPostFacade = new CreatePostFacade();
        postDTO = new PostDTO();
    }

    public void procesarSolicitud(HttpServletRequest request) throws FindException{
        HttpSession session = request.getSession();
        autor = (UsuarioDTO) session.getAttribute("usuario");
        
        if (autor == null) {
            throw new FindException("El usuario no está autenticado en la sesión.");
        }
   
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            procesarSolicitud(request);
        } catch (FindException ex) {
            response.sendRedirect("jsp/create-account.jsp");
        }
        LocalDateTime now = LocalDateTime.now();
        String comment = request.getParameter("comment");
        Date fechaPublicacion = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        
        postDTO.setAutor(autor);
        postDTO.setContenido(comment);
        postDTO.setFechaPublicacion(fechaPublicacion);
        
        try {
            createPostFacade.sendPost(postDTO);
            response.sendRedirect("jsp/rateComment.jsp?success=general");
        } catch (PersistenciaException ex) {
            response.sendRedirect("jsp/rateComment.jsp?error=general");
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
