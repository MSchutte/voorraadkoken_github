document.getElementById('voorraad').onclick = function(){
  fetch("http://localhost:8080/voorraadkoken/api/voorraad", {
    method: 'GET',
  })
  .then(function(response) {
    return response.json();
  })
  .then(function(data) {
    appendData(data);
  })
  .catch(function (err) {
    console.log(err);
  })
}

function appendData(data) {
  var mainContainer = document.getElementById("voorraadData");
  for (var i = 0; i < data.length; i++) {
    var div = document.createElement("div");
    div.innerHTML = data[i];
    mainContainer.appendChild(div);
  }
}

document.getElementById('search').onclick = function()
{
    ingredient = document.getElementById('ingredient').value;
    makeAPIrequest(ingredient);
};

function makeAPIrequest(ingredient){
  var apiurl = "http://localhost:8080/voorraadkoken/api/ingredient/" + ingredient;
  fetch(apiurl, {
        method: 'GET',
    })
    .then(function(response) {
      return response.json();
    })
    .then(function(data){
        appendRecipe(data);
        console.log("Request success: ", data);
    })
    .catch(function(error){
        console.log("Request failure: ", error);
    })
}

function appendRecipe(data) {
  var mainContainer = document.getElementById("receptensearch");
  for (var i = 0; i < data.length; i++) {
    var div = document.createElement("div");
    div.innerHTML = 'Name: ' + data[i][0];
    mainContainer.appendChild(div);
  }
}
