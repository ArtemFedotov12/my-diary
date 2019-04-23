<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>

<@h.head>
    <link rel="stylesheet" type="text/css" href="/templates/css/gradeBook.css"/>
</@h.head>


<body class="body">
<@navFoot.navbarFooter>
<div class="flex-container">

    <div class="custom-select-new">
        <select >
            <option value="0">Select Class:</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
        </select>
    </div>
    <div class="custom-select-new">
        <select>
            <option value="0">Select Letter:</option>
            <option value="1">A</option>
            <option value="2">B</option>
            <option value="3">C</option>
            <option value="4">D</option>
            <option value="5">E</option>
            <option value="6">F</option>
            <option value="7">G</option>
            <option value="8">H</option>
        </select>
    </div>
</div>



    <div id="hot"></div>




</@navFoot.navbarFooter>
<#--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>
<script src="/templates/css/js/customSelect.js"></script>
</body>