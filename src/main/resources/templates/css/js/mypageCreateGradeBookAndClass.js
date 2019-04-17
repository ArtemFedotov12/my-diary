


// When the user clicks anywhere outside of the modal, close it
//Modal for Create Gradebook
window.onclick = function(event) {
    var modal = document.getElementById('createGradeBookId');
    if (event.target == modal) {
        modal.style.display = "none";
    }
};

function createGradebook() {
    document.getElementById('createGradeBookId').style.display='none';
    var form = $('#createGradebookFormId')[0];
    var data = new FormData(form);

    $.ajax({
        type: "POST",
        url: "/createGradebook",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 60000000,
        success: function (result) {


        },
        error: function(e) {

            }
    });
}







function createClass() {
   /* $("#createClassId").css("display", "none");*/
    var form = $('#createClassFormId')[0];
    var data = new FormData(form);

    $.ajax({
        type: "POST",
        url: "/createClass",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 60000000,
        success: function (result) {
            console.log("Result+");
            console.log(result);
            var data=result.data;
            if (result.status==="failure"){
                if(data["accessKeyForSchoolKidError"]!=null){
                    $("#accessKeyForSchoolKidClassId").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#accessKeyForSchoolKidLabelClassId").css("display", "block").text(data["accessKeyForSchoolKidError"]);
                }else {
                    $("#accessKeyForSchoolKidClassId").removeClass("is-invalid").addClass("is-valid");
                    $("#accessKeyForSchoolKidLabelClassId").css("display", "none");
                }

                if(data["classNumberClassLetterError"]!=null){
                    $("#classNumberCreateClassId").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#classNumberLabelCreateClassId").css("display", "block").text(data["classNumberClassLetterError"]);

                    $("#classLetterCreateClassId").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#classLetterLabelCreateClassId").css("display", "block").text(data["classNumberClassLetterError"]);

                }else {
                    $("#classNumberCreateClassId").removeClass("is-invalid").addClass("is-valid");
                    $("#classNumberLabelCreateClassId").css("display", "none");

                    $("#classLetterCreateClassId").removeClass("is-invalid").addClass("is-valid");
                    $("#classLetterLabelCreateClassId").css("display", "none");


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
                $( "#classCreateSuccessId" ).animate({opacity: 1}, 3 );
                $("#classCreateSuccessId").text("Class was created");
                //Reduce opacity to 0%
                $( "#classCreateSuccessId" ).animate({opacity: 0}, 3000 );
            }
        },
        error: function(e) {

        }
    });
}