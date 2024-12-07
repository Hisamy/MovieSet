package servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.itson.entidades.ComentarioEntity;
import org.itson.mapeomovieset.excepciones.PersistenciaException;
import org.itson.mapeomovieset.facade.PostFacade;
import org.itson.moviesetdtos.ComentarioDTO;

import java.io.IOException;
import java.io.PrintWriter;
import org.itson.adapter.ComentarioAdapter;
import org.itson.mapeomovieset.facade.CommentFacade;

public class SVAddComment extends HttpServlet {
    private CommentFacade commentFacade;
    private ComentarioAdapter comentarioAdapter;

    public void init() throws ServletException {
        this.commentFacade = new CommentFacade();
        this.comentarioAdapter = new ComentarioAdapter();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        // Obtener los datos del comentario desde la solicitud
        ComentarioDTO comentarioDTO = gson.fromJson(request.getReader(), ComentarioDTO.class);
        // Crear una entidad de comentario y guardarla en la base de datos
        ComentarioEntity comentario = comentarioAdapter.DTOToEntity(comentarioDTO);
        commentFacade.agregarComentario(comentario, comentarioDTO.getPostId());
        // Enviar una respuesta con el comentario recién creado
        out.print(gson.toJson(comentario));
        out.flush();
    }
}