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

    public SVCreatePost() {
        createPostFacade = new CreatePostFacade();
        postDTO = new PostDTO();

    }

    public void procesarSolicitud(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UsuarioDTO usuarioSesion = (UsuarioDTO) session.getAttribute("usuario");

        if (usuarioSesion != null) {
            postDTO.setAutor(usuarioSesion);
            session.setAttribute("autor", usuarioSesion);
            System.out.println("El autor del post es : " + usuarioSesion.getUsername());
            System.out.println("Esto recolecta como autor por parte del post : " + postDTO.getAutor());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        procesarSolicitud(request);

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
