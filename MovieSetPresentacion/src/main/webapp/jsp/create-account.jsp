<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create account</title>
        <link rel="shortcut icon" href="../images/icon.png" type="image/x-icon">
        <link rel="stylesheet" href="../css/create-account.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    </head>
    <body>
          

        <div class="container">
            <h1>JOIN THE COMMUNITY</h1>
            <p class="subtitle">Welcome to Movieset, create your account</p>
            <form class="signup-form" action="${pageContext.request.contextPath}/SVCreateAccount" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required>
                </div>

                <div class="form-group">
                    <label for="email">E-mail</label>
                    <input type="email" id="email" name="email" required>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>

                <div class="form-group">
                    <label for="repeat-password">Repeat password</label>
                    <input type="password" id="repeat-password" name="repeat-password" required>
                </div>
                <!--
               <div class="form-group">
                    <label for="avatar">Choose your avatar</label>
                    <input name="avatar" type="file" id="id" accept="image/png,image/jpeg">  
                </div>  -->
                
                <button type="submit" class="create-account-btn">CREATE ACCOUNT</button>
            </form>
        </div>
    </body>
</html>
