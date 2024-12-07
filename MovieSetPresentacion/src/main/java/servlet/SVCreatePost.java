import java.io.IOException;
import java.util.Date;
import java.io.BufferedReader;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.itson.mapeomovieset.excepciones.PersistenciaException;
import org.itson.mapeomovieset.facade.CreatePostFacade;
import org.itson.mapeomovieset.facade.ICreatePostFacade;
import org.itson.moviesetdtos.PostDTO;
import org.itson.moviesetdtos.UsuarioDTO;

public class SVCreatePost extends HttpServlet {
    private ICreatePostFacade createPostFacade;
    private PostDTO postDTO;
    private Gson gson;

    public SVCreatePost() {
        createPostFacade = new CreatePostFacade();
        postDTO = new PostDTO();
        gson = new Gson();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            
            PostRequestBody postRequest = gson.fromJson(sb.toString(), PostRequestBody.class);
            
            HttpSession session = request.getSession();
            UsuarioDTO usuarioSesion = (UsuarioDTO) session.getAttribute("usuario");
            
            if (usuarioSesion == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("User not logged in");
                return;
            }
            
            postDTO.setAutor(usuarioSesion);
            postDTO.setContenido(postRequest.textPost);
            postDTO.setFechaPublicacion(new Date());
            postDTO.setAnclado(false); 
            
            Boolean postCreated = createPostFacade.sendPost(postDTO);
            
            if (postCreated) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("Post created successfully");
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Failed to create post");
            }
        } catch (JsonSyntaxException | IOException | PersistenciaException e) {            
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error processing request: " + e.getMessage());
        }
    }
    
    private static class PostRequestBody {
        String textPost;
    }
}