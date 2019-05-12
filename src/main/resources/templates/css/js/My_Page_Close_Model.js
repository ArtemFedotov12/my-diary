// When the user clicks anywhere outside of the modal, model will be closed
window.onclick = function(event) {

    var createClass = document.getElementById('createClassId');
    if (event.target == createClass) {
        createClass.style.display = "none";
    }


    var createGradeBook = document.getElementById('createGradeBookId');
    if (event.target == createGradeBook) {
        createGradeBook.style.display = "none";
    }



    var createSubject = document.getElementById('createSubjectId');
    if (event.target == createSubject) {
        createSubject.style.display = "none";
    }


};
