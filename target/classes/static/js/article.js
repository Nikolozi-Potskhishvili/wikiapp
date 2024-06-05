function editParagraph(articleId, id) {
    document.getElementById('paragraphContent' + id).style.display = 'none';
    document.getElementById('editParagraph' + id).style.display = 'block';
}

function saveParagraph(articleId, id) {
    let newContent = document.getElementById('editParagraphInput' + id).value;
    document.getElementById('paragraphContent' + id).textContent = newContent;
    document.getElementById('paragraphContent' + id).style.display = 'block';
    document.getElementById('editParagraph' + id).style.display = 'none';
    // AJAX call to save the new content to the server
    fetch('/updateParagraph', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            articleId: articleId,
            id: id,
            content: newContent
        }),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}