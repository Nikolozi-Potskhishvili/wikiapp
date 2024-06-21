/*
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

*/


$(document).ready(function() {
    console.log(isLoggedIn);
    console.log(articleId);
    console.log(userId);
    $("#editArticleButton").click(function() {
            if (!isLoggedIn) {
                showPopup("Please log in to edit the article.");
            } else {
                $.ajax({
                    url: "/isAuthor",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify({userId: userId, articleId: articleId}),
                    success: function (response) {
                        if (response.success) {
                            window.location.href = `/editArticle/${articleId}`;
                        } else {
                            showPopup("You are not the author of this article.");
                        }
                    },
                    error: function () {
                        showPopup("An error occurred. Please try again later.");
                    }
                });
            }
    });

    $("#closePopup").click(function() {
        hidePopup();
    });

    function showPopup(message) {
        $("#popupMessage").text(message);
        $("#popup").removeClass("hidden");
    }

    function hidePopup() {
        $("#popup").addClass("hidden");
    }
    hidePopup();
});
