var global_classNumber;
var global_classLetter;


var classNumberId = document.getElementById("ClassNumberId_gradeBook");
classNumberId.addEventListener("click", function() {
        var classNumber = $("#ClassNumberId_gradeBook .select-selected").text();
        //  var classNumber = $("#ClassNumberId_gradeBook .select-selected").text();
        getListOfClassLetters(classNumber);
    }
);

var classLetterId = document.getElementById("ClassLetterId_gradeBook");
classLetterId.addEventListener("click", function() {
        global_classNumber = $("#ClassNumberId_gradeBook .select-selected").text();
        global_classLetter = $("#ClassLetterId_gradeBook .select-selected").text();
        console.log("Try");
        console.log(global_classNumber);
        console.log(global_classLetter);
        /*getListOfClassLetters(global_classNumber);*/
        getListOfSubjects();
        //getListOfClassLetters(classNumber);
    }
);

window.addEventListener("load", function(){
    getListOfClassNumbers();
    console.log("Try22333");
    console.log(global_classNumber===undefined);
    console.log(global_classNumber===undefined);
    console.log(global_classLetter);

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
            var classNumber=result.data[0];


            if (result.status==="success"){
                var y = document.getElementById("select_ClassNumberId_gradeBook");


                var i=0;
                for(i;i<result.data.length;i++){
                    var option = document.createElement("option");
                    option.text = result.data[i];
                    y.add(option);

                }
                getListOfClassLetters(classNumber);

            }

            if (result.status==="failure"){
                console.log("failure");

            }

        },
        error: function(e) {

        }
    });

}

function getListOfClassLetters(classNumber) {
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
            getListOfSubjects();
           /* if(global_classNumber===undefined && global_classLetter===undefined){

            }else {
                getListOfSubjectsForCertainClassNumberAndClassLetter();
            }*/

        },
        error: function (e) {

        }
    });
}

function getListOfSubjects() {
   /* $("div").remove(".select-items, .select-hide, .select-selected");*/
    $('#select_SubjectId_gradeBook option').each(function() {
        $(this).remove();
    });
 /*      $("div").remove(".select-items, .select-hide, .select-selected");
    $('#select_ClassLetterId_gradeBook option').each(function() {
        $(this).remove();
    });
    $('#select_SubjectId_gradeBook option').each(function() {
        $(this).remove();
    });*/
/*    console.log("1111");
    console.log($("div .select-selected").length);

    var l=$("div .select-selected").length;
    for(var i=0;i<l-1;i++){
        $("div .select-selected")[i].remove();
        console.log("i="+i)
    }
    console.log("22222");
    console.log($("div .select-selected").length);*/




/*    var j=0;
    for(j;j<$("div .select-items").length;j++){
        $("div .select-items")[j].remove();
    }
    console.log("End");
    console.log($("div .select-selected").length);
    console.log($("div .select-items").length);*/
    $.ajax({
        method: "GET",
        url: "/getListOfSubjects",
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {

            var x = document.getElementById("select_SubjectId_gradeBook");
            i=0;
            for(i;i<result.data.length;i++){
                var option = document.createElement("option");
                option.text = result.data[i];
                x.add(option);
            }
            $("div").remove(".select-items, .select-hide, .select-selected");
            customSelectDefault();
        },
        errorr: function (e) {
        }
    });
}

function getListOfSubjectsForCertainClassNumberAndClassLetter() {
    $('#select_SubjectId_gradeBook option').each(function() {
        $(this).remove();
    });
    /*    $("div").remove(".select-items, .select-hide, .select-selected");
        $('#select_ClassLetterId_gradeBook option').each(function() {
            $(this).remove();
        });
        $('#select_SubjectId_gradeBook option').each(function() {
            $(this).remove();
        });*/
/*    console.log("F");
    console.log($("div .select-selected"));

    console.log("One");
    console.log($("div .select-items"));
    console.log("Two");
    console.log($("div .select-items")[0].remove());
    console.log($("div .select-items")[1].remove());
    console.log($("div .select-selected")[0].remove());
    console.log($("div .select-selected")[1].remove());
    console.log($("div .select-selected")[2].remove());
    console.log("Three");
    console.log($("div .select-items"));*/
    $.ajax({
        method: "GET",
        url: "/getListOfSubjects?classNumber="+global_classNumber+"&classLetter="+global_classLetter,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {

            var x = document.getElementById("select_SubjectId_gradeBook");
            i=0;
            for(i;i<result.data.length;i++){
                var option = document.createElement("option");
                option.text = result.data[i];
                x.add(option);
            }
            $("div").remove(".select-items, .select-hide, .select-selected");
            customSelectDefault();
        },
        errorr: function (e) {
        }
    });
}

