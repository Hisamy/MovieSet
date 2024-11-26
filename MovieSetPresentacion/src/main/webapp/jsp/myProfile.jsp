<!DOCTYPE html>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My profile</title>
    <link rel="stylesheet" href="../css/my-profile.css">
    <link rel="shortcut icon" href="../images/icon.png" type="image/x-icon">
</head>
<body>
    <header class="header">
        <img src="../images/1ef9ec7712c7cc36190c9f6f48b09501.png" alt="Profile" class="profile-image">
        <div class="profile-info">
            <div class="profile-title">MY PROFILE</div>
            <div class="profile-name">${sessionScope.usuario.username}</div>
        </div>
    </header>

    <div class="main-content">
        <!-- Top Comments Section -->
        <div class="comment-section">
            <h2 class="section-title">TOP COMMENTS</h2>
            <div class="comment">
                <div class="comment-text">Fight Club</div>
                <div class="comment-subtext">Literally me</div>
                <div class="stars">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/white-star.png" alt="white-star">
                </div>
            </div>
            <div class="comment">
                <div class="comment-text">The substance</div>
                <div class="comment-subtext">Very mindful very demi moore</div>
                <div class="stars">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/white-star.png" alt="white-star">
                    <img src="../images/white-star.png" alt="white-star">
                </div>
            </div>
        </div>

        <!-- All Comments Section -->
        <div class="comment-section">
            <h2 class="section-title">ALL COMMENTS</h2>
            <div class="comment">
                <div class="comment-text">Fight Club</div>
                <div class="comment-subtext">Literally me</div>
                <div class="stars">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/white-star.png" alt="white-star">
                </div>
            </div>
            <div class="comment">
                <div class="comment-text">The substance</div>
                <div class="comment-subtext">Very mindful very demi moore</div>
                <div class="stars">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/white-star.png" alt="white-star">
                    <img src="../images/white-star.png" alt="white-star">
                </div>
            </div>
            <div class="comment">
                <div class="comment-text">Barbie</div>
                <div class="comment-subtext">s(he's) bro(ken)</div>
                <div class="stars">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/white-star.png" alt="white-star">
                </div>
            </div>
            <div class="comment">
                <div class="comment-text">SEVEN</div>
                <div class="comment-subtext">That ending...</div>
                <div class="stars">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/white-star.png" alt="white-star">
                </div>
            </div>
            <div class="comment">
                <div class="comment-text">Barbie</div>
                <div class="comment-subtext">Meow meow meow meoww</div>
                <div class="stars">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/yellow-star.png" alt="yellow-star">
                    <img src="../images/white-star.png" alt="white-star">
                </div>
            </div>
        </div>

        <!-- Favorite Movies Section -->
        <div class="movie-carousel">
            <h2 class="section-title">FAVORITE MOVIES</h2>
            <img src="../images/Howl's_Moving_Castle.webp" alt="Howl's Moving Castle" class="movie-poster">
            <img src="../images/Leyenda_Nahuala.webp" alt="La Leyenda de la Nahuala" class="movie-poster">
            <img src="https://image.tmdb.org/t/p/original/fNtqD4BTFj0Bgo9lyoAtmNFzxHN.jpg"  alt="Barbie" class="movie-poster">
        </div>
    </div>
   
</body>
</html>