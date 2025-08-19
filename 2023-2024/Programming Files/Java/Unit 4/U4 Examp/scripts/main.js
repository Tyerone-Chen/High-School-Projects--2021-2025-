// Vars

var data = [];

//Funcs
function addToArray()
{
    //this var refers to the clicked fruit div
    data.push(this.innerHTML);

    this.disabled = true
}

function clearResult()
{
    //clear the data
    data = [];

    var resultsDiv = document.getElementById("results");
    resultsDiv.innerHTML = "";
}

function showResult()
{
    //loop through da data vars
    for (var i = 0; i < data.length; i++)
    {
        //alert(data[i]);
        // 1 create the div and assign propertiso
        var newScrap = document.createElement("div");
        newScrap.id = "new" + data[i];
        newScrap.classList = "scrap";
        newScrap.innerHTML = data[i];

        //22 add the new div to result div
        var resultsDiv = document.querySelector("#results");
        resultsDiv.appendChild(newScrap);
    }

    //add content to result div
    data = [];
}

//listensers

window.onload = function()
{
    var btnShow = document.getElementById("show");
    btnShow.addEventListener("click", showResult);

    var btnClear = document.getElementById("clear");
    btnClear.addEventListener("click", clearResult);

    //stores all divs with scrap class into a array
    var btnScrap = document.querySelectorAll(".scrap");

    for (var i = 0; i < btnScrap.length; i++)
    {
        btnScrap[i].addEventListener("click", addToArray)
    }
}