document.getElementById('userForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    fetch('http://localhost:8081/usuarios', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nome, email, senha })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        alert('Usuário cadastrado com sucesso!');
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Erro ao cadastrar usuário');
    });
});