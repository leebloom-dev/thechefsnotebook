// FIELDS
const btnClearTextField = document.getElementById("btnClearTextField");
const btnClearCheckbox = document.getElementById("btnClearCheckbox");
const btnSelectCheckbox = document.getElementById("btnSelectCheckbox");
const checkboxRecipe = document.getElementsByName("recipeIds");
const checkboxCategory = document.getElementsByName("recipeCategoryIds");


// FUNCTIONS
function clearInputField() {
    document.getElementById("inputField").value = '';
}

// Clear Delete Recipe Checkboxes
function clearInputCheckboxRecipe() {
    for (let i=0; i<checkboxRecipe.length; i++) {
        if (checkboxRecipe[i].type == 'checkbox') {
            checkboxRecipe[i].checked = false;
        }
    }
}

// Select All Recipe Checkboxes
function selectInputCheckboxRecipe() {
    for (let i=0; i<checkboxRecipe.length; i++) {
        if(checkboxRecipe[i].type == 'checkbox') {
            checkboxRecipe[i].checked = true;
        }
    }

}

// Clear Category Checkboxes
function clearInputCheckboxCategory() {
    for (let i=0; i<checkboxCategory.length; i++) {
        if (checkboxCategory[i].type == 'checkbox') {
            checkboxCategory[i].checked = false;
        }
    }
}

// Select All Category Checkboxes
function selectInputCheckboxCategory() {
    for (let i=0; i<checkboxCategory.length; i++) {
        if(checkboxCategory[i].type == 'checkbox') {
            checkboxCategory[i].checked = true;
        }
    }
}


// EVENT LISTENERS ON CLICK
btnClearTextField.addEventListener("click", function(event) {
    event.preventDefault();
    clearInputField();
});