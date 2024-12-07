/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.mapeomovieset.facade.PostFacade;
import org.itson.moviesetdtos.PostDTO;

/**
 *
 * @author hisam
 */
public class SVShowMovies extends HttpServlet {
 private PostFacade postFacade;

    public void init() throws ServletException {
        this.postFacade = new PostFacade();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        try {
            List<PostDTO> posts = postFacade.consultarPost();
            String jsonPosts = gson.toJson(posts);
            out.print(jsonPosts);
            out.flush();
        } catch (FindException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson("Error fetching posts: " + e.getMessage()));
            out.flush();
        }
    }
}


