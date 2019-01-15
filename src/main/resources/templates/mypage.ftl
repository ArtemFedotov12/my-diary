<#include "part/security.ftl">
<#import "part/page.ftl" as p>
<@p.page>


    <div class="main clearfix">
        <div class="name"><#if teacher.name??><h1>${name}</h1></#if></div>
    <#-- <#if filename??><img src="/img/${filename}" style="height: 128px"></#if>-->
    <#--<div class="image"> <#if teacher.filename??><img src="/img/${teacher.filename}" style="width: 20%"></#if></div>-->
        <div class="image">
         <#if teacherPage.filename??><img src="/img/${teacherPage.filename}" style="width: 100%"></#if>
        </div>


        <div class="information">
            <div class="clearfix">
                <#--<p class="editClass"><#if teacherPage.email??>${teacherPage.email}</#if></p>-->
                <input type="text" id="emailInputId" class="editClass input-email" value="<#if teacherPage.email??>${teacherPage.email}</#if>" readonly>
                <button onclick="changeEmail()" class="editClass btn-edit">Edit</button>
            </div>

            <div id="blockId" style="display: none">
                <button onclick="handleRequest()">Send</button>
            </div>



            <div id="response"></div>

            <select name="country" style="width: 60%">
                <option value="au">Ukraine</option>
                <option value="ca" <#if teacher.country=="ca">selected</#if>>Russia</option>
                <option value="usa">USA</option>
            </select>
          <#--  <p><#if teacherPage.town??>${teacherPage.town}</#if></p>
            <p><#if teacherPage.schoolnumber??>${teacherPage.schoolnumber}</#if></p>-->
        <#--<#if teacher.??>${}</#if>-->
        </div>


    </div>

</@p.page>


