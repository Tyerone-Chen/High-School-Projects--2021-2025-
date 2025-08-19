//alert();  //  test the link between pages
// all start up code stuff 
var myBoard = document.querySelector("#board");
var boardArray = [];
const rows = 8;
const cols = 8;
const mines = 10;
var mineCount = 0;

// function stuff idfk

function gameStart()
{
    for (let r = 0; r < rows; r++)
    {
        let curRow = [];
        for(let c = 0; c < cols; c++)
        {
            curRow.push(0);
        }
    }

    while (mineCount < mines)
    {
        let randRow = Math.floor(Math.random() * rows);
        let randCol = Math.floor(Math.random() * cols);

        if (boardArray[randRow][randCol] == 0)
        {
            boardArray[randRow][randCol] = -1
            mineCount++
        }
    }

    var mineSweeper1 = new Board();
    mineSweeper1.boardCreate();
}


function resetGame()
{  
    myBoard.innerHTML = "";
}


// class stuff

class Board
{
    constructor()
    {

    }

    boardCreate()
    {
        for (var r = 0; r < rows; r++)
        {
            for (var c = 0; c < cols; c++)
            {
                var newBlock = new Block();
                
                var block = document.createElement("div");
                block.classList.add(newBlock.getClass());
                myBoard.appendChild(block);
            }
            myBoard.appendChild(document.createElement("br"));
        }
        //place the mines
    
        // place the numerical symbols
    
        // place blank spaces
    
    } 
}


class Block
{
    constructor(p_mineProx = 0, p_isMine = false)
    {
        this.mineImg = "";
        this.mineProx = p_mineProx;
        // based on and flag changes below, itll make some css
        this.clicked = false;
        this.clickFlagged = false;
        this.isMine = p_isMine;   
    }

    //funcs stuff

    // getters stuff
    getMineImg()
    {
        return this.mineImg;
    }

    getMineProx()
    {
        if (this.mineProx < 0)
        {
            this.mineProx = 0;
        }

        return this.mineProx;
    }

    getClicked() 
    {
        return this.clicked;
    }

    getFlagged()
    {
        return this.clickFlagged;
    }
    
    // setters stuff
    UserClicked()
    {
        if (!this.flagged)
        {
            this.clicked = true;
        }
    }

    UserFlagged()
    {
        this.flagged = !this.flagged;
    }

    //functio nfunctions 
    getClass()
    {
        if (this.clicked)
        {
            return "clicked";
        }
            else if  (this.flagged)
            {
                return "flagged"
            }
                else if (this.isMine)
                {
                    return "mine"
                }
                    else
                    {
                        "block"
                    }
    }
}


// onload stuff i hate

var startButton = document.getElementById("startGame");
var resetButton = document.getElementById("resetButton");

if (startButton.addEventListener) 
{
    startButton.addEventListener("click", gameStart, false); 
    resetButton.addEventListener("click", resetGame, false); 
} 
    else if (startButton.attachEvent)  
    {
        startButton.attachEvent("onclick", gameStart);
        resetButton.attachEvent("onclick", resetGame);
    }