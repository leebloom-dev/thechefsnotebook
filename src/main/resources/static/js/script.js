// FIELDS
const btnClearTextField = document.getElementById("btnClearTextField");

// In the html attribute name, the value holds an array of ids
const checkboxRecipe = document.getElementsByName("recipeIds");
const checkboxCategory = document.getElementsByName("recipeCategoryIds");
const checkboxCuisine = document.getElementsByName("recipeCuisineIds");
const checkboxIngredient = document.getElementsByName("ingredientIds");


// FUNCTIONS
// Clear Input Text Field
function clearInputField() {
    document.getElementById("inputField").value = '';
}

// Clear Delete Recipe Checkboxes
function clearInputCheckboxRecipe() {
    for (let i = 0; i < checkboxRecipe.length; i++) {
        if (checkboxRecipe[i].type == 'checkbox') {
            checkboxRecipe[i].checked = false;
        }
    }
}

// Select All Recipe Checkboxes
function selectInputCheckboxRecipe() {
    for (let i = 0; i < checkboxRecipe.length; i++) {
        if (checkboxRecipe[i].type == 'checkbox') {
            checkboxRecipe[i].checked = true;
        }
    }

}

// Clear Category Checkboxes
function clearInputCheckboxCategory() {
    for (let i = 0; i < checkboxCategory.length; i++) {
        if (checkboxCategory[i].type == 'checkbox') {
            checkboxCategory[i].checked = false;
        }
    }
}

// Select All Category Checkboxes
function selectInputCheckboxCategory() {
    for (let i = 0; i < checkboxCategory.length; i++) {
        if (checkboxCategory[i].type == 'checkbox') {
            checkboxCategory[i].checked = true;
        }
    }
}

// Clear Cuisine Checkboxes
function clearInputCheckboxCuisine() {
    for (let i = 0; i < checkboxCuisine.length; i++) {
        if (checkboxCuisine[i].type == 'checkbox') {
            checkboxCuisine[i].checked = false;
        }
    }
}

// Select All Cuisine Checkboxes
function selectInputCheckboxCuisine() {
    for (let i = 0; i < checkboxCuisine.length; i++) {
        if (checkboxCuisine[i].type == 'checkbox') {
            checkboxCuisine[i].checked = true;
        }
    }
}

// Clear Ingredient Checkboxes
function clearInputCheckboxIngredient() {
    for (let i = 0; i < checkboxIngredient.length; i++) {
        if (checkboxIngredient[i].type == 'checkbox') {
            checkboxIngredient[i].checked = false;
        }
    }
}

// Select All Ingredient Checkboxes
function selectInputCheckboxIngredient() {
    for (let i = 0; i < checkboxIngredient.length; i++) {
        if (checkboxIngredient[i].type == 'checkbox') {
            checkboxIngredient[i].checked = true;
        }
    }
}

// EVENT LISTENERS ON CLICK
btnClearTextField.addEventListener("click", function(event) {
    event.preventDefault();
    clearInputField();
});