<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Opinions</title>
        <link rel="stylesheet" href="../css/comentarios.css">
        <link rel="shortcut icon" href="../images/icon.png" type="image/x-icon">
    </head>
    <body>
        <jsp:include page="fragmentos/header.jsp" />
        <main>
            <div class="main-content">
                <section class="comment-section">
                    <div class="section-posts">
                        <h2 class="section-title">TOP COMMENTS</h2>
                    <div class="comment">
                        <div class="comment-header">
                            <div class="comment-text">Barbie</div>
                            <div class="comment-menu">
                                <button class="menu-dots">⋮</button>
                                <div class="menu-dropdown">
                                    <button class="menu-item">pin</button>
                                    <button class="menu-item">delete</button>
                                </div>
                            </div>
                        </div>
                        <div class="comment-subtext">s(he's) bro(ken)</div>
                        <div class="stars">
                            <img src="../images/yellow-star.png" alt="yellow-star">
                            <img src="../images/yellow-star.png" alt="yellow-star">
                            <img src="../images/yellow-star.png" alt="yellow-star">
                            <img src="../images/yellow-star.png" alt="yellow-star">
                            <img src="../images/white-star.png" alt="white-star">
                        </div>
                    </div>
                    </div>
                    <div class="make-post">
                        <h2>MAKE A POST</h2>
                        <div class="movie-posters">
                            <img src="https://image.tmdb.org/t/p/original/fNtqD4BTFj0Bgo9lyoAtmNFzxHN.jpg" alt="Movie 1" class="movie-poster">
                            <img src="../images/Howl's_Moving_Castle.webp" alt="Movie 2" class="movie-poster">
                            <img src="../images/Leyenda_Nahuala.webp" alt="Movie 3" class="movie-poster">
                        </div>
                    </div>
                </section>
        </main>
    </body>
</html>