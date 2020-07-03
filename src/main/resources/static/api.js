
function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}

const ad = document.getElementById('alldata');

fetch("/alloption")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
                span = createNode('span');
            li.innerHTML = `${rate.currency} : ${rate.code} : ${rate.mid} `; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(ad, li);
        })
    });

const opt = document.getElementById('alloption');

fetch("/alloption")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('option'), //  Create the elements we need
                span = createNode('span');
              li.value = `${rate.mid}`;
            li.innerHTML = `${rate.currency} : ${rate.code} : ${rate.mid}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(opt, li);
        })
    });

function calculate(){
  var rate = document.getElementById("alloption").value
  var cash = document.getElementById("cash").value ;
  var result = cash / rate;
  document.getElementById("result").innerHTML = result.toFixed(2);

}

const opt2 = document.getElementById('alloption2');

fetch("/alloption")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('option'), //  Create the elements we need
                span = createNode('span');
              li.value = `${rate.mid}`;
            li.innerHTML = `${rate.currency} : ${rate.code} : ${rate.mid}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(opt2, li);
        })
    });

const opt3 = document.getElementById('alloption3');

fetch("/alloption")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('option'), //  Create the elements we need
                span = createNode('span');
              li.value = `${rate.mid}`;
            li.innerHTML = `${rate.currency} : ${rate.code} : ${rate.mid}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(opt3, li);
        })
    });


function calculate2(){
  var rate2 = document.getElementById("alloption2").value
  var cash2 = document.getElementById("cash2").value ;
  var rate3 = document.getElementById("alloption3").value
  var result = cash2 * rate2 / rate3;
  document.getElementById("result2").innerHTML = result.toFixed(2);

}

const gp = document.getElementById('goldresult');

fetch("/goldprice")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
                span = createNode('span');
            li.innerHTML = `${rate.price}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(gp, li);
        })
    });

const btc = document.getElementById('btcrate');

fetch("/coinrate?symbol=BTCUSDT")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
                span = createNode('span');
            li.innerHTML = `${rate.price}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(btc, li);
        })
    });

const eth = document.getElementById('ethrate');

fetch("/coinrate?symbol=ETHUSDT")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (ethdata) {
        let ethrates = ethdata; // Get the results
        return ethrates.map(function (ethrate) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
                span = createNode('span');
            li.innerHTML = `${ethrate.price}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(eth, li);
        })

    });

const chartopt = document.getElementById('chartalloption');

fetch("/alloption")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('option'), //  Create the elements we need
                span = createNode('span');
              li.value = `${rate.code}`;
            li.innerHTML = `${rate.currency} : ${rate.code} : ${rate.mid}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(chartopt, li);
        })
    });

function showchart(){
  var currency = document.getElementById("chartalloption").value;
  var link = "https://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/last/253/?format=json";

$.getJSON(link, function(data) {
   var labels = data.rates.map(function(e) {
      return e.effectiveDate;
   });
   var data = data.rates.map(function(e) {
      return e.mid;
   });

   var ctx = document.getElementById('myChart').getContext('2d');
   var chart = new Chart(ctx, {
      type: 'line',
      data: {
         labels: labels,
         datasets: [{
            backgroundColor: 'rgb(129, 198, 2228)',
            borderColor: 'rgb(0, 150, 215)',
            data: data
         }]
      },
      options: {
         responsive: 'true',
      }
   });
});}

// Coin chart

/*
const chartbtcopt = document.getElementById('chartbtcalloption');
fetch("/allbtcoption")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let rates = data; // Get the results
        return rates.map(function (rate) { // Map through the results and for each run the code below
            let li = createNode('option'), //  Create the elements we need
                span = createNode('span');
              li.value = `${rate.code}`;
            li.innerHTML = `${rate.currency} : ${rate.code} : ${rate.mid}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(chartbtcopt, li);
        })
    });
*/


function timeConverter(UNIX_timestamp){
  var a = new Date(UNIX_timestamp);
  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
  var year = a.getFullYear();
  var month = months[a.getMonth()];
  var date = a.getDate();
  var hour = a.getHours();
  var min = a.getMinutes();
  var sec = a.getSeconds();
  var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec ;
  return time;
}

function showbtcchart(){

    var coin = document.getElementById("charbtctalloption").value;
    var link = "https://api.binance.com/api/v3/trades?symbol=" + coin + "&limit=1000";


$.getJSON(link, function(data) {
   var labels = data.map(function(e) {

      return timeConverter(e.time);
   });
   var data = data.map(function(e) {
      return e.price;
   });

   var ctx = document.getElementById('myBtcChart').getContext('2d');
   var chart = new Chart(ctx, {
      type: 'line',
      data: {
         labels: labels,
         datasets: [{
            backgroundColor: 'rgb(129, 198, 2228)',
            borderColor: 'rgb(0, 150, 215)',
            data: data
         }]
      },
      options: {
         responsive: 'true',
      }
   });
});}