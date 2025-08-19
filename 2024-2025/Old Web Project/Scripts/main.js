// Author: Tyerone Chen
// Date of Last Update: 3/25/2024

/*Initialization stuff */
const welcomeText = document.querySelector(".welcomeUser");
const playerCount = document.getElementById("playerCount");

xmlHttpReq = new XMLHttpRequest;

/* FUNCTIONSSS */

function checkLocal()
{
    let userName = localStorage.getItem("userName");
    if (!userName)
    {
        welcomeText.innerHTML = "WELCOME GUEST";
    }
        else
        {
            welcomeText.innerHTML = `WELCOME EMPLOYEE: ${userName}`;
        }
}


function requestContent(url)
{
    xmlHttpReq.open('GET', url, true);
    xmlHttpReq.send();
}


/*Onload and other stuff */
console.log(requestContent("https://steamdb.info/app/1966720/charts/"))
window.onload = requestContent("https://steamdb.info/app/1966720/charts/");
window.onload = checkLocal();