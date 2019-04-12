function changeEmail() {
    document.getElementById("sendBtn").style.display = "block";
    document.getElementById("editBtn").style.display = "none";

    var arrayOfFields=document.getElementsByClassName("fields");
    for (var i = 0; i < arrayOfFields.length; i++) {
        arrayOfFields[i].disabled=false;
    }


   /* var emailValue = document.getElementsByClassName("editClass")[0].innerText;
    document.getElementById("emailInputId").value = emailValue;*/
}

function handleRequest() {

    var email = document.getElementsByClassName("fields")[0].value;
    var town = document.getElementsByClassName("fields")[1].value;


    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var responseObject = JSON.parse(this.responseText);
            /*document.getElementsByClassName("editClass")[0].innerHTML=responseObject.email;*/
            var responseText = "";
            if(responseObject.status=="success"){
                responseText="Save Succesfully";
            }else if(responseObject.status == "error") {
                responseText = "Wasn't Save";
            }else {
                responseText = "Wasn't Save";
            }
        }
    };
    var sendParams = "/ajax?email=" + email+"&town=" + town;
    xhttp.open("GET",sendParams, true);
    xhttp.send();


    document.getElementById("sendBtn").style.display = "none";
    document.getElementById("editBtn").style.display = "block";
    var arrayOfFields=document.getElementsByClassName("fields");
    for (var i = 0; i < arrayOfFields.length; i++) {
        arrayOfFields[i].disabled=true;
    }
}
