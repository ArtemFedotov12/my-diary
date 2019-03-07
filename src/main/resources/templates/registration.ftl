<#import "part/page.ftl" as p>
<@p.page>

<h1>Registration</h1>

<div class="registration" name="registrationform" id="registrationId">
            <form action="/registration" method="post" enctype="multipart/form-data">
<#--<p> <input type="text" name="text" placeholder="Name" maxlength="10" autocomplete="off"></p>
 <p><input type="password" name="password" placeholder="Password" autofocus></p>-->

   <#-- private Long id;
    private String name;
    private String password;
    private String email;
    private String town;
    private String country;
    private String schoolnumber;-->
                <div class="form-row">

    <div class="invalid-feedback""><#if nameError??>${nameError} </#if></div>
    <input type="text" class="${(nameError??)?string('is-invalid','')} form-control is-valid" name="name" placeholder="Name" autocomplete="off" value="B"/>


    <div class="invalid-feedback""><#if emailError??>${emailError} </#if></div>
    <input type="email" class="${(emailError??)?string('is-invalid','')}" name="email" placeholder="vasya@gmail.com" autocomplete="off" value="vasya@gmail.com"/>

    <div><#if passwordError??>${passwordError} </#if></div>
    <input type="password" class="${(passwordError??)?string('is-invalid','')}" name="password" placeholder="Password" autocomplete="off" value="1">

    <div><#if password2Error??>${password2Error} </#if></div>
    <input type="password" class="${(password2Error??)?string('is-invalid','')}" name="passwordConfirm" placeholder="Confirm" autocomplete="off" value="1">


    <select  name="country">
        <option value="au">Ukraine</option>
        <option value="ca">Russia</option>
        <option value="usa">USA</option>
    </select>

    <div><#if townError??>${townError} </#if></div>
    <input type="text" class="${(townError??)?string('is-invalid','')}" name="town" placeholder="Town" value="b"/>

    <div><#if schoolnumberError??>${schoolnumberError} </#if></div>
    <input type="text" class="${(townError??)?string('is-invalid','')}" name="schoolnumber" placeholder="Schoolnumber" value="b"/>

    <input type="file" name="file">

    <input type="reset"  >

   <div>
              <#if captchaError??> ${captchaError}</#if>
        <div class="g-recaptcha" data-sitekey="6Lc7jIcUAAAAAJDybby4pHe_06m8kACP-jdY5CGG"></div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="submit" value="Submit"></div>
                </div>
    </form>
</div>

</@p.page>
