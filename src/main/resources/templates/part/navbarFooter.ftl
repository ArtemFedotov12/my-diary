<#include "security.ftl">
<#macro navbarFooter>
    <!-- !!!!!!!!!!!!!!!!!!!!!!!!!! id="main" for js for footer-->
    <div id="main">
        <div class="topnav" id="myTopnav">
            <div class="nav-bar">
                <a  href="/#C1" id="C1">Home</a>
                <a href="/mypage#C2" id="C2">My Page</a>
                <a href="#contact">Contact</a>
                <a href="#about">About</a>
                <a  href="/user">Admin</a>
                <#--      <a href="/logout" class="sign_out"  type="submit">Sign Out </a>-->
                <form  action="/logout" method="post">
                    <#-- don't forget _csrf.token  otherwise yo uwill se this message
                        "This application has no explicit mapping for /error, so you are seeing this as a fallback."-->
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button class="sign_out"  type="submit">Sign Out </button>
                </form>
            </div>
            <div><a href="javascript:void(0);" class="icon" onclick="myFunction()">
                    <i class="fa fa-bars"></i>
                </a>
            </div>
        </div>
        <div class="user_name">${name}</div>


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
</#macro>