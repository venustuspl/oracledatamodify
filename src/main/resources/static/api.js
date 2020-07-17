function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}

const niol = document.getElementById('notinvoicedorlist');
function getnotinvoicedor(){

niol.innerHTML = '';

    var ppe = document.getElementById("ppe").value;
    var data0 = document.getElementById("data0").value;
    var data1 = document.getElementById("data1").value;
    var link = "/getnotinvoicedor?name=" + ppe  + "&data0=" + data0 + "&data1=" + data1;

fetch(link)
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
            span = createNode('span');
            li.innerHTML = rate; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(niol, li);
        })
    });
}

function markorinvoiced(){

    var ppe = document.getElementById("ppe").value;
    var data0 = document.getElementById("data0").value;
    var data1 = document.getElementById("data1").value;
    var link = "/marknotinvoicedor?name=" + ppe  + "&data0=" + data0 + "&data1=" + data1;

fetch(link)
  .then(response => response.json())
  .then(data => document.getElementById('markedorcount').innerHTML = data);

}