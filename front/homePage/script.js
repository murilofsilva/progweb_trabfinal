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

let currentProductIndex = 1;
const totalProducts = 3;

function showProduct(index) {
    for (let i = 1; i <= totalProducts; i++) {
        document.getElementById(`product${i}`).style.display = 'none';
        document.querySelectorAll('.hero-slider-box')[i - 1].classList.remove('active');
    }
    document.getElementById(`product${index}`).style.display = 'flex';
    document.querySelectorAll('.hero-slider-box')[index - 1].classList.add('active');
    currentProductIndex = index;
}

function showNextProduct() {
    let nextIndex = currentProductIndex + 1;
    if (nextIndex > totalProducts) {
        nextIndex = 1;
    }
    showProduct(nextIndex);
}

document.addEventListener('DOMContentLoaded', () => {
    showProduct(1);
    setInterval(showNextProduct, 5000);
});