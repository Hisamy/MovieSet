<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Opinions</title>
        <link rel="stylesheet" href="../css/comentarios.css">
        <link rel="shortcut icon" href="../images/icon.png" type="image/x-icon">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="../js/showPosts.js"></script>
        <script src="../js/deletePost.js"></script>
    </head>
    <body>
        <jsp:include page="fragmentos/header.jsp" />
        <main>
            <div class="main-content">
                <section class="comment-section">
                    <div class="section-posts">
                        <h2 class="section-title">TOP COMMENTS</h2>
                        <!-- Posts will be dynamically inserted here by JavaScript -->
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
            </div>
        </main>
    </body>
</html>