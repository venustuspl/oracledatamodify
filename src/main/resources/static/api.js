
function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}

function markorinvoiced(){

    var ppe = document.getElementById("ppe").value;
    var data0 = document.getElementById("data0").value;
    var data1 = document.getElementById("data1").value;

    var link = "/setplacadodforanyone?name=" + ppe + "&data0=2000/01/01&data1=2100/01/01";


fetch(link)
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let dates = data; // Get the results
        return dates.map(function (data) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
                span = createNode('span');
            li.innerHTML = `data`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(markedorcount, li);
        })

    });
}