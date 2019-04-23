
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
    $("#createGradeBookId").css("display", "block");


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
            var classNumber;


            if (result.status==="success"){

                var x = document.getElementById("selectClassNumberCreateGradebookId");
                i=0;
                for(i;i<result.data.length;i++){
                    var option = document.createElement("option");
                    option.text = result.data[i];

                    if(i===0){
                        option.selected='selected';
                        classNumber=result.data[i];
                    }
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
