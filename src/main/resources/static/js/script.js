// FIELDS
const btnClearTextField = document.getElementById("btnClearTextField");
const btnClearCheckbox = document.getElementById("btnClearCheckbox")
const btnSelectCheckbox = document.getElementById("btnSelectCheckbox");


// FUNCTIONS
function clearInputField() {
    document.getElementById("inputField").value = '';
}

function clearInputCheckbox() {
    document.getElementById("inputCheckbox").checked = false;
}

function selectInputCheckbox() {
    document.getElementById("inputCheckbox").checked = true;
}


// EVENT LISTENERS ON CLICK
btnClearTextField.addEventListener("click", function(event) {
    event.preventDefault();
    clearInputField();
});