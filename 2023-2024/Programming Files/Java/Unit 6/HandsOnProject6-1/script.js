// Hand on poject 6-1

// Tyerone CHen 2/15/2024

//enables strict mode for the whole code

"use strict";


var formValidity = true;

// func to validate that all required fields are correct and filled

function validateRequired()
{
    var inputElements = document.querySelectorAll("#contactinfo input");
    var errorDiv = document.getElementById("errorText");
    var elementCount = inputElements.length;
    var requiredValidity = true;
    var currentElement;

    try
    {
        for (var i = 0; i < elementCount; i++)
        {
            currentElement = inputElements[i];

            if (currentElement.value === "")
            {
                currentElement.style.backgroundColor = "rgb(255,233,233)";
                requiredValidity = false;
            }
                else
                {
                    currentElement.style.backgroundColor = "white";
                }
        }

        if (requiredValidity === false)
        {
            throw "Please Complete All Fields.";
        }

        errorDiv.style.display = "none";
        errorDiv.innerHTML = "";
    }

    catch(msg)
    {
        errorDiv.style.display = "block";
        errorDiv.innerHTML = msg;
        formValidity = false;
    }

}


function validateNumbers()
{
    var numberInputs = document.querySelectorAll("#contactinfo input[type=number]");
    var numErrorDiv = document.getElementById("numErrorText");
    var elementCount = numberInputs.length;
    var numbersValidity = true;
    var currentElement;
    
    try 
    {
        for (var i = 0; i < elementCount; i++)
        {
            currentElement = numberInputs[i];
            
            if (isNaN(currentElement.value) || (currentElement.value === ""))
            {
                currentElement.style.backgroundColor = "rgb(255,233,233)";
                numbersValidity = false;
            } 
                else
                {
                    currentElement.style.backgroundColor = "white";
                }
        }

        if (numbersValidity === "false")
        {
            throw "Zip and Social Security Vallues Must Be Numbers.";
        }
        
        numErrorDiv.style.display = "none";
        numErrorDiv.innerHTML = "";
    }

    catch 
    {
        numErrorDiv.style.display = "block";
        numErrorDiv.innerHTML = msg;
        formValidity = false;
    }
}


function createEventListeners()
{
    var form = document.getElementsByTagName("form")[0];
    
    if (form.addEventListener)
    {
        form.addEventListener("submit", validateForm, false);
    }
        else if(form.attachEvent)
        {
            form.attachEvent("onsubmit", validateForm);
        }
}


function validateForm(evt)
{
    
    if (evt.preventDefault)
    {
        evt.preventDefault(); // stops the form from submitting
    } 
        else
        {
            evt.returnValue = false;
        }

    formValidity = true;
    validateRequired();
    validateNumbers();
    if (formValidity === true)
    {
        document.getElementsByTagName("form")[0].submit();
    }

}


// runs the function once the webstie has loaded

if (window.addEventListener)
{
    window.addEventListener("load", createEventListeners, false);
}
    else if (window.attachEvent)
    {
        window.attachEvent("onload", createEventListeners);
    }