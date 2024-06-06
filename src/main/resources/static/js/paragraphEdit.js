

function saveParagraph(articleId, paragraphId) {
    let newContent = document.getElementById('editParagraphInput').value;
    console.log('Paragraph ID:', paragraphId);
    console.log('Article ID:', articleId);
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
        window.location.href = `/article/` + articleId;
    })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });

}