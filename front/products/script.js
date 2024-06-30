document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8081/sneakers', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        console.log('Lista de sneakers:', data);
        displaySneakers(data);
    })
    .catch((error) => {
        console.error('Erro ao buscar a lista de sneakers:', error);
    });

    function toggleDropdown() {
        document.getElementById("dropdown-menu").classList.toggle("show");
    }

    window.onclick = function(event) {
        if (!event.target.matches('.profile-dropdown button')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            for (var i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    }

    document.querySelector('.profile-dropdown button').addEventListener('click', toggleDropdown);

    function displaySneakers(sneakers) {
        const container = document.getElementById('product-card-container');
        container.innerHTML = '';

        sneakers.forEach(sneaker => {
            const card = document.createElement('div');
            card.classList.add('card');

            const imgContainer = document.createElement('div');
            imgContainer.classList.add('card-img-container');

            const img = document.createElement('img');
            img.src = sneaker.imageUrl;
            img.alt = sneaker.name;
            imgContainer.appendChild(img);

            const title = document.createElement('h3');
            title.textContent = sneaker.name;

            const price = document.createElement('h3');
            price.textContent = `R$${sneaker.price}`;

            const button = document.createElement('button');
            button.classList.add('add-to-cart');
            button.innerHTML = `
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
                </svg>
            `;

            card.appendChild(imgContainer);
            card.appendChild(title);
            card.appendChild(price);
            card.appendChild(button);

            container.appendChild(card);
        });
    }
});
