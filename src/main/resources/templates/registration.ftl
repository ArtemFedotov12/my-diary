<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#import "part/registrationDirector.ftl" as d>
<#import "part/registrationTeacher.ftl" as t>
<@h.head>

    <link rel="stylesheet" href="/templates/css/registrationn.css">

<#--  <meta name="_csrf" content="${_csrf.token}"/>
  <!-- default header login is X-CSRF-TOKEN &ndash;&gt;
  <meta name="_csrf_header" content="${_csrf.headerName}"/>-->
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</@h.head>

<body class="body">
<@navFoot.navbarFooter>


    <h1  style="text-align: center">Registration</h1>


    <div class="w3-container">

        <div class="w3-bar" style="margin: auto;width: 350px;">
            <#--<button class="w3-bar-item w3-button tablink w3-red btn-width" onclick="openCity(event,'teacher')">User</button>-->
            <button class="w3-bar-item w3-button tablink  btn-width" onclick="openCity(event,'director')">Register a School</button>
        </div>

        <#--    <div id="London" class="w3-container w3-border city">
                <h2>London</h2>
                <p>London is the capital city of England.</p>
            </div>

            <div id="Paris" class="w3-container w3-border city" style="display:none">
                <h2>Paris</h2>
                <p>Paris is the capital of France.</p>
            </div>

            <div id="Tokyo" class="w3-container w3-border city" style="display:none">
                <h2>Tokyo</h2>
                <p>Tokyo is the capital of Japan.</p>
            </div>-->

        <div class="registration">

          <#--  <div id="teacher" class="school" >
                <@t.registrationTeacher></@t.registrationTeacher>
            </div>-->

            <div id="director" class="school" <#--style="display: none"-->>
                <@d.registrationDirector></@d.registrationDirector>
            </div>




        </div>


    </div>


</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" ></script>
<script src="/templates/css/js/footer.js" ></script>
<script src="/templates/css/js/regisration.js" ></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
<script src="/templates/css/js/navbarFooter.js"></script>

<script>
    function openCity(evt, positionOfPerson) {
        var i, x, tablinks;
        x = document.getElementsByClassName("school");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < x.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
        }
        document.getElementById(positionOfPerson).style.display = "block";
        evt.currentTarget.className += " w3-red";
    }
</script>
</body>


