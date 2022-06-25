const recipeForm = document.getElementById("btnClear");

recipeForm.addEventListener("click", function(event) {
    event.preventDefault();
    clearInputField();
});

function clearInputField() {
    document.getElementById("inputField").value = '';

}