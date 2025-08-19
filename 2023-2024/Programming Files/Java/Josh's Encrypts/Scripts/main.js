// startup code
const alphabet =  ["a", "b", "c", "d", "e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"];
const simpleEncrypt = ["z","y","x","w","v","u","t","s","r","q","p","o","n","m","l","k","j","i","h","g","f","e","d","c","b","a"];

//functions

function encryptText()
{
    var input = document.getElementById("inputText").value;
    var output = [];

    for (var i = 0; i < input.length; i++)
    {
        for (var j = 0; j < alphabet.length; j++)
        {
            if (input[i] == " ")
            {
                output.push(" ");
                break;    
            }
                else if (input[i] == alphabet[j])
                {
                    output.push(simpleEncrypt[j]);
                    break;
                }
        }
    }
    
    output = output.join("");
    
    document.getElementById("outputText").innerHTML = output;
}

//onload stuff

var submit = document.getElementById("submitButton");

if (submit.addEventListener) 
{
    submit.addEventListener("click", encryptText, false); 
} 
    else if (submit.attachEvent)  
    {
        submit.attachEvent("onclick", encryptText);
    }