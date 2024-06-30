document.getElementById('userForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    fetch('http://localhost:8081/usuarios/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        alert('Usuário logado com sucesso!');
        window.location.href = '../homePage/index.html';
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Erro ao cadastrar usuário');
    });
});