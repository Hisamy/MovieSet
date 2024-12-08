package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.itson.moviesetdtos.ComentarioDTO;
import org.itson.moviesetdtos.UsuarioDTO;

import java.io.IOException;
import java.io.PrintWriter;
import org.itson.mapeomovieset.facade.CommentFacade;

public class SVCreateComment extends HttpServlet {
    private CommentFacade comentarioFacade;

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
            // Obtener el ID del post del que se va a guardar el comentario
            String postId = request.getParameter("postId");

            // Recibir el nuevo comentario del cliente
            ComentarioDTO newComment = gson.fromJson(request.getReader(), ComentarioDTO.class);
            newComment.setPostId(postId);
            UsuarioDTO autor = new UsuarioDTO();
            autor.setName("Anonymous");
            newComment.setAutor(autor); // Reemplaza con el autor real

            // Guardar el comentario en la base de datos
            comentarioFacade.agregarComentario(newComment, postId);
            // Devolver una respuesta confirmando que se guardó el comentario
            out.print(gson.toJson("Comentario guardado"));
            out.flush();
        } catch (JsonSyntaxException | IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson("Error guardando el comentario: " + e.getMessage()));
            out.flush();
        }
    }
}