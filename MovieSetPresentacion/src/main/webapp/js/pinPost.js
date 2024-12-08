window.pinPost = function (postId, postElement) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "¿Quieres fijar este post en la parte superior?",
        icon: 'info',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, fijar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            fetch(`../SVShowPosts?id=${postId}`, {
                method: 'POST'
            })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Error al fijar el post');
                        }
                        return response.json();
                    })
                    .then(data => {
                        // Suponiendo que el servidor haya confirmado la fijación, podemos cambiar la UI
                        postElement.classList.add('pinned');
                        Swal.fire(
                                '¡Fijado!',
                                'El post ha sido fijado en la parte superior.',
                                'success'
                                );
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        Swal.fire(
                                'Error',
                                'No se pudo fijar el post. Por favor, intenta de nuevo.',
                                'error'
                                );
                    });
        }
    });
}
