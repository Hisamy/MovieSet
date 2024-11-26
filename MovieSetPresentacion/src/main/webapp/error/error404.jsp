<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Error 400 - Bad Request</title>
        <link rel="stylesheet" href="../css/error.css">
        <link rel="shortcut icon" href="../images/icon.png" type="image/x-icon">
    </head>
    <body>
        <header>
            <nav>
                <div class="logo">
                    <img src="../images/Movieset.png" alt="logo-movieset">
                </div>
            </nav>
        </header>

        <main>
            <section class="error-section">
                <h1>Oops! Bad Request.</h1>
                <p>The request could not be understood. Please try again.</p>
                <a href="<c:url value='../jsp/index.jsp'/>" class="btn-home">Back to Home</a>
            </section>
        </main>

        <footer>
            <p>&copy; 2024 MovieSet. All Rights Reserved.</p>
        </footer>
    </body>
</html>
