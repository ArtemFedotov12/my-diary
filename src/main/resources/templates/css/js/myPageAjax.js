function changeEmail() {
    $('#sendBtn').css("display","block");
    $('#uploadPhoto').css("display","block");
    $('#editBtn').css("display","none");

    var arrayOfFields=document.getElementsByClassName("fields");
    for (var i = 0; i < arrayOfFields.length; i++) {
        arrayOfFields[i].disabled=false;
    }

}

function handleRequest() {

    var form = $('#formMyPage')[0];
    var data = new FormData(form);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/mypage/edit",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 60000000,
        success: function (result) {
            console.log("Success123");
        },
        error: function (e) {
            console.log("Error123");
            console.log(e);
        },
        complete: function () {
            document.getElementById("sendBtn").style.display = "none";
            document.getElementById("editBtn").style.display = "block";
            var arrayOfFields=document.getElementsByClassName("fields");
            for (var i = 0; i < arrayOfFields.length; i++) {
                arrayOfFields[i].disabled=true;
            }
        }
    });



}
