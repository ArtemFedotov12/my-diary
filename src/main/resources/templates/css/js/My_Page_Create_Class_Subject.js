


function createClass() {
   /* $("#createClassId").css("display", "none");*/
    var form = $('#createClassFormId')[0];
    var data = new FormData(form);

    $.ajax({
        method: "POST",
        url: "/createClass",
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

                //Reduce opacity to 0%
                $( "#classCreateSuccessId" ).animate({opacity: 0}, 3000 );
            }
        },
        error: function(e) {

        }
    });
}




//createSubject




function createSubject() {
    /* $("#createClassId").css("display", "none");*/
    var form = $('#createSubjectFormId')[0];
    var data = new FormData(form);

    $.ajax({
        method: "POST",
        url: "/createSubject",
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
                console.log("Fail4");
                if(data["nameOfSubjectError"]!=null){
                    $("#nameOfSubjectCreateSubjectId").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#nameOfSubjectLabelCreateSubjectId").css("display", "block").text(data["nameOfSubjectError"]);
                }else {
                    $("#nameOfSubjectCreateSubjectId").removeClass("is-invalid").addClass("is-valid");
                    $("#nameOfSubjectLabelCreateSubjectId").css("display", "none");
                }
            }

            if (result.status==="success"){
                console.log("success4");
                $( ".form-control" ).each(function() {
                    $(this).removeClass("is-invalid").addClass("is-valid");
                });
                $( ".invalid-feedback" ).each(function() {
                    $(this).css("display", "none");
                });
                //Set opacity 100%
                $( "#subjectCreateSuccessId" ).animate({opacity: 1}, 3 );
                $("#subjectCreateSuccessId").text("Subject was created");
                //Reduce opacity to 0%
                $( "#subjectCreateSuccessId" ).animate({opacity: 0}, 3000 );
            }
        },
        error: function(e) {

        }
    });
}

