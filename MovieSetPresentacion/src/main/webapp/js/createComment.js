window.createComment = function (postElement, postId) {
    // Crear el formulario de comentario si no existe
    let commentForm = postElement.querySelector('.comment-form');
    if (!commentForm) {
        commentForm = document.createElement('div');
        commentForm.classList.add('comment-form');
        commentForm.innerHTML = `
            <textarea class="comment-input" placeholder="Escribe un comentario..."></textarea>
            <button class="comment-submit">Enviar</button>
        `;
        postElement.appendChild(commentForm);
        // Agregar el evento al botón de enviar
        const submitButton = commentForm.querySelector('.comment-submit');
        const textarea = commentForm.querySelector('.comment-input');
        submitButton.addEventListener('click', () => {
            const commentText = textarea.value.trim();
            if (!commentText) {
                Swal.fire({
                    title: 'Error',
                    text: 'El comentario no puede estar vacío',
                    icon: 'error',
                    confirmButtonColor: '#D9B855',
                    background: '#1f2b45',
                    color: '#f6f6f6'
                });
                return;
            }
            // Deshabilitar el botón mientras se envía
            submitButton.disabled = true;
            submitButton.textContent = 'Enviando...';

            // Preparar el cuerpo de la solicitud de manera más explícita
            const requestBody = JSON.stringify({
                contenido: commentText,
                postId: postId.toString()
            });

            console.log('Sending request body:', requestBody); // Log the request body

            // Enviar el comentario al servidor
            fetch('../SVCreateComment', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: requestBody
            })
                    .then(response => {
                        console.log('Response status:', response.status); // Log response status
                        if (!response.ok) {
                            return response.text().then(text => {
                                throw new Error(text);
                            });
                        }
                        return response.json();
                    })
                    .then(data => {
                        // Limpiar el textarea
                        textarea.value = '';
                        // Mostrar mensaje de éxito
                        Swal.fire({
                            title: '¡Éxito!',
                            text: 'Comentario publicado correctamente',
                            icon: 'success',
                            confirmButtonColor: '#D9B855',
                            background: '#1f2b45',
                            color: '#f6f6f6'
                        });
                        // Recargar los comentarios
                        window.showComments(postElement, postId);
                    })
                    .catch(error => {
                        console.error('Full error:', error);
                        Swal.fire({
                            title: 'Error',
                            text: 'No se pudo publicar el comentario. Por favor, intenta de nuevo.' + error.message,
                            icon: 'error',
                            confirmButtonColor: '#D9B855',
                            background: '#1f2b45',
                            color: '#f6f6f6'
                        });
                    })
                    .finally(() => {
                        // Reactivar el botón
                        submitButton.disabled = false;
                        submitButton.textContent = 'Enviar';
                    });
        });
    }
};