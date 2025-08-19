// Author: Tyerone Chen
// Date of Last Update: 3/25/2024

// setup code
const errorBox = document.getElementById("errorBox");
const submitBtn = document.getElementById("formSubmit");
const deleteLocal = document.getElementById("deleteLocal");
const welcomeText = document.querySelector(".welcomeUser");


// functions here


function processInput(evt)
{
    var validText = true;
    var validNumber = true;
    var validEmail = true;
    var validRadio = true;
    var allInputsValid = true;

    var validCheckMark = true;
    // fix this the gosh darn code doesnt work
    var positionChoice = document.querySelectorAll(".position");
    
    try
    {
        var currentForm = document.getElementById("registrationForm");

        for (var i = 0; i < currentForm.length; i++)
        {
            if (currentForm[i].id != "")
            {
                var currentType = currentForm[i].type;

                // uses switch statements to check what type of input it is, and how to respond
                switch(currentType)
                {   
                    // Basically checks whether the text box is empty, and if it is then itll error out and mark the section
                    case "text":
                        if (currentForm[i].value == "")
                        {
                            var errorInput = currentForm[i];
                            errorInput.style.border = "2px solid #FD6E08";
                            errorInput.style.color = "#FD6E08"

                            var currentErrBox = currentForm[i].id + "Error";
                            document.getElementById(currentErrBox).innerHTML = "> [ Please Complete This Field ]";
                            validText = false;
                        }
                            else
                            {
                                if (currentForm[i].id === "fname")
                                {
                                    applyLocal(currentForm[i].value.toUpperCase());
                                    checkLocal();
                                }
                                var input = currentForm[i];
                                input.style.border = "2px solid #26FF94";
                                input.style.color = "#26FF94";

                                var currentErrBox = currentForm[i].id + "Error";
                                document.getElementById(currentErrBox).innerHTML = "";
                                validText = true;
                            }
                            break;

                    case "number":
                        if (currentForm[i].value == "")
                        {
                            var errorInput = currentForm[i];
                            errorInput.style.border = "2px solid #FD6E08";
                            errorInput.style.color = "#FD6E08"

                            var currentErrBox = currentForm[i].id + "Error";
                            document.getElementById(currentErrBox).innerHTML = "> [ Please Complete This Field ]";
                            validNumber = false;
                        }
                            else
                            {
                                var input = currentForm[i];
                                input.style.border = "2px solid #26FF94";
                                input.style.color = "#26FF94";

                                var currentErrBox = currentForm[i].id + "Error";
                                document.getElementById(currentErrBox).innerHTML = "";
                                validNumber = true;
                            }
                        break;

                    // this one is basically the same as the last two    
                    case "email":
                        if (currentForm[i].value == "")
                        {
                            var errorInput = currentForm[i];
                            errorInput.style.border = "2px solid #FD6E08";
                            errorInput.style.color = "#FD6E08"

                            var currentErrBox = currentForm[i].id + "Error";
                            document.getElementById(currentErrBox).innerHTML = "> [ Please Enter Your Terminal Mail ]";
                            validEmail = false;
                        }
                            else
                            {
                                var input = currentForm[i];
                                input.style.border = "2px solid #26FF94";
                                input.style.color = "#26FF94";
    
                                var currentErrBox = currentForm[i].id + "Error";
                                document.getElementById(currentErrBox).innerHTML = "";
                                validEmail = true;
                            }
                        break;

                        // fixthe radio case statements, its not detecting the position choice properly
                        // i fixed it yayayayayayay, it jsut didnt know where the errorBox was

                        // The case checkes that if all radios are unchecked, then itll error out
                        // otherwise itll set itslef as valid 
                    case "radio":
                        if (!positionChoice[0].checked && !positionChoice[1].checked && !positionChoice[2].checked && !positionChoice[3].checked)
                        {
                            // might want to edit this section but i fixed it yay
                            var currentErrBox = "positionLabelError";
                            document.getElementById(currentErrBox).innerHTML = "> [ Please Select A Position ]";
                            validRadio = false;
                        }
                            else
                            {
                                var currentErrBox = "positionLabelError";
                                document.getElementById(currentErrBox).innerHTML = "";
                                validRadio = true;
                            }
                        break;

                        // works similarly to the last one instead only checks if the one thing was checked
                    case "checkbox":
                        if (!currentForm[i].checked)
                        {
                            var currentErrBox = currentForm[i].id + "Error";
                            document.getElementById(currentErrBox).innerHTML = "> [ You Must Agree to the ToS ]";
                            validInputs = false;
                        }
                            else
                            {
                                var currentErrBox = currentForm[i].id + "Error";
                                document.getElementById(currentErrBox).innerHTML = "";
                                validCheckMark = true;
                            }
                        break;
                }
            }  
        }

        if (validText == true && validNumber == true && validEmail == true && validRadio == true && validCheckMark == true)
        {
            allInputsValid = true;
        }
            else
            {
                allInputsValid = false;
            }

        if (allInputsValid == false)
        {
            throw "> [ WARNING: All Fields Must Be Filled ]"
        }
    }

    catch(errorMsg)
    {
        errorBox.innerHTML = errorMsg
        evt.preventDefault();
    }
    document.getElementById("formSubmit").style.border = "none";
}


function applyLocal(inputName)
{
    localStorage.setItem("userName", inputName);
    //alert(localStorage.getItem("userName"))
}

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

function clearLocal()
{
    localStorage.clear();
    alert("ALL RELATED EMPLOYEE INFO HAS BEEN CLEARED");
    checkLocal();
}

// onload code
window.onload = checkLocal();


if (submitBtn.addEventListener) 
{
    submitBtn.addEventListener("click", processInput, false); 
} 
    else if (submitBtn.attachEvent)  
    {
        submitBtn.attachEvent("onclick", processInput);
    }

if (deleteLocal.addEventListener)
{  
    deleteLocal.addEventListener("click", clearLocal, false);
}
    else if (deleteLocal.attachEvent)
    {
        deleteLocal.attachEvent("onclick", clearLocal);
    }   