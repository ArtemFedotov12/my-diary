<#include "part/security.ftl">
<#import "part/page.ftl" as p>
<@p.page>


    <div class="main clearfix">
        <div class="name"><#if teacher.name??><h1>${name}</h1></#if></div>

        <div class="image column">
            <#if teacherPage.filename??><img src="/img/${teacherPage.filename}" style="width: 100%"></#if>
        </div>


        <div class="information column">

            <input type="email" class="fields" name="email" placeholder="vasya@gmail.com"
                   value="<#if teacherPage.email??>${teacherPage.email}</#if>" disabled/>

            <input type="text" class="fields" name="town" placeholder="Kyiv"
                   value="<#if teacherPage.town??>${teacherPage.town}</#if>" disabled/>


            <div>
                <select class="fields" name="country" style="width: 60%" disabled>
                    <option value="au">Ukraine</option>
                    <option value="ca" <#if teacher.country=="ca">selected</#if>>Russia</option>
                    <option value="usa">USA</option>
                </select>
            </div>
            <div id="sendBtn" style="display: none">
                <button onclick="handleRequest()">Send</button>
            </div>
            <button onclick="changeEmail()" id="editBtn">Edit</button>
        </div>



    </div>

</@p.page>


