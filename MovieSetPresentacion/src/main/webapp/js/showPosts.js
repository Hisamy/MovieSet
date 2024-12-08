document.addEventListener('DOMContentLoaded', function () {
    const postsContainer = document.querySelector('.section-posts');

    function fetchPosts() {
        fetch('../SVShowPosts')
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(posts => {
                    posts.sort((a, b) => b.anclado - a.anclado);
                    const header = postsContainer.querySelector('h2');
                    postsContainer.innerHTML = '';
                    postsContainer.appendChild(header);
                    posts.forEach(post => {
                        const postElement = createPostElement(post);
                        postsContainer.appendChild(postElement);
                    });
                })
                .catch(error => {
                    console.error('Error fetching posts:', error);
                    postsContainer.innerHTML += `
                    <div class="error-message">
                        Unable to load posts. Please try again later.
                    </div>
                `;
                });
    }

    function createPostElement(post) {
        const postDiv = document.createElement('div');
        postDiv.classList.add('comment');
        postDiv.setAttribute('data-post-id', post.id);

        const headerDiv = document.createElement('div');
        headerDiv.classList.add('comment-header');

        const authorDiv = document.createElement('div');
        authorDiv.classList.add('comment-text');
        authorDiv.textContent = post.autor ? post.autor.nombreCompleto : 'Anonymous';

        const menuDiv = document.createElement('div');
        menuDiv.classList.add('comment-menu');
        menuDiv.innerHTML = `
            <button class="menu-dots">⋮</button>
            <div class="menu-dropdown">
                <button class="menu-item pin">Pin</button>
                <button class="menu-item delete">Delete</button>
                <button class="menu-item comment">Comment</button>
            </div>
        `;

        // Asociar eventos a los botones
        const pinButton = menuDiv.querySelector('.pin');
        pinButton.addEventListener('click', () => {
            const postId = post.id;
            pinPost(postId, postDiv);
        });

        const deleteButton = menuDiv.querySelector('.delete');
        deleteButton.addEventListener('click', () => {
            const postId = post.id;
            deletePost(postId, postDiv);
        });

        const commentButton = menuDiv.querySelector('.comment');
        commentButton.addEventListener('click', () => {
            // Use the new showComments function from the other JS file
            window.showComments(postDiv, post.id);
            
            // Also create the comment input section
            window.createComment(postDiv, post.id);
        });

        headerDiv.appendChild(authorDiv);
        headerDiv.appendChild(menuDiv);

        const contentDiv = document.createElement('div');
        contentDiv.classList.add('comment-subtext');
        contentDiv.textContent = post.contenido;

        const starsDiv = document.createElement('div');
        starsDiv.classList.add('stars');
        starsDiv.innerHTML = `
            <img src="../images/yellow-star.png" alt="yellow-star">
            <img src="../images/yellow-star.png" alt="yellow-star">
            <img src="../images/yellow-star.png" alt="yellow-star">
            <img src="../images/yellow-star.png" alt="yellow-star">
            <img src="../images/white-star.png" alt="white-star">
        `;

        postDiv.appendChild(headerDiv);
        postDiv.appendChild(contentDiv);
        postDiv.appendChild(starsDiv);

        return postDiv;
    }

    fetchPosts();
});