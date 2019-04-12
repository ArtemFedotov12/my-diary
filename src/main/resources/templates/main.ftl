<#--to add Freemarker add to application.pro-->
<#--spring.freemarker.expose-request-attributes=true
<input type="hidden" login="_csrf" value="${_csrf.token}">
-->
<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#include "part/security.ftl">

<@h.head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" type="text/css" href="/templates/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/component.css"/>

    <script>
        (function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>
</@h.head>

<body class="body">
<@navFoot.navbarFooter>
<div>
<#--<h1>Welcome <#if login??>${login}!</#if></h1>-->
    <h1>Kek</h1>

    <#--<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>-->


    <div class="container">
        <header class="codrops-header">
            <div class="codrops-links">
                <a class="codrops-icon codrops-icon--prev" href="http://tympanus.net/Tutorials/SVGRipples/" title="Previous Demo"><span>Previous Demo</span></a>
                <a class="codrops-icon codrops-icon--drop" href="http://tympanus.net/codrops/?p=24831" title="Back to the article"><span>Back to the Codrops article</span></a>
            </div>
            <h1>Custom File Inputs</h1>
            <p>Demo for the tutorial: <strong><a href="http://tympanus.net/codrops/?p=24831">Styling and Customizing File Inputs the Smart Way</a></strong></p>
        </header>
        <div class="content">

            <div class="box">
                <input type="file" name="file-1[]" id="file-1" class="inputfile inputfile-1" data-multiple-caption="{count} files selected" multiple />
                <label for="file-1"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
            </div>

            <div class="box">
                <input type="file" name="file-2[]" id="file-2" class="inputfile inputfile-2" data-multiple-caption="{count} files selected" multiple />
                <label for="file-2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
            </div>

            <div class="box">
                <input type="file" name="file-3[]" id="file-3" class="inputfile inputfile-3" data-multiple-caption="{count} files selected" multiple />
                <label for="file-3"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
            </div>

            <div class="box">
                <input type="file" name="file-4[]" id="file-4" class="inputfile inputfile-3" data-multiple-caption="{count} files selected" multiple />
                <label for="file-4"><span>Choose a file&hellip;</span></label>
            </div>

            <div class="box">
                <input type="file" name="file-5[]" id="file-5" class="inputfile inputfile-4" data-multiple-caption="{count} files selected" multiple />
                <label for="file-5"><figure><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg></figure> <span>Choose a file&hellip;</span></label>
            </div>

            <div class="box">
                <input type="file" name="file-6[]" id="file-6" class="inputfile inputfile-5" data-multiple-caption="{count} files selected" multiple />
                <label for="file-6"><figure><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg></figure> <span></span></label>
            </div>

            <div class="box">
                <input type="file" name="file-7[]" id="file-7" class="inputfile inputfile-6" data-multiple-caption="{count} files selected" multiple />
                <label for="file-7"><span></span> <strong><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> Choose a file&hellip;</strong></label>
            </div>

            <footer>Upload icon by <a href="http://www.flaticon.com/free-icon/outbox_3686" target="_blank">FlatIcon</a>.</footer>

        </div>
        <!-- Related demos -->
        <section class="content content--related">
            <p>If you enjoyed this demo you might also like:</p>
            <a class="media-item" href="">
                <img class="media-item__img" src="img/related/SelectInspiration.png">
                <h3 class="media-item__title">Inspiration for Custom Select Elements</h3>
            </a>
            <a class="media-item" href="">
                <img class="media-item__img" src="img/related/TextInputEffects.jpg">
                <h3 class="media-item__title">Inspiration for Text Input Effects</h3>
            </a>
        </section>
    </div><!-- /container -->





</div>

</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>
<script src="/templates/css/js/main.js"></script>

    <#--Maybe you need to delete it-->
<script src="/templates/css/js/navbarFooter.js"></script>

<#--Choose file-->
<script src="/templates/css/js/custom-file-input.js"></script>
</body>
