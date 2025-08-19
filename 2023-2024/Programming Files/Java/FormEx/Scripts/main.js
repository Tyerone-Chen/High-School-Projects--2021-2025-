
function processInput(event) {
        //  Check if connected  alert();

    //  Do form validation
    //  Step 1:  Check to see if any are empty and display error
    
    //  Get form values, loop through, and check if empty
    var myForm = document.getElementById("myForm");

    for (var i = 0; i < myForm.length; i++) {
        
        //  check to see if not radio
        if (myForm[i].id != "") {
            if (myForm[i].value == "") {
                var myError = myForm[i].id + "Err";  // ex:  email becomes emailErr which matches span
                document.getElementById(myError).innerHTML = "&nbsp; &nbsp; This field is required"
                event.preventDefault();
            }else{
                var myError = myForm[i].id + "Err";  // ex:  email becomes emailErr which matches span
                document.getElementById(myError).innerHTML = ""
                }
            
        }
    }
    
}



// add backward compatible event listener to Submit button
var submitButton = document.getElementById("submitBtn");
if (submitButton.addEventListener) {
    submitButton.addEventListener("click", processInput, false); 
} else if (submitButton.attachEvent)  {
    submitButton.attachEvent("onclick", processInput);
}