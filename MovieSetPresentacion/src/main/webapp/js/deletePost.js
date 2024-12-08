window.deletePost = function (postId, postElement) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: "Esta acción no se puede deshacer.",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, eliminar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            fetch(`../SVDeletePost?id=${postId}`, {
                method: 'DELETE'
            })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Error al eliminar el post');
                        }
                        return response.json();
                    })
                    .then(data => {
                        // Si la eliminación fue exitosa, removemos el elemento del DOM
                        postElement.remove();
                        Swal.fire(
                                '¡Eliminado!',
                                'El post ha sido eliminado exitosamente.',
                                'success'
                                );
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        Swal.fire(
                                'Error',
                                'No se pudo eliminar el post. Por favor, intenta de nuevo.',
                                'error'
                                );
                    });
        }
    });
}