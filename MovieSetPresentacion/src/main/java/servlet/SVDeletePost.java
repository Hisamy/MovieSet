package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import org.itson.mapeomovieset.facade.CreatePostFacade;
import org.itson.mapeomovieset.facade.ICreatePostFacade;
import org.itson.moviesetdtos.PostDTO;

public class SVDeletePost extends HttpServlet {

    private ICreatePostFacade createPostFacade;
    private PostDTO postDTO;
    private Gson gson;

    public SVDeletePost() {
        createPostFacade = new CreatePostFacade();
        postDTO = new PostDTO();
        gson = new Gson();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String postId = request.getParameter("id");
        PrintWriter out = response.getWriter();
        try {
            boolean deleted = createPostFacade.deletePost(postId);
            if (deleted) {
                response.setStatus(HttpServletResponse.SC_OK);
                out.print(gson.toJson("Post eliminado exitosamente"));
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.print(gson.toJson("No se encontró el post a eliminar"));
            }
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson("Error al eliminar el post: " + ex.getMessage()));
        }
        out.flush();
    }
}
