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

document.getElementById('paymentForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Validação simples do formulário
    if (!this.fullName.value || !this.address.value || !this.creditCard.value) {
        alert('Por favor, preencha todos os campos.');
        return;
    }

    // Simulação de envio do formulário
    alert('Compra finalizada com sucesso!');
    // lógica para enviar os dados do formulário para o servidor
});
