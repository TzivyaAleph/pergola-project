function regularCalculator() {
    const length = document.getElementById('inputLength').value;
    const width = document.getElementById('inputWidth').value;
    const height = document.getElementById('inputHeight').value;
    const incline = document.getElementById('inputIncline').value;
    const output = document.getElementById('inputOutput').value;
    const thickness = document.getElementById('thickness').value;

    let variables = [length,width,height,incline,output,thickness];

    // the url is the address to where i want to send the http request
    fetch('http://127.0.0.1:3000/calculate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ variables })
    })
    .then(response => response.json())
    .then(data => {
        //const result = [space,beams,lengthOfWood,poleHeight,spaceBetweenPoles,poles];
        document.getElementById('result').innerText = `Space between beams : ${data.result[0]}\n Amount of beams: ${data.result[1]}\n Length of beam: ${data.result[2]}
        The height of the pole: ${data.result[3]}\n The space between the poles: ${data.result[4]}\n Amount of poles: ${data.result[5]} `;
    })
    .catch(error => {
        console.error('Error:', error);
    });
}