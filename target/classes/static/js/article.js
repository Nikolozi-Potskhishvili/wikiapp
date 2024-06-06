document.addEventListener('DOMContentLoaded', function() {
    console.log("DOM fully loaded and parsed");
    const editButton = document.getElementById('editTitleButton');
    const editForm = document.getElementById('editTitleForm');

    if (editButton && editForm) {
        console.log("Elements found");
        editButton.addEventListener('click', function() {
            console.log("Edit button clicked");
            editForm.classList.toggle('hidden');
        });
    } else {
        console.log("Elements not found");
    }
});