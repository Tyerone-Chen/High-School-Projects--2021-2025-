/* AUTHOR : Tyerone Chen */
/* LAST UPDATE DATE : 3/27/2024 */

// game timer should be around 100 - 140 secs maybe idfk this decision is a problem for future me lol
// remeber to make the code look NEAT or I will litteraly cry ;C
// Also DO NOT fill up the boarrd fully with scrap, it'll cause it so that the site takes forever to reload

// game creations steps
// create the layout of the board, multiple divs - DONE -
// spawn in basic img scraps, with the rng thingy - DONE -
// get the functionality of it clicking and disapearingq, also have it to NOT spawn a img on a already filled block - DONE -
// create a score and have it increase eveytime scrap is clicked - KINDA DONE -
//have the scre increase based on the value of the scrap, this will be OOPS baesed programmming
// timer thing - done -

// Have it so that you cna opnly select the uh scraps once game start button has been clicked - TO DO -
// also make sure that the game start button is disabled once it is pressed ONCE, and only reenavled when either stopGame button has been clicked or the timer ends :]
// HAVE UH CLAASSES THING

/* window.scrollTo(0, 65);6  this just scrolls to the best spot to play the game */

/* STARTYP CODE THINGSS */
// basically anything that is a global var
//THESE ARE CONST, UNCHANGING
//getElement stuff below
const boardArea = document.querySelector("#gameBoard");
const scoreLabel = document.getElementById("scoreLabel");
const timeLabel = document.getElementById("timeLabel");
const statusLabel = document.getElementById("statusLabel");
const highScoreLabel = document.getElementById("highscoreLabel");
const startButton = document.getElementById("startButton");
const stopButton = document.getElementById("stopButton");
const welcomeText = document.querySelector(".welcomeUser");
const clearButton = document.getElementById("clearHighScore");
// adjustable gridBoard paramaeters
const horizontal = 6;
const vertical = 6;
const scrapOnScreen = 3;
// just variab;les that will be global, but will be edited over time
var scoreCount = 0;
var gameStart = false;
var timer;

// This should just be the list of scrap, so the images of it, a much more optimized version will be made in the dutre this is just a temp version
/* I SHOULD ADD MORE SCRAPS STUFF, LOOK AT THE LC WIKI FOR MORE SCRAP IDEASn */
//ALSO write it so that the javascript would compile all of the png file names by itself so I don't have to do it manuallly because it SUCKS to do it 
// also maybe make different scrap lisst for their rarities, plus also evil stuff, bees slime goop jack box these will disappear after a couple seconds
const scrapArray = ["airHorn", "apparatus", "beeHive", "bellScrap", "bigBolt", "bottlesScrap", "cashRegister", "chemicalJug",
"clownHorn", "cookieMold", "eggBeater", "hairBrush", "largeAxle", "pickleJar", "stopSign", "teaKettle", "vTypeEngine", "whoopieCushion"]
var valuedScrap = [];


/* FUNCTIONS THING4S */
// everything SHOULD be in a-z organizationnnn, but i might mess up with some of them idk ¯\_(ツ)_/¯

// this function is brocken, SO FIX IT >:[
// I FIXED IT FINALLLY, IT WAS SO GOD DAMN DUMB (╯°□°)╯︵ ┻━┻
//NOTE rember the reason it got fixed was because i had to use anonmouy functions ヽ(ｏ`皿′ｏ)ﾉ ヽ(`Д´)ﾉ
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

    let userScore = localStorage.getItem("userHighScore");
    if (!userScore){
      highScoreLabel.innerHTML = "N/A";
    }
      else{
        highScoreLabel.innerHTML = `${userScore} POINTS`;
      }
}


function clickScrap(scrapID)
{
  //alert(scrapID) // alert tester to ensure that the function works 
  let currentGrid = document.getElementById(scrapID);
  if (currentGrid.classList.contains("filledImage"))
  {
    scoreChange();
    currentGrid.setAttribute("src", "Media/blankSpace.png");
    currentGrid.setAttribute("class", "scrapImage");
    currentGrid.classList.remove("filledImage")
    placeRandScrap();
  }
}


function createBoard()
{
  for (let v = 0; v < vertical; v++)
  {
    // note: the whole 2d list might be useless so yeah, might delete later
    for (let h = 0; h < horizontal; h++)
    {
      // gridBlock setup + 2dList Swetup
      let gridBlock = document.createElement("div");

      boardArea.appendChild(gridBlock);
      gridBlock.setAttribute("class", "gameBlock");
      gridBlock.setAttribute("id", `block-${v},${h}`)
      //gridBlock.innerHTML = `${v},${h}`; /* delete this later */
      // grid images setup
      let gridImage = document.createElement("IMG");

      gridBlock.appendChild(gridImage);
      gridImage.setAttribute("class", "scrapImage");
      gridImage.setAttribute("src", "Media/blankSpace.png");
      gridImage.setAttribute("id", `image-${v},${h}`);
      //gridImage.addEventListener("click", function() {clickScrap(`image-${v},${h}`)}, false); //earlier version of the enableClickScrap Functions
      
    }
    boardArea.appendChild(document.createElement("br"));
  }
  //enableClickScrap(); // testing area for the function
}


function enableClickScrap()
{
  for (let v = 0; v < vertical; v++)
  {
    for (let h = 0; h < horizontal; h++)
    {
      let currentGridImage = document.getElementById(`image-${v},${h}`);
      currentGridImage.addEventListener("click", function() {clickScrap(`image-${v},${h}`)}, false);       
    }
  }
}

// FIX THIS FUNCTION SO THAT IT properLY DISABLE THE EVENT LISTENERS FOR ALL OF THE UHH IMAGE GRIDSS
function disableClickScrap()
{
  for (let v = 0; v < vertical; v++)
  {
    for (let h = 0; h < horizontal; h++)
    {
      let currentGridImage = document.getElementById(`image-${v},${h}`);
      currentGridImage.removeEventListener("click", function() {clickScrap(`image-${v},${h}`)}, false);       
    }
  } 
}


function gameStatusCheck(status)
{
  if (gameStart === true)
  {
    //alert("Game Has begun")
    enableClickScrap();
    statusLabel.innerHTML = "COLLECTING SCRAP!";
    for (let i = 0; i < scrapOnScreen; i++)
    {
      placeRandScrap();
    }
  }
    else if(gameStart === false)
    {
      disableClickScrap();
      statusLabel.innerHTML = "AWAITING COLLECTION";
      boardArea.innerHTML = "";
      createBoard();
    }
}


function placeRandScrap()
{ 
  var scrapPlacement = false;
  while (scrapPlacement == false)
  {
    var scrapChoice = Math.floor(Math.random() * valuedScrap.length);
    var randXPos = Math.floor(Math.random() * horizontal);
    var randYPos = Math.floor(Math.random() * vertical);
    var gridImage = document.getElementById(`image-${randYPos},${randXPos}`);

    if (!gridImage.classList.contains("filledImage"))
    {
      gridImage.setAttribute("src", valuedScrap[scrapChoice].scrapIMG);
      gridImage.setAttribute("class", "filledImage")
      scrapPlacement = true;
    }
  }
}


function resetScore()
{
  scoreCount = 0;
  scoreLabel.innerHTML = "--- POINTS";
}


function scoreChange()
{
  scoreCount = scoreCount + 100;
  scoreLabel.innerHTML = `${scoreCount} POINTS`;
}


function startGame()
{
  window.scrollTo(0, 60);// this just scrolls to the best spot to play the game
  //starts up the timers
  startTimer()
  //makes sure that the score is reset once a new game is started
  resetScore();
  // makes sure to check the sate the game is in currently, and properly do certain functions as necessary
  gameStart = true;
  gameStatusCheck(); 
}


function stopGame()
{
  //alert("button works")
  //Stops the timer
  resetTimer();

  // turn game status into false, ie it is not active
  gameStart = false;
  gameStatusCheck();
  setHighscore(scoreCount);
}



function startTimer()
{
  var timeLength = 30;
  //alert("START")
  timeLabel.innerHTML = `${timeLength} SECONDS`;
  
  timer = setInterval(function()
  {
    timeLength--;
    if (timeLength >= 0)
    {
      timeLabel.innerHTML = `${timeLength} SECONDS`;
      //alert(timeLength);
    }
6
    if (timeLength === 0)
    {
      boardArea.innerHTML = "";
      createBoard();
      clearInterval(timeLength);
      statusLabel.innerHTML = "AWAITING COLLECTION";
      timeLabel.innerHTML = "--- SECONDS";
    }
  
  }, 1000)
}


function resetTimer()
{
  clearInterval(timer);
  timeLabel.innerHTML = "--- SECONDS";
}


function setHighscore(score){
  let userScore = localStorage.getItem("userHighScore");
  if (!userScore){
    localStorage.setItem("userHighScore", score);
  }
  
  if(score < userScore){
    highScoreLabel.innerHTML = `${userScore} POINTS`;
  }
    else{
      localStorage.setItem("userHighScore", score);
      highScoreLabel.innerHTML = `${score} POINTS`;
    }
}


function resetHighScore(){
  localStorage.removeItem("userHighScore")
  checkLocal();
}


/* CLASSES STUFF */
//NOTE this code is kinda of an example/ basic idea of it, the final working version, which will be when i finish the game, will have changes to it obviously and also be a LOT more filled with code schtuff
//I just can functionally get the class to work with teh game rn so yeah wait for that to happen pls :P
// yeah also this stuff might be slightly scuffed idk maybe not, the game is still a wip

class ScrapValue
{
  //Constructorss
  // This will just store any important value of the scrap, so when it is picked up, the correct stuff is added and played, such as sfx score adding
  constructor(scrapName, value, weight)
  {
    this.scrapName = scrapName;
    // Name and IMG should be pretty similar, w/just IMG have .png added to the end of the name
    this.scrapIMG = `Media/scrapImages/${scrapName}.png`;
    this.scrapValue = value;
    this.scrapWeight = weight;// might remove based on how i want the game to work
    /* NOTE TO SELF BECAUSE I WILL FORGET: maybe have wieght decrease the timer by like a certain amount idk but that would be kool */
    this.scrapSfx = `${scrapName}`;
    /* REMINDER add a sfx folder*/ 
    // add more later to brain dead to figure out more
  }

  //Functionsss
  // i should add more easter eggs in the site :D
  // alsowork on the sigurdLogs scripting to have a search bar, to replicate a file searching directory, with some cool easter eggs realted to it
  increaseScore()
  {
    scoreCount = scoreCount + this.scrapValue;
    scoreLabel.innerHTML = `${scoreCount} POINTS`;
  }


  //obsolete as i cannot download mp3 files apparently
  playScrapSFX()
  {
    this.scrapSfx;
  }
}

function assignScrapObject(){
  scrapArray.forEach(scrap =>{
    scrap = new ScrapValue(scrap, 100, 1);
    valuedScrap.push(scrap);
  })
}

/* ONLOAD WEBSITE THINGY */
// also i guess any stuff related with onclick idk ┐('～`；)┌
window.onload = checkLocal();
window.onload = assignScrapObject();

createBoard();

if (startButton.addEventListener)
{
  startButton.addEventListener("click", startGame, false);
}
  else if (startButton.attachEvent)
  {
    startButton.attachEvent("onclick", startGame);
  }


if (stopButton.addEventListener)
{
  stopButton.addEventListener("click", stopGame, false);
}
  else if (stopButton.attachEvent)
  {
    stopButton.attachEvent("onclick", stopGame);
  }
  
