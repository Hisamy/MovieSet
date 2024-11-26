<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>MOVIESET</title>
        <link rel="stylesheet" href="../css/index.css">
        <link rel="shortcut icon" href="../images/icon.png" type="image/x-icon">
    </head>

    <body>
        <jsp:include page="fragmentos/header.jsp" />
        <main>
            <section class="hero">
                <img src="../images/a-trip-to-the-moon.png" alt="A trip to the moon" class="polaroid">
                <div class="hero-text">
                    <h1>RATE YOUR <span>FAVORITE</span> MOVIES, AND DON'T FORGET THE <span>TRASHY</span> ONES TOO.</h1>
                </div>
            </section>

            <section class="movie-section" id="films">
                <h2>POPULAR FILMS</h2>
                <div class="movie-carousel">
                    <button class="carousel-button left">&#8249;</button>
                    <div class="movie-list">
                        <div class="movie-item">
                            <a href="rate-comment.html">
                                <img src="https://s3.amazonaws.com/nightjarprod/content/uploads/sites/249/2024/09/16145201/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK-scaled.jpg" alt="Fight Club">
                                <p>Fight Club</p>
                            </a>  
                        </div>
                        <div class="movie-item">
                            <img src="https://image.tmdb.org/t/p/original/fNtqD4BTFj0Bgo9lyoAtmNFzxHN.jpg" alt="Barbie">
                            <p>Barbie</p>
                        </div>
                        <div class="movie-item">
                            <img src="../images/Howl's_Moving_Castle.webp" alt="Howl's Moving Castle">
                            <p>Howl's Moving Castle</p>
                        </div>
                        <div class="movie-item">
                            <img src="https://m.media-amazon.com/images/I/71xDtUSyAKL._AC_UF894,1000_QL80_.jpg" alt="Oppenheimer">
                            <p>Oppenheimer</p>
                        </div>
                        <div class="movie-item">
                            <img src="https://d135u4jtzauizi.cloudfront.net/MAXXXINE_A_1SHT.jpg" alt="Maxxxine">
                            <p>Maxxxine</p>
                        </div>
                        <div class="movie-item">
                            <img src="https://m.media-amazon.com/images/M/MV5BOWU3YTkxMjYtYTdlMi00NDQ1LThiMjQtNzhmMTFlZmE2ZTU0XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg" alt="Look Back">
                            <p>Look Back</p>
                        </div>
                    </div>

                    <button class="carousel-button right">&#8250;</button>
                </div>
            </section>

            <section class="movie-section">
                <h2>MEXICAN FILMS</h2>
                <div class="movie-carousel">
                    <button class="carousel-button left">&#8249;</button>
                    <div class="movie-list">
                        <div class="movie-item">
                            <img src="https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p27383_p_v8_ah.jpg" alt="Amores perros">
                            <p>Amores perros</p>
                        </div>
                        <div class="movie-item">
                            <img src="https://i.pinimg.com/originals/b1/fd/e0/b1fde0d9625d397306b704b67897b07c.jpg" alt="Amarte duele">
                            <p>Amarte duele</p>
                        </div>
                        <div class="movie-item">
                            <img src="https://m.media-amazon.com/images/M/MV5BMzdmYzZkODEtMWFmYy00YTk3LWE0ZTEtMjcwOTViZmRiNGUwXkEyXkFqcGc@._V1_.jpg" alt="Una película de huevos">
                            <p>Una película de huevos</p>
                        </div>
                        <div class="movie-item">
                            <img src="../images/Leyenda_Nahuala.webp" alt="La leyenda de la Nahuala">
                            <p>La leyenda de la Nahuala</p>
                        </div>
                        <div class="movie-item">
                            <img src="https://www.retinalatina.org/wp-content/uploads/2021/09/po-perfumedevioletas.png" alt="Perfume de violetas">
                            <p>Perfume de violetas</p>
                        </div>
                        <div class="movie-item">
                            <img src="https://m.media-amazon.com/images/M/MV5BN2U0N2YzYzktODU0Yi00MmM3LWI3NTEtYmMxODQwNzM2NmUwXkEyXkFqcGc@._V1_.jpg" alt="Chicuarotes">
                            <p>Chicuarotes</p>
                        </div>

                    </div>

                    <button class="carousel-button right">&#8250;</button>
                </div>
            </section>
        </main>
    </body>

</html>