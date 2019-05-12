





//When you choose Class number form select(certain option)
//event happened and with ajax get list of Letters for this Class number
//Example for 7 it can be A,B
//For 8 it can be A,B,C,D
var activities = document.getElementById("selectClassNumberCreateGradebookId");
activities.addEventListener("change", function() {
 var classNumber = $("#selectClassNumberCreateGradebookId option:selected" ).text();
        getListOfClassLetters(classNumber);
}
);





function openCreateGradeBookModel() {
    //Delete evertything from tag <select>
    $('#selectClassNumberCreateGradebookId option').each(function() {
            $(this).remove();
    });
    $('#selectClassLetterCreateGradebookId option').each(function() {
        $(this).remove();
    });
    $('#selectSubjectsCreateGradebookId option').each(function() {
        $(this).remove();
    });
    $("#createGradeBookId").css("display", "block");

    getListOfClassNumbers();
    getListOfSubjects();

}





function getListOfClassLetters(classNumber) {
    $('#selectClassLetterCreateGradebookId option').each(function() {
        $(this).remove();
    });
    $.ajax({
        method: "GET",
        url: "/getListOfClassLetters/" + classNumber,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {

            var x = document.getElementById("selectClassLetterCreateGradebookId");
            i=0;
            for(i;i<result.data.length;i++){
                var option = document.createElement("option");
                option.text = result.data[i];
                x.add(option);
            }
        },
        errorr: function (e) {

        }
    });
}



function getListOfClassNumbers(){

    var form = $('#createGradebookFormId')[0];
    var data = new FormData(form);
    $.ajax({
        method: "GET",
        url: "/getListOfClassNumbers",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
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

                var x = document.getElementById("selectClassNumberCreateGradebookId");
                i=0;
                for(i;i<result.data.length;i++){
                    var option = document.createElement("option");
                    option.text = result.data[i];
                    x.add(option);
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




function getListOfSubjects() {
   /* $('#selectSubjectsCreateGradebookId option').each(function() {
        $(this).remove();
    });*/
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

            var x = document.getElementById("selectSubjectsCreateGradebookId");
            i=0;
            for(i;i<result.data.length;i++){
                var option = document.createElement("option");
                option.text = result.data[i];
                x.add(option);
            }
        },
        errorr: function (e) {

        }
    });
}




function createGradebook() {
    var form = $('#createGradebookFormId')[0];
    var data = new FormData(form);

    $.ajax({
        method: "POST",
        url: "/createGradebook",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 60000000,
        success: function (result) {
            var data=result.data;
            if (result.status==="failure"){
                console.log("failure");
                if(data["gradeBookError"]!=null){
                    $("#classNumberCreateGradeBookId").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#classNumberLabelCreateGradeBookId").css("display", "block").text(data["gradeBookError"]);

                   /* $("#classLetterCreateGradeBookId").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#classLetterLabelCreateGradeBookId").css("display", "block").text(data["gradeBookError"]);

                    $("#nameOfSubjectCreateGradeBookId").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#nameOfSubjectLabelCreateGradeBookId").css("display", "block").text(data["gradeBookError"]);*/

                }else {
                    $("#classNumberCreateGradeBookId").removeClass("is-invalid").addClass("is-valid");
                    $("#classNumberLabelCreateGradeBookId").css("display", "none");

               /*     $("#classLetterCreateGradeBookId").removeClass("is-invalid").addClass("is-valid");
                    $("#classLetterLabelCreateGradeBookId").css("display", "none");

                    $("#nameOfSubjectCreateGradeBookId").removeClass("is-invalid").addClass("is-valid");
                    $("#nameOfSubjectLabelCreateGradeBookId").css("display", "none");*/
                }
            }


            if (result.status==="success"){
                $( ".form-control" ).each(function() {
                    $(this).removeClass("is-invalid").addClass("is-valid");
                });
                $( ".invalid-feedback" ).each(function() {
                    $(this).css("display", "none");
                });
                //Set opacity 100%
                $( "#gradeBookCreateSuccessId" ).animate({opacity: 1}, 3 );
                //Reduce opacity to 0%
                $( "#gradeBookCreateSuccessId" ).animate({opacity: 0}, 3000 );
            }


        },
        error: function(e) {

        }
    });
}