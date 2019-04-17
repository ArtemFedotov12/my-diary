<#include "security.ftl">
<#macro navbarFooter>
    <!-- !!!!!!!!!!!!!!!!!!!!!!!!!! id="main" for js for footer-->
    <div id="main">
        <div class="topnav" id="myTopnav">
            <div class="nav-bar">
                <a  href="/#C1" id="C1">Home</a>
                <#if currentUserId!=-1>
                    <a href="/mypage#C2" id="C2">My Page</a>
                </#if>
                <a href="/#contact" id="contact">Contact</a>
                <a href="#about" id="about">About</a>
                <#if isAdmin==true>
                    <a  href="/user#C3" id="C3">Admin</a>
                </#if>

                <#--      <a href="/logout" class="sign_out"  type="submit">Sign Out </a>-->
                <form  <#if currentUserId!=-1> action="/logout" method="post"</#if>   >
                    <#-- don't forget _csrf.token  otherwise yo uwill se this message
                        "This application has no explicit mapping for /error, so you are seeing this as a fallback."-->

                    <#if currentUserId!=-1> <input id="token" type="hidden" name="_csrf" value="${_csrf.token}"></#if>
                    <button class="sign_out"  onclick=<#if currentUserId==-1>"signIn()" <#else>"false"</#if>  type="submit">
                        <i class="fas fa-user-tie" style='font-size:25px;color:#000000'></i>
                        <#if currentUserId==-1>
                            Sign In
                        <#else>
                            Sign Out
                        </#if>

                    </button>
                </form>
            </div>
            <div><a href="javascript:void(0);" class="icon" onclick="myFunction()">
                    <i class="fa fa-bars"></i>
                </a>
            </div>
        </div>
        <div class="user_name">${login}</div>


        <div id="id01" class="modal">
            <form class="modal-content animate" action="/" method="post">
                <div class="imgcontainer ">
                    <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                    <img src="https://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" class="avatar">
                </div>

                <div class="container">
                    <label><b>Username</b></label>
                   <#-- name="username" because of @Override public String getUsername() { return login;}-->
                    <input type="text" placeholder="Enter Username" name="username" required>
                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" required>
                    <input  type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn-login">Sign in</button>
                    <label>
                        <input type="checkbox" checked="checked" name="remember"> Remember me
                    </label>
                </div>

                <div class="container" style="background-color:#f1f1f1">
                    <button type="button" id="cancelBtn"  class="cancelbtn fa fa-close"
                            onclick="document.getElementById('id01').style.display='none'" > Cancel</button>
                    <span class="psw"><a href="/registration">Registration</a></span>
                </div>
            </form>
        </div>


        <!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
        <#nested>


    </div>



    <div id="footer" class="footer-relative">
        <div class="footer-bottom">
            <div class="grid-container">
                <div class="item1"></div>
                <div class="item2" style="color:white; padding-bottom: 10px">About Company</div>
                <div class="item3" style="color:white">Possibilities</div>
                <div class="item4" style="color:white">Partners</div>
                <div class="item5"style="color:white">Support</div>
                <div class="item6"></div>
                <div class="item7"></div>
                <div class="item8">About us</div>
                <div class="item9">9</div>
                <div class="item10">Advertisement</div>
                <div class="item11">Assistance</div>
                <div class="item12"></div>
                <div class="item13"></div>
                <div class="item14">Contacts</div>
                <div class="item15">15</div>
                <div class="item16" style="font-size: 20px">&#169 2018-2019 "Dnevnik-online.com"</div>
            </div>
            <!--<div class="footer-bottom">&#169 2018-2019 "Dnevnik-online.com"</div>-->
        </div>
    </div>


    <script src="/templates/css/js/navbarFooter.js"></script>
</#macro>