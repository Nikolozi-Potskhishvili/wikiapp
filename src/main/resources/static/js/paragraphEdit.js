function deleteParagraph(articleId, paragraphId, sectionId) {
    fetch(fetch(`/deleteParagraph?articleId=${articleId}&paragraphId=${paragraphId}&sectionId=${sectionId}`, {
        method: "POST",
    }).then(response => {
            if(response.ok) {
                returnToArticle(articleId)
            } else {
                throw new Error('Network response was not ok ' + response.statusText);
            }
    }).catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        }));
}

function returnToArticle(articleId) {
    window.location.href = "/editArticle/" + articleId;
}
function saveParagraph(articleId, paragraphId, sectionId) {
    let newContent = document.getElementById('paragraph-edit-textbook').value;
    console.log('Paragraph ID:', paragraphId);
    console.log('Article ID:', articleId);
    console.log('newContent:', newContent);
    //document.getElementById('paragraphContent').textContent = newContent;
    //document.getElementById('paragraphContent').style.display = 'block';
    //document.getElementById('editParagraph').style.display = 'none';
    // AJAX call to save the new content to the server
    fetch("/updateParagraph", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            paragraphId: paragraphId,
            content: newContent
        })
    }).then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        returnToArticle(articleId)
    })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });

}