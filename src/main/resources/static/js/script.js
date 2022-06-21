const recipeForm = document.getElementById("clearInput");

recipeForm.addEventListener("click", function(event) {
    alert("You cleared the recipe input field!");
    event.preventDefault();
});

function clearRecipeField() {
    document.getElementById("recipe").value = '';
}