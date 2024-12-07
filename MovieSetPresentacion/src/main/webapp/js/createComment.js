function addComment(postId, comentarioContent, autor) {
  const comentarioDTO = {
    postId: postId,
    contenido: comentarioContent,
    autor: autor
  };

  fetch('/movieset/SVAddComment', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(comentarioDTO)
  })
  .then(response => response.json())
  .then(data => {
    // Actualizar la interfaz de usuario con el nuevo comentario
    displayComment(data);
  })
  .catch(error => {
    console.error('Error al agregar el comentario:', error);
  });
}

function displayComment(comentario) {
  // Código para agregar el nuevo comentario a la interfaz de usuario
  console.log('Nuevo comentario:', comentario);
}