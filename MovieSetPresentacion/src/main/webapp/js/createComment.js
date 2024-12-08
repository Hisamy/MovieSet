function createCommentSection(postElement) {
  // Create the comment input and button
  const commentSection = document.createElement('div');
  commentSection.classList.add('comment-section');

  const commentInput = document.createElement('input');
  commentInput.type = 'text';
  commentInput.placeholder = 'Write a comment...';
  commentInput.classList.add('comment-input');

  const sendButton = document.createElement('button');
  sendButton.textContent = 'Send';
  sendButton.classList.add('comment-send-button');

  // Append the comment input and button to the comment section
  commentSection.appendChild(commentInput);
  commentSection.appendChild(sendButton);

  // Append the comment section to the post element
  postElement.appendChild(commentSection);

  // Add event listener to the "Send" button
  sendButton.addEventListener('click', () => {
    const comment = commentInput.value.trim();
    if (comment) {
      // Call a function to save the comment
      const postId = getPostId(postElement);
      saveComment(postId, comment);
      commentInput.value = '';
    }
  });
}

function saveComment(postId, newComment) {
  // Enviar el nuevo comentario al servidor
  fetch(`/comentarios/comment?postId=${postId}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      autor: 'Anonymous', // Reemplaza con el autor real
      texto: newComment
    })
  })
  .then(response => response.json())
  .then(data => {
    console.log(data);
    // Crear un nuevo elemento de comentario y agregarlo a la interfaz de usuario
    const newCommentElement = createCommentElement({
      author: 'Anonymous', // Reemplaza con el autor real
      text: newComment
    });
    const commentsContainer = getCommentsContainer(postElement);
    commentsContainer.appendChild(newCommentElement);
  })
  .catch(error => {
    console.error('Error guardando el comentario:', error);
  });
}

function createCommentElement(comment) {
  const commentElement = document.createElement('div');
  commentElement.classList.add('comment');

  const authorElement = document.createElement('div');
  authorElement.classList.add('comment-author');
  authorElement.textContent = comment.author;

  const textElement = document.createElement('div');
  textElement.classList.add('comment-text');
  textElement.textContent = comment.text;

  commentElement.appendChild(authorElement);
  commentElement.appendChild(textElement);

  return commentElement;
}

// Funciones de apoyo
function getPostId(postElement) {
  // Implementa la lógica para obtener el ID del post
  // a partir del elemento del post
  return postElement.dataset.postId;
}

function getCommentsContainer(postElement) {
  // Implementa la lógica para obtener el contenedor
  // de comentarios a partir del elemento del post
  return postElement.querySelector('.comments-container');
}