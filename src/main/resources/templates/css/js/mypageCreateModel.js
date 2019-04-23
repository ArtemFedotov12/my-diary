function openCreateGradeBookModel() {

    //Delete evertything from tag <select>
    $('#selectClassNumberCreateGradebookId option').each(function() {
            $(this).remove();
    });

 /*    i=0;
    for(i;i<3;i++){
        var option = document.createElement("option");
        option.text = "Kiwi"+i;
        x.add(option);
        console.log("add"+i)
    }*/
    $("#createGradeBookId").css("display", "block");

    var form = $('#createGradebookFormId')[0];
    var data = new FormData(form);
    $.ajax({
        method: "GET",
        url: "/getListOfClasses",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {
            var data=result.data;


            if (result.status==="success"){
                console.log(result.data);
                var x = document.getElementById("selectClassNumberCreateGradebookId");
                i=0;
                for(i;i<result.data.length;i++){
                    var option = document.createElement("option");
                    option.text = result.data[i];
                    if(i===0)
                    option.selected='selected';
                    x.add(option);
                    console.log("add"+i)
                }










            }


            if (result.status==="failure"){
                console.log("failure");

            }



        },
        error: function(e) {

        }
    });


}