<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>

<@h.head>
    <link rel="stylesheet" type="text/css" href="/templates/css/gradeBook.css"/>
</@h.head>


<body class="body">
<@navFoot.navbarFooter>
<div class="flex-container">

    <div class="custom-select-new" id="ClassNumberId_gradeBook">
        <select id="select_ClassNumberId_gradeBook">
            <option>Select Class:</option>
        </select>
    </div>

    <div class="custom-select-new">
        <select id="select_ClassLetterId_gradeBook">
            <option>Select Letter:</option>
        </select>
    </div>

    <div class="custom-select-new">
        <select id="select_SubjectId_gradeBook">
            <option>Select Subject:</option>
        </select>
    </div>

</div>



    <div id="hot"></div>




</@navFoot.navbarFooter>
<#--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>
<script src="/templates/css/js/gradeBook.js"></script>
<script src="/templates/css/js/customSelect.js"></script>
</body>