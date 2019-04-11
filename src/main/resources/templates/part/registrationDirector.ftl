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
            <select class="form-control" name="country" id="country"  <#--id="inputGroupSelect02" -->style="border-radius: 20px; margin:8px 0px -8px 0px;">
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
    <label><b>Choose the photo</b></label>
    <input  name="file" type="file">


    <#--<div>
        <div class="g-recaptcha" data-sitekey="6Lc7jIcUAAAAAJDybby4pHe_06m8kACP-jdY5CGG"></div>
        &lt;#&ndash;Error Message&ndash;&gt;
        <div id="reCaptchaLabel" class="alert alert-danger" role="alert" style="display: none; margin: 0px">
            Please fill reCaptcha
        </div>
    </div>-->

    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <#--registration.js on click run the function-->
    <div><input <#--id="registerSubmit"--> onclick="userRegistration()" type="button" value="Submit"></div>

</form>
</#macro>