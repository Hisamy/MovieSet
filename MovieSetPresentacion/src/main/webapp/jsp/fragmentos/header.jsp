

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <header>
        <nav>
            <div class="logo">
                <img src="../images/Movieset.png" alt="logo-movieset">
            </div>
            <div class="nav-links">
                <a href="signIn.jsp">Sign in</a>
                <a href="create-account.jsp">Create account</a>
                <a href="index.jsp#films">Films</a>
                <a href="moviedle.jsp">Moviedle</a>

            </div>
            <div class="search">
                <img src="../images/Search.png" alt="search">
                <input type="search">
            </div>
            <div class="Perfil">
                <c:if test="${sessionScope.usuario != null}">
                    <a href="myProfile.jsp"> ${sessionScope.usuario.username}</a>
                </c:if>
            </div>
        </nav>
    </header>
</html>
