function showError(message) {
    document.getElementById('errorMessage').innerText = message;
    document.getElementById('errorPopup').style.display = 'block';
}

function hideError() {
    document.getElementById('errorPopup').style.display = 'none';
}