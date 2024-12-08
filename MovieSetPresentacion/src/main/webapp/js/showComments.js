window.showComments = function (postElement, postId) {
    // Primero verificamos si ya existe un contenedor de comentarios
    let commentsContainer = postElement.querySelector('.comments-container');
    if (!commentsContainer) {
        commentsContainer = document.createElement('div');
        commentsContainer.classList.add('comments-container');
        postElement.appendChild(commentsContainer);
    }

    // Mostramos un loading mientras cargamos los comentarios
    commentsContainer.innerHTML = '<div class="loading">Cargando comentarios...</div>';

    // Hacemos el fetch de los comentarios
    fetch(`../SVShowComments?postId=${postId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al cargar los comentarios');
                }
                return response.json();
            })
            .then(comments => {
                commentsContainer.innerHTML = ''; // Limpiamos el loading

                // Si no hay comentarios, mostramos un mensaje
                if (comments.length === 0) {
                    commentsContainer.innerHTML = '<div class="no-comments">No hay comentarios aún</div>';
                    return;
                }

                // Agregamos cada comentario
                comments.forEach(comment => {
                    const commentElement = document.createElement('div');
                    commentElement.classList.add('comment-item');

                    commentElement.innerHTML = `
                    <div class="comment-author">${comment.autor ? comment.autor.nombreCompleto : 'Anonymous'}</div>
                    <div class="comment-text">${comment.contenido}</div>
                `;

                    commentsContainer.appendChild(commentElement);
                });
            })
            .catch(error => {
                console.error('Error:', error);
                commentsContainer.innerHTML = `
                <div class="error-message">
                    Error al cargar los comentarios. Por favor, intenta de nuevo.
                </div>
            `;
            });
};