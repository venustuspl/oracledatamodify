
function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}

const markedorcount = document.getElementById('markedorcount');

function markorinvoiced(){

    var ppe = document.getElementById("ppe").value;
    var data0 = document.getElementById("data0").value;
    var data1 = document.getElementById("data1").value;
//document.getElementById('testlink').innerHTML = data0);
    var link = "/setplacadodforanyone?name=" + ppe  + "&data0=" + data0 + "&data1=" + data1;

fetch(link)
  .then(response => response.json())
  .then(data => document.getElementById('markedorcount').innerHTML = data);

}