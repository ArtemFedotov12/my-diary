function changeEmail() {
    $('#sendBtnMyPage').css("display","block");
    $('#uploadPhoto').css("display","block");
    $('#editBtnMyPage').css("display","none");

    var arrayOfFields=document.getElementsByClassName("fields");
    for (var i = 0; i < arrayOfFields.length; i++) {
        arrayOfFields[i].disabled=false;
    }

}

function handleRequest() {
    var form = $('#formMyPage')[0];
    var data = new FormData(form);
    console.log("Ajax Data: ");
    console.log(data);

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
            var dataMap=result.data;
            console.log(dataMap);

            var arrayOfClassFields=document.getElementsByClassName("fields");
            for (var i = 0; i < arrayOfClassFields.length; i++) {
                        $.each(dataMap, function(key, value) {
                            if(arrayOfClassFields[i].getAttribute("name")==key){
                            arrayOfClassFields[i].value=value;
                            console.log("Compare: " + arrayOfClassFields[i].value + " To: " + value);
                            }
                        });
            }
            console.log(dataMap["filename"]);
            $('#imgMyPage').attr("src", "/img/" + dataMap["filename"]);



        },
        error: function (e) {
            console.log("Error123");
            console.log(e);
        },
        complete: function () {
            $('#sendBtnMyPage').css("display","none");
            $('#uploadPhoto').css("display","none");
            $('#editBtnMyPage').css("display","block");
            $('#photoNotExistMyPage').css("display","none");
            $('#blockPhotoMyPage').css("display","block");
            var arrayOfFields=document.getElementsByClassName("fields");
            for (var i = 0; i < arrayOfFields.length; i++) {
                arrayOfFields[i].disabled=true;
            }
            //Under photo Upload Photo
            $("#spanMyPage").text('Upload Photo'); //versions newer than 1.6
            $("#spanMyPage2").text('Upload Photo');
        }
    });



}
