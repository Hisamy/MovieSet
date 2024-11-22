package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Hisamy Cinco Cota
 * @author Asiel Apodaca Monge
 * @author Gael Rafael Castro Molina
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 500 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)

@WebServlet(name = "SVCreateAccount", urlPatterns = {"/CreateAccount"})
public class SVCreateAccount extends HttpServlet {

    /**
     * Maneja solicitudes POST enviadas al servlet, procesa datos del
     * formulario, valida contraseñas y guarda la imagen del avatar en el
     * servidor.
     *
     * @param request el objeto HttpServletRequest que contiene la solicitud del
     * cliente.
     * @param response el objeto HttpServletResponse para enviar la respuesta al
     * cliente.
     * @throws ServletException si ocurre un error específico del servlet.
     * @throws IOException si ocurre un error de E/S durante el manejo de la
     * solicitud.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Obtener los datos del formulario
        String username = request.getParameter(
                "username");
        String email = request.getParameter(
                "email");
        String password = request.getParameter(
                "password");
        String repeatPassword = request.getParameter(
                "repeat-password");
//        Part filePart = request.getPart(
//                "avatar");
        System.out.println("Username: "+username);
        System.out.println("Email: "+username);
        System.out.println("Password: "+username);
        System.out.println("RepeatPassword: "+username);
        
//        try {
//            saveImage(filePart);
//
//            if (password.equals(repeatPassword)) {
//                successAlert(request, response);
//            } else {
//                request.setAttribute("message", "Passwords don't match");
//                request.getRequestDispatcher("create-account.jsp").forward(request, response);
//            }
//            
//            
//        } catch (RuntimeException e) {
//            request.setAttribute("message", "Error: " + e.getMessage());
//            request.getRequestDispatcher("error.jsp").forward(request, response);
//        }

    }

    private void successAlert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Establece atributos para mostrar el alert
        request.setAttribute("showSuccessAlert", true);
        request.setAttribute("alertTitle", "Welcome!");
        request.setAttribute("alertText", "Now it’s your turn to rate all the movies you want! Go ahead, be the ultimate movie critic!");
        
        // Redirige de vuelta al mismo JSP del formulario
        request.getRequestDispatcher("create-account.jsp").forward(request, response);
    }
    

    /**
     * Guarda un archivo de imagen en el servidor en un directorio designado.
     *
     * @param filePart el archivo cargado por el cliente como parte de la
     * solicitud.
     * @throws NullPointerException si el archivo o su nombre es nulo o vacío.
     * @throws RuntimeException si ocurre un error de E/S durante el guardado.
     */
    private void saveImage(Part filePart) {
        try {
            // Validar si el archivo es nulo
            if (filePart == null) {
                throw new NullPointerException("Avatar is null.");
            }

            String fileName = getFileName(filePart);
            if (fileName != null && !fileName.isEmpty()) {
                // Guardar el archivo en el servidor
                String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir(); // Crear el directorio si no existe
                }
                filePart.write(uploadPath + File.separator + fileName);
            } else {
                throw new NullPointerException("File name is null or empty.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error saving the image: " + e.getMessage(), e);
        }
    }

    /**
     * Extrae el nombre del archivo del encabezado content-disposition de la
     * parte cargada.
     *
     * @param part el objeto Part que contiene el archivo y sus metadatos.
     * @return el nombre del archivo, o null si no se encuentra.
     */
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String content : contentDisposition.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }

}
