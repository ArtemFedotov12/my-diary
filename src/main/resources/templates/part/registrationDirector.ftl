<#macro registrationDirector>


<form  id="formRegistrationDirector" <#--enctype="multipart/form-data" autocomplete="off"-->>

    <div>
        <div class="invalid-feedback" id="loginLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Login</b></label>
        <input type="text" class="form-control"  name="login" id="login" placeholder="Login" autocomplete="off" value="Dir"/>
    </div>

    <div>
        <div class="invalid-feedback" id="emailLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Email</b></label>
        <input type="email" class="form-control"  name="email" id="email" placeholder="vasdsdsya@gmail.com" autocomplete="off" value="vasya@gmail.com"/>
    </div>


    <div>
        <div class="invalid-feedback" id="passwordLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Password</b></label>
        <input type="password" class="form-control"  name="password" id="password" placeholder="Password" value="1"/>
    </div>


    <div>
        <div class="invalid-feedback" id="passwordConfirmLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Repeat password</b></label>
        <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="Confirm" autocomplete="off" value="1">
    </div>



    <div>
        <div class="invalid-feedback" id="firstNameLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>First Name</b></label>
        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="FirstName" autocomplete="off" value="Kolya">
    </div>

    <div>
        <div class="invalid-feedback" id="lastNameLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Last Name</b></label>
        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="LastName" autocomplete="off" value="Derkach">
    </div>

    <div>
        <div class="invalid-feedback" id="patronymicLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Patronymic</b></label>
        <input type="text" class="form-control" name="patronymic" id="patronymic" placeholder="Patronymic" autocomplete="off" value="Volodumirovuch">
    </div>

    <div>
        <div class="invalid-feedback" id="activationCodeForProductLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Activation Code For Product</b></label>
        <input type="text" class="form-control" name="activationCodeForProduct" id="activationCodeForProduct" placeholder="Activation Code" autocomplete="off" value="4126420a-cde8-4902-ade3-95a8e8627f4a" >
    </div>

    <div>
        <div class="invalid-feedback" id="accessKeyForTeacherLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Access Key for teacher</b></label>
        <input type="text" class="form-control" name="accessKeyForTeacher" id="accessKeyForTeacher" placeholder="Access Key for teacher" autocomplete="off"  >
    </div>




    <div>
        <div class="invalid-feedback" id="countryLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Country</b></label>
        <div class="input-group mb-3">
            <select class="form-control" name="country" id="country"  <#--id="inputGroupSelect02" -->style="border-radius: 20px; margin:8px 0px -8px 0px;padding: 0px 20px;">
                <option  value="">Choose...</option>
                <option selected value="au">Ukraine</option>
                <option value="ca">Russia</option>
                <option value="usa">USA</option>
            </select>
        </div>
    </div>

    <div>
        <div class="invalid-feedback" id="townLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Town</b></label>
        <input type="text" class="form-control"  name="town" id="town" placeholder="Town" value="Chernihiv"/>
    </div>



    <div>
        <div class="invalid-feedback" id="schoolnumberLabel" style="display: none">
            <#--Error Message-->
        </div>
        <label><b>Number of the school</b></label>
        <input type="text" class="form-control" name="schoolnumber" id="schoolnumber" placeholder="The number of school" value="12"/>
    </div>

    <#-- <div class="custom-file">
         <input type="file" class="custom-file-input" id="file">
         <label class="custom-file-label" for="file">Choose file</label>
     </div>-->

    <div class="content">
        <div >
            <input type="file" name="file" id="file-1" class="inputfile inputfile-1" data-multiple-caption="{count} files selected" multiple />
            <label for="file-1"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
        </div>


    <div>
        <div class="g-recaptcha" data-sitekey="6Lc7jIcUAAAAAJDybby4pHe_06m8kACP-jdY5CGG"></div>
        <#--Error Message-->
        <div id="reCaptchaLabel" class="alert alert-danger" role="alert" style="display: none; margin: 0px">
            Please fill reCaptcha
        </div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <#--registration.js on click run the function-->
    <div><input <#--id="registerSubmit"--> onclick="userRegistration()" type="button" value="Submit"></div>

</form>
</#macro>