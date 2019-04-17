


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