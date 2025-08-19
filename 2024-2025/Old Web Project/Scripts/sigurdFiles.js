// Author: Tyerone Chen
// Date of Last Update: 3/25/2024

//File Search Area
//Steps of the things
// have it so that you get the value of the search bar of when the search button is clicked
// have a div area be created once the button is clicked
// have it so that when either a clear search button or another search is clicked, the div area is cleared
// develop a search dictionary or syntax area to have a file directory location things that can be searched upon
// have multiple different search by types, date4 of file, create of file, word length etc
// Have it so that the logic will figure out vaugly similar file results, ie ignore stuff like caps 


/* Global or Setup Vars and stuff */
const searchInput = document.getElementById("searchInput");
const searchButton = document.getElementById("searchButton");
const searchByVal = document.getElementById("searchChoices");
const resultArea = document.getElementById("resultArea");
const fileList =
[
    {fileName:"Encrypted", fileAuthor:"SIGURD", fileDate:"10/3/1968"},
    {fileName:"SIGURD", fileAuthor:"SIGURD", fileDate:"9/27/1968"},
    {fileName:"Idea", fileAuthor:"Desmond", fileDate:"9/18/1968"},
    {fileName:"Sound", fileAuthor:"Jess", fileDate:"9/4/1968"},
    {fileName:"Golden Planet", fileAuthor:"Desmond", fileDate:"8/28/1968"},
    {fileName:"First Log", fileAuthor:"SIGURD", fileDate:"8/24/1968"}
]

var foundList = []; 

/* FUNCTIONS */
function filterFiles(filterBy = "", input = "")
{
  foundList = [];
  resultArea.innerHTML = "";
  
  fileList.forEach(
    file => 
    {
      if( file[filterBy].match(input))
      {
        foundList.push(file);
      }
    }
  )

  if (input === "")
  {
    resultArea.innerHTML = "ERROR 204: NO CONTENT WAS SEARCHED"
    resultArea.setAttribute("class", "warning");
    resultArea.style.padding = "5px";
    resultArea.style.borderColor = "#FD6E08";
  }
    else if (foundList.length > 0)
    {
      for (var i = 0; i < foundList.length; i++)
      {
        let fileResult = [];
        for (value in foundList[i])
        {
          //alert(foundList[i][value]); 
          fileResult.push(foundList[i][value]);
        }
        //alert(fileResult)
        let textArea = document.createElement('p');
        textArea.innerHTML = `FILE NAME: ${fileResult[0]}, FILE AUTHOR: ${fileResult[1]}, FILE DATE: ${fileResult[2]}`;
        resultArea.appendChild(textArea);
      }
      resultArea.setAttribute("class", "");
      resultArea.style.padding = "5px";
      resultArea.style.borderColor = "#26FF94";
    }
      else
      {
        resultArea.innerHTML = `ERROR 410: SEARCHED FILE, PROMPT: ${input}, DOES NOT EXIST OR IS CORRUPTED`
        resultArea.setAttribute("class", "warning");
        resultArea.style.padding = "5px";
        resultArea.style.borderColor = "#FD6E08";
      }
}


function searchFiles()
{
  let currentInput = searchInput.value;
  let currentSearchBy = searchByVal.value;
  // 3 types of search by: fileName, fileAuthor, fileDate
  
  filterFiles(currentSearchBy, currentInput);
}


/* Innitial onlaod website stuff, aka stuff after funcs are defined */

if (searchButton.addEventListener)
{
    searchButton.addEventListener("click", searchFiles, false);
}
  else if (searchButton.attachEvent)
  {
    searchButton.attachEvent("onclick", searchFiles);
  }