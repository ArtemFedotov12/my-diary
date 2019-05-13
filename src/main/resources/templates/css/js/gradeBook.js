
var active = document.getElementById("ClassNumberId_gradeBook");
active.addEventListener("click", function() {
        console.log("eee");
        var classNumber = $("#ClassNumberId_gradeBook .select-selected").text();
        getListOfClassLetters(classNumber);
    }
);

window.addEventListener("load", function(){
    console.log("kekr");
    getListOfClassNumbers();

});


function getListOfClassNumbers(){


    $.ajax({
        method: "GET",
        url: "/getListOfClassNumbers",
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {
            var data=result.data;
            //First element by default will be selected
            //And we pass it to get list of letters for this class
            var classNumber=result.data[8];


            if (result.status==="success"){

                var y = document.getElementById("select_ClassNumberId_gradeBook");
                /*var temroryOption=document.createElement("option");
                temroryOption.text="Select Class:";
                y.add(temroryOption);*/

                var i=0;
                for(i;i<result.data.length;i++){
                    var option = document.createElement("option");
                    option.text = result.data[i];
                    y.add(option);

                }
                getListOfClassLetters(classNumber);

            }
            //The thole file from w3.school
            //customSelect.js

            if (result.status==="failure"){
                console.log("failure");

            }

        },
        error: function(e) {

        }
    });

}

function getListOfClassLetters(classNumber) {
    $("div").remove(".select-items, .select-hide, .select-selected");
    $('#select_ClassLetterId_gradeBook option').each(function() {
        $(this).remove();
    });
    $.ajax({
        method: "GET",
        url: "/getListOfClassLetters/" + classNumber,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {

            var x = document.getElementById("select_ClassLetterId_gradeBook");

            var temroryOption=document.createElement("option");
            temroryOption.text="Select Letter:";
            x.add(temroryOption);

            var i=0;
            for(i;i<result.data.length;i++){
                var option = document.createElement("option");
                option.text = result.data[i];
                x.add(option);
            }
            customSelectDefault();
        },
        errorr: function (e) {

        }
    });
}