<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#import "part/registrationDirector.ftl" as d>
<#import "part/registrationTeacher.ftl" as t>
<@h.head>

    <link rel="stylesheet" href="/templates/css/registrationn.css">

    <link rel="stylesheet" type="text/css" href="/templates/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/component.css"/>

<#--  <meta name="_csrf" content="${_csrf.token}"/>
  <!-- default header login is X-CSRF-TOKEN &ndash;&gt;
  <meta name="_csrf_header" content="${_csrf.headerName}"/>-->
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<#--Script for Choose file. Never mind-->
    <script>
        (function(e,t,n){
                var r=e.querySelectorAll("html")[0];
                r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")
            }
        )(document,window,0);
    </script>

</@h.head>

<body class="body">
<@navFoot.navbarFooter>


    <h1  style="text-align: center">Registration</h1>


    <div class="w3-container">

        <div class="w3-bar" style="margin: auto;width: 350px;">
            <#--<button class="w3-bar-item w3-button tablink w3-red btn-width" onclick="openCity(event,'user')">User</button>-->

<#--
            <button class="tablinks" onclick="openCity(event, 'Director')" id="defaultOpen">Register School</button>
            <button class="tablinks" onclick="openCity(event, 'Teacher')">Teacher</button>-->

        </div>


        <div class="registration">
            <button class="tablinks" onclick="openCity(event, 'Director')" id="defaultOpen">Register School</button>
            <button class="tablinks" onclick="openCity(event, 'Teacher')">Teacher</button>
            <button class="tablinks" onclick="openCity(event, 'Teacher')">Pupil</button>

            <div id="Director" class="tabcontent">
                <@d.registrationDirector></@d.registrationDirector>
            </div>

            <div id="Teacher" class="tabcontent">
                <@t.registrationTeacher></@t.registrationTeacher>
            </div>

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
<#--Choose file-->
<script src="/templates/css/js/custom-file-input.js"></script>

<script>
    function openCity(evt, cityName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";
    }

    // Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();
</script>
</body>


