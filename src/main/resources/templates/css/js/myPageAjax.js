function changeEmail() {

    var emailValue = document.getElementsByClassName("editClass")[0].innerText;
    document.getElementById("buttonChangeEmailId").style.display="none";
    document.getElementById("buttonHandleRequestId").style.display="block";
    document.getElementById("emailInputId").readOnly =false;

}

function handleRequest() {
    var emailValue = document.getElementById("emailInputId").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var responseObject = JSON.parse(this.responseText);
            //document.getElementById("emailInputId").innerHTML=responseObject.email;
            var responseText = "";
            if(responseObject.status=="success"){
                responseText="Save Succesfully";
            }else if(responseObject.status == "error") {
                responseText = "Wasn't Save";
            }else {
                responseText = "Wasn't Save";
            }


            document.getElementById("responseToHide").innerHTML = responseText;

        }
    };


    var sendParams = "/ajax?emailvalue=" + emailValue;
    xhttp.open("GET",sendParams, true);
    xhttp.send();


   /* document.getElementById("blockId").style.display = "none";
    var arrayOfEdidClass = document.getElementsByClassName("editClass");
    for (var i = 0; i < arrayOfEdidClass.length; i++) {
        arrayOfEdidClass[i].style.display = "block";
    }*/

    document.getElementById("buttonChangeEmailId").style.display="block";
    document.getElementById("buttonHandleRequestId").style.display="none";
    document.getElementById("emailInputId").readOnly =true;
    setTimeout(ch, 2000);


}
function ch() {
    $('#responseToHide').fadeOut('fast');
}