// FIELDS
const btnClear = document.getElementById("btnClear");
const btnClearCheckbox = document.getElementById("btnClearCheckbox")
const btnSelectCheckbox = document.getElementById("btnSelectCheckbox");


// EVENT LISTENERS ON CLICK
btnClear.addEventListener("click", function(event) {
    event.preventDefault();
    clearInputField();
});

btnClearCheckbox.addEventListener("click", function(event) {
    event.preventDefault();
    clearInputCheckbox();
});

btnSelectCheckbox.addEventListener("click", function(event) {
    event.preventDefault();
    selectInputCheckbox();
});


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