const recipeForm = document.getElementById("btnClear");

recipeForm.addEventListener("click", function(event) {
    alert("You cleared the recipe input field!");
    event.preventDefault();
    clearRecipeField();
});

function clearRecipeField() {
    document.getElementById("searchRecipe").value = '';
}