
    GET: $(document).ready(
        function() {

            // GET REQUEST
            $("#BtnLoginRequest").click(function (event) {
                event.preventDefault();
                ajaxGet();
            });


            function ajaxGet() {
                var username = $("#username").val();
                var sendParams = "/lo?username=" + username;
                $.ajax({
                    type: "GET",
                    url: sendParams,
                    contentType : "application/json",
                    success: function (result) {
                        if (result.status == "success") {
                            console.log(result.data["email"]+" er");

                        }}})}
        })





