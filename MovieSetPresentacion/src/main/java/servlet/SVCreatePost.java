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
import java.text.SimpleDateFormat;
import java.util.Date;
import org.itson.mapeomovieset.facade.CreateAccountFacade;
import org.itson.mapeomovieset.facade.ICreateAccountFacade;
import org.itson.moviesetdtos.PostDTO;

/**
 *
 * @author hisam
 */
public class SVCreatePost extends HttpServlet {

    private ICreateAccountFacade createAccountFacade;
    private PostDTO postDTO;
    public SVCreatePost() {
        createAccountFacade = new CreateAccountFacade();
        postDTO = new PostDTO();
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String autor = request.getParameter("autor");
        String comment = request.getParameter("comment");
        Date datePost = new Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
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
