<%-- 
    Document   : header
    Created on : Nov 17, 2024, 7:55:30 PM
    Author     : hisam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
    <header>
        <nav>
            <div class="logo">
                <img src="../images/Movieset.png" alt="logo-movieset">
            </div>
            <div class="nav-links">
                <%-- Usuario no autenticado --%>
                <c:if test="${empty sessionScope.usuario}">
                    <a href="${pageContext.request.contextPath}/jsp/signIn.jsp">Sign in</a>
                    <a href="${pageContext.request.contextPath}/jsp/create-account.jsp">Create account</a>
                    <a href="${pageContext.request.contextPath}/jsp/index.jsp#films">Films</a>
                </c:if>

                <%-- Usuario autenticado --%>
                <c:if test="${not empty sessionScope.usuario}">
                    <a href="${pageContext.request.contextPath}/jsp/index.jsp#films">Films</a>
                    <a href="${pageContext.request.contextPath}/jsp/moviedle.jsp">Moviedle</a>
                    <a href="${pageContext.request.contextPath}/jsp/myProfile.jsp">Mi Perfil</a>

                    <%-- Si es admin mostrar panel admin --%>
                    <c:if test="${sessionScope.usuario.rol eq 'admin'}">
                        <a href="${pageContext.request.contextPath}/jsp/admin.jsp">Admin Panel</a>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/Logout">Cerrar Sesión</a>
                </c:if>
            </div>
            <div class="search">
                <img src="../images/Search.png" alt="search">
                <input type="search">
            </div>
        </nav>
    </header>
</html>
