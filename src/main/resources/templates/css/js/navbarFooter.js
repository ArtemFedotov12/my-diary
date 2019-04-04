
 function signIn() {
    //Submit form won't happen  (cancel default behavior)
     event.preventDefault();
     document.getElementById('id01').style.display='block';
     console.log("Tet");
 }


     // Get the modal

     // When the user clicks anywhere outside of the modal, close it
     window.onclick = function(event) {
         var modal = document.getElementById('id01');
         if (event.target == modal) {
             modal.style.display = "none";
         }
     };


