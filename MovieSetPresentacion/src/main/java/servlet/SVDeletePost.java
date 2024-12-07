package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
