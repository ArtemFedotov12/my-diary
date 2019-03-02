function loginRequest() {
  //  $("#test3").val("Dolly Duck");
   // var username=document.getElementById("username").value;
    var username=$("#username").val();

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var responseObject = JSON.parse(this.responseText);
            if(responseObject.status=="success" & responseObject.email=="ok"){
                $("#submitBtn").click();
                    /*header.innerHTML="Email-Ok";*/
               /* xhttp.open("POST", "/login", true);
                xhttp.send();*/
            }
            else {
                header.innerHTML="Email-Bad";
            }
        }
    };
    var sendParams = "/lo?username=" + username;
    xhttp.open("GET",sendParams, true);
    xhttp.send();
    document.getElementById("loginInfo").style.display = "block";
    var header=document.getElementById("loginInfo");

}