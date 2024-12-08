package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import org.itson.moviesetdtos.ComentarioDTO;
import org.itson.moviesetdtos.UsuarioDTO;

import java.io.IOException;
import java.io.PrintWriter;
import org.itson.mapeomovieset.facade.CommentFacade;
import org.itson.mapeomovieset.facade.ICommentFacade;

public class SVCreateComment extends HttpServlet {

    private ICommentFacade comentarioFacade;

    public void init() throws ServletException {
        this.comentarioFacade = new CommentFacade();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        try {
            // Leer el cuerpo de la solicitud y convertirlo en ComentarioDTO
            ComentarioDTO newComment = gson.fromJson(request.getReader(), ComentarioDTO.class);

            // Obtener la sesión actual
            HttpSession session = request.getSession(false);
            if (session == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.print(gson.toJson("No se encontró una sesión activa. Inicia sesión nuevamente."));
                out.flush();
                return;
            }

            // Obtener el usuario autenticado de la sesión
            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("user");
            if (usuario == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.print(gson.toJson("El usuario no está autenticado. Inicia sesión nuevamente."));
                out.flush();
                return;
            }

            // Validar que el postId no sea nulo ni vacío
            if (newComment.getPostId() == null || newComment.getPostId().isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print(gson.toJson("El ID del post no puede estar vacío."));
                out.flush();
                return;
            }

            // Asignar el usuario al comentario
            newComment.setAutor(usuario);

            // Guardar el comentario utilizando el facade
            comentarioFacade.agregarComentario(newComment, newComment.getPostId());

            // Respuesta exitosa
            out.print(gson.toJson("Comentario guardado correctamente."));
            out.flush();

        } catch (JsonSyntaxException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print(gson.toJson("Error en el formato de JSON: " + e.getMessage()));
            out.flush();
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson("Error al procesar la solicitud: " + e.getMessage()));
            out.flush();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson("Ocurrió un error inesperado: " + e.getMessage()));
            out.flush();
        }
    }
}
