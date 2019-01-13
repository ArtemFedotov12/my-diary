function changeEmail() {
    document.getElementById("blockId").style.display = "block";
    var arrayOfEdidClass = document.getElementsByClassName("editClass");
    for (var i = 0; i < arrayOfEdidClass.length; i++) {
        arrayOfEdidClass[i].style.display = "none";
    }

    var emailValue = document.getElementsByClassName("editClass")[0].innerText;
    document.getElementById("emailInputId").value = emailValue;
}

function handleRequest() {

    var emailValue = document.getElementById("emailInputId").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var responseObject = JSON.parse(this.responseText);
            document.getElementsByClassName("editClass")[0].innerHTML=responseObject.email;
            var responseText = "";
            if(responseObject.status=="success"){
                responseText="Save Succesfully";
            }else if(responseObject.status == "error") {
                responseText = "Wasn't Save";
            }else {
                responseText = "Wasn't Save";
            }


            document.getElementById("response").innerHTML = responseText;
        }
    };
    var sendParams = "/ajax?emailvalue=" + emailValue;
    xhttp.open("GET",sendParams, true);
    xhttp.send();


    document.getElementById("blockId").style.display = "none";
    var arrayOfEdidClass = document.getElementsByClassName("editClass");
    for (var i = 0; i < arrayOfEdidClass.length; i++) {
        arrayOfEdidClass[i].style.display = "block";
    }



}