/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Logger;
import org.itson.moviesetdtos.UsuarioDTO;

/**
 *
 * @author castr
 */
@WebFilter(filterName = "FiltroAutenticacion", urlPatterns = {"/jsp/*"})
public class FiltroAutenticacion implements Filter {

    private static final Logger LOGGER = Logger.getLogger(FiltroAutenticacion.class.getName());

    private static final String[] PUBLIC_URLS = {
        "/jsp/create-account.jsp",
        "/jsp/signIn.jsp",
        "/jsp/index.jsp",
        "/Login"
    };

    private static final String[] AUTHENTICATED_URLS = {
        "/jsp/myProfile.jsp",
        "/jsp/rateComment.jsp",
        "/jsp/moviedle.jsp",
        "/jsp/comentarios.jsp"
    };

    private static final String[] ADMIN_URLS = {
        "/jsp/admin.jsp"
    };

    /*
    * Método principal del filtro que procesa todas las solicitudes HTTP.
    * Verifica la autenticación y autorización del usuario para acceder a las diferentes URLs.
    * 
    * @param request La solicitud HTTP recibida
    * @param response La respuesta HTTP a enviar
    * @param chain La cadena de filtros a ejecutar
    * @throws IOException Si ocurre un error de entrada/salida
    * @throws ServletException Si ocurre un error en el servlet
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String ruta = getRutaSolicitada(httpRequest);
        LOGGER.info("Filtro ejecutándose para: " + ruta);

        HttpSession session = httpRequest.getSession(false);
        UsuarioDTO usuarioDTO = null;
        if (session != null) {
            usuarioDTO = (UsuarioDTO) session.getAttribute("usuario");
        }
        boolean isAuthenticated = (usuarioDTO != null);

        // Obtener la página anterior o establecer index por defecto
        String previousPage = httpRequest.getHeader("Referer");
        if (previousPage == null || previousPage.isEmpty()) {
            previousPage = httpRequest.getContextPath() + "/jsp/index.jsp";
        }

        // Manejo de rutas públicas
        if (isPublicURL(ruta)) {
            LOGGER.info("Accediendo a ruta pública: " + ruta);
            // Si está autenticado no puede acceder a login/registro
            if (isAuthenticated && (ruta.contains("signIn.jsp") || ruta.contains("createAccount.jsp"))) {
                LOGGER.info("Usuario autenticado intentando acceder a página de login/registro");
                httpResponse.sendRedirect(previousPage);
                return;
            }
            chain.doFilter(request, response);
            return;
        }

        // Si no está autenticado, redirige a login
        if (!isAuthenticated) {
            LOGGER.info("Usuario no autenticado intentando acceder a: " + ruta);
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/signIn.jsp");
            return;
        }

        // Manejo de rutas autenticadas
        if (isAuthenticatedURL(ruta)) {
            LOGGER.info("Accediendo a ruta autenticada: " + ruta);
            chain.doFilter(request, response);
            return;
        }

        // Manejo de rutas admin
        if (isAdminURL(ruta)) {
            LOGGER.info("Verificando acceso admin para usuario con rol: " + usuarioDTO.getRol());
            if ("admin".equals(usuarioDTO.getRol())) {
                chain.doFilter(request, response);
                return;
            } else {
                LOGGER.info("Acceso denegado a página de admin");
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/index.jsp");
                return;
            }
        }

        // Ruta no definida
        LOGGER.info("Ruta no definida, redirigiendo a index: " + ruta);
        httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/index.jsp");
    }

    /*
    * Extrae la ruta solicitada de la petición HTTP,
    * eliminando el contexto de la aplicación.
    *
    * @param request La solicitud HTTP
    * @return La ruta solicitada sin el contexto de la aplicación
     */
    private String getRutaSolicitada(HttpServletRequest request) {
        String uriSolicitada = request.getRequestURI();
        return uriSolicitada.substring(request.getContextPath().length());
    }

    /*
    * Verifica si la ruta especificada corresponde a una URL pública.
    *
    * @param path La ruta a verificar
    * @return true si la ruta es pública, false en caso contrario
     */
    private boolean isPublicURL(String path) {
        for (String url : PUBLIC_URLS) {
            if (path.equals(url)) {
                return true;
            }
        }
        return false;
    }

    /*
    * Verifica si la ruta especificada corresponde a una URL que requiere autenticación.
    *
    * @param path La ruta a verificar
    * @return true si la ruta requiere autenticación, false en caso contrario
     */
    private boolean isAuthenticatedURL(String path) {
        for (String url : AUTHENTICATED_URLS) {
            if (path.equals(url)) {
                return true;
            }
        }
        return false;
    }

    /*
    * Verifica si la ruta especificada corresponde a una URL de administrador.
    *
    * @param path La ruta a verificar
    * @return true si la ruta es de administrador, false en caso contrario
     */
    private boolean isAdminURL(String path) {
        for (String url : ADMIN_URLS) {
            if (path.equals(url)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) {
        LOGGER.info("Inicializando FiltroAutenticacion");
    }

    @Override
    public void destroy() {
        LOGGER.info("Destruyendo FiltroAutenticacion");
    }
}
