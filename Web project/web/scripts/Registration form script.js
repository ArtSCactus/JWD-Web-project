/**
 * @author ArtSCactus
 */
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
    // This function will display the specified tab of the form ...
    var tabs = document.getElementsByClassName("tab");
    tabs[n].style.display = "block";
    // ... and fix the Previous/Next buttons:
    if (n != (tabs.length - 1)) {
        document.getElementById("finish").style.display = "none";
        document.getElementById("nextBtn").style.display = "inline";
    }
    if (n == 0) {
        document.getElementById("prevBtn").style.display = "none";
    } else {
        document.getElementById("prevBtn").style.display = "inline";
    }
    if (n == (tabs.length - 1)) {
        document.getElementById("nextBtn").style.display = "none";
        document.getElementById("finish").style.display = "inline";
    } else {
        document.getElementById("nextBtn").innerHTML = "Next";
    }
    // ... and run a function that displays the correct step indicator:
    fixStepIndicator(n)
}

function nextPrev(n) {
    // This function will figure out which tab to display
    var tabs = document.getElementsByClassName("tab");
    // Exit the function if any field in the current tab is invalid:
    if (n == 1 && !validateForm()) return false;
    // Hide the current tab:
    tabs[currentTab].style.display = "none";
    // Increase or decrease the current tab by 1:
    currentTab = currentTab + n;
    // if you have reached the end of the form... :
    if (currentTab >= tabs.length) {
        //...the form gets submitted:
        document.getElementById("regForm").submit();
        return false;
    }
    for (var index=0; index<tabs.length; index++){
        if (index!=currentTab){
            $(tabs[index]).css("display", "none");
        }
    }
    // Otherwise, display the correct tab:
    showTab(currentTab);
}

function validateForm() {
    var tabs, inputs, i, valid = true;
    tabs = document.getElementsByClassName("tab");
    inputs = tabs[currentTab].getElementsByTagName("input");
    for (i = 0; i < inputs.length; i++) {
        if (!inputs[i].checkValidity() && inputs[i].name != "mailbox") {
            inputs[i].className += " invalid";
            valid = false;
        }
    }
    if (valid) {
        document.getElementsByClassName("step")[currentTab].className += " finish";
    }
    return valid;
}
//Validation on case if inputs was edited through the code.
//If it is, showing tabs with invalid fields on final stage.
function finalValidation(){
    var isValid=true;
    var fields=document.getElementsByTagName("input");
    for (var index=0; index<fields.length; index++) {
        if (!fields[index].checkValidity()){
            $(fields[index]).parent("p").parent(".tab").css("display", "block");
            isValid= false;
        }
        if (isValid){
                  document.getElementById("regForm").submit();
        } else {
            return false;
        }

    }
}
$('#prevBtn').click(function(){
    var tabs = document.getElementsByClassName(".tab");
    for (var index=0; index<tabs.length; index++){
        if (index!=currentTab){
            $(tabs[index]).css("display", "none");
        }
    }
});

function fixStepIndicator(n) {
    // This function removes the "active" class of all steps...
    var i, x = document.getElementsByClassName("step");
    for (i = 0; i < x.length; i++) {
        x[i].className = x[i].className.replace(" active", "");
    }
    //... and adds the "active" class to the current step:
    x[n].className += " active";
}