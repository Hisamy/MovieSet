function showComments(postElement, comments) {
  // Create the comments container
  const commentsContainer = document.createElement('div');
  commentsContainer.classList.add('comments-container');

  // Add each comment to the container
  comments.forEach((comment) => {
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
    commentsContainer.appendChild(commentElement);
  });

  // Append the comments container to the post element
  postElement.appendChild(commentsContainer);
}