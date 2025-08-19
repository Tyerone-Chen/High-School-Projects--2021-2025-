//alert();  //  test the link between pages

// global variables 
const books = [
    {isbn:'1234', title:"Intro to JavaScript", author:"Clark Kent", publisher:"Kent Publishing", year:2020},
    {isbn:'4567', title:"Beginning Web Development", author:"Diane Lane", publisher:"Cengage", year: 2010},
    {isbn:'3745', title:"Ethical Hacking", author:"Lex Luther", publisher:"Luther Press", year:2017},
    {isbn:'7350', title:"Learn JavaScript in One Day", author:"Felicia Iglesia", publisher:"",year:2017},
    {isbn:'4190', title:"Python For Everyone", author:"Kent Michaels", publisher:"",year:2010},
]

var bookFound = [];

var searchBtn = document.getElementById("searchBtn");
var resultLabel = document.getElementById("result");

/* FUNCTIONS */

function searchBooks(filter = "", value = "")
{
    books.forEach( book => {
        if( book[filter].match(value) ){
            bookFound.push(book)
        }
    })
    alert(bookFound)
    displayResults(books[0])
}


function displayResults(results)
{
    //display the rsults from the search and use innerhtml to display it
    document.querySelector("#result").innerHTML = results;
}

function getUserInfo()
{
    var filterType;
    var term;

    filterType = document.querySelector("#search_title").value;
    term = document.querySelector("#search_term").value;

    searchBooks(filterType, term)
}

// Event Listtiner stuff

if (searchBtn.addEventListener)
{
    searchBtn.addEventListener("click", getUserInfo, false);
}
    else if(searchBtn.attachEvent)
    {
        searchBtn.attachEvent("onclick", getUserInfo);
    }