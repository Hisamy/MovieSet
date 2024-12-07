document.addEventListener("DOMContentLoaded", () => {

    const inputTextPost = document.getElementById("text-post");
    const btnPost = document.getElementById("send-post");

    function createPost() {
//        const contextPath = '${pageContext.request.contextPath}';
        fetch("../SVCreatePost", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                textPost: inputTextPost.value,
            })
        })
                .then(response => {
                    if (response.ok) {
                        Swal.fire({
                            icon: 'success',
                            title: 'Post uploaded!',
                            text: 'Keep criticizing films.',
                            confirmButtonText: 'Continue'
                        });
                    } else {
                        return response.text().then(errorMessage => {
                            throw new Error(errorMessage);
                        });
                    }
                })
                .catch(err => {
                    Swal.fire({
                        title: "Error de Registro",
                        text: err.message || "No se pudo crear la cuenta. Intenta de nuevo.",
                        icon: "error",
                        customClass: {
                            confirmButton: 'btn btn-primary border-0'
                        }
                    });
                });
    }

    const init = () => {
        btnPost.onclick = () => {
            createPost();
        };

        document.onkeydown = (event) => {
            if (event.key === "Enter") {
                createPost();
            }
        };
    }

    init();

});