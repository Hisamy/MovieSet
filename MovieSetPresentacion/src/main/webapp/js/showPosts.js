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
                    posts.sort((a, b) => b.anclado - a.anclado);  // Ordena por 'anclado', los true primero
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
        postDiv.setAttribute('data-post-id', post.id); // Guarda el ID del post en un atributo

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
            </div>
        `;

        // Asocia el evento al botón "pin"
        const pinButton = menuDiv.querySelector('.pin');
        pinButton.addEventListener('click', () => {
            const postId = post.id;
            pinPost(postId, postDiv);
        });

        // Asocia el evento al botón "delete"
        const deleteButton = menuDiv.querySelector('.delete');
        deleteButton.addEventListener('click', () => {
            const postId = post.id;
            deletePost(postId, postDiv);
        });

        headerDiv.appendChild(authorDiv);
        headerDiv.appendChild(menuDiv);

        // Content section
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
