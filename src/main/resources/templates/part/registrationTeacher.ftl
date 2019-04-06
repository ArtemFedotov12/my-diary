<#macro registrationTeacher>


    <form  id="formRegistration" <#--enctype="multipart/form-data" autocomplete="off"-->>

        <div>
            <div class="invalid-feedback" id="nameLabel" style="display: none">
                <#--Error Message-->
            </div>
            <input type="text" class="form-control"  name="login" id="name" placeholder="Name" autocomplete="off" value="BWW"/>
        </div>

        <div>
            <div class="invalid-feedback" id="emailLabel" style="display: none">
                <#--Error Message-->
            </div>
            <input type="email" class="form-control"  name="email" id="email" placeholder="vasdsdsya@gmail.com" autocomplete="off" value="vasya@gmail.com"/>
        </div>


        <div>
            <div class="invalid-feedback" id="passwordLabel" style="display: none">
                <#--Error Message-->
            </div>
            <input type="password" class="form-control"  name="password" id="password" placeholder="Password" value="1"/>
        </div>


        <div>
            <div class="invalid-feedback" id="passwordConfirmLabel" style="display: none">
                <#--Error Message-->
            </div>
            <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="Confirm" autocomplete="off" value="1">
        </div>







        <div>
            <div class="invalid-feedback" id="firstNameLabel" style="display: none">
                <#--Error Message-->
            </div>
            <input type="text" class="form-control" name="firstName" id="firstName" placeholder="FirstName" autocomplete="off" value="Kolya">
        </div>

        <div>
            <div class="invalid-feedback" id="lastNameLabel" style="display: none">
                <#--Error Message-->
            </div>
            <input type="text" class="form-control" name="lastName" id="lastName" placeholder="LastName" autocomplete="off" value="Derkach">
        </div>

        <div>
            <div class="invalid-feedback" id="patronymicLabel" style="display: none">
                <#--Error Message-->
            </div>
            <input type="text" class="form-control" name="patronymic" id="patronymic" placeholder="Patronymic" autocomplete="off" value="Volodumirovuch">
        </div>
        <div>
            <div class="invalid-feedback" id="accessKeyForTeacherLabel" style="display: none">
                <#--Error Message-->
            </div>
            <input type="text" class="form-control" name="accessKeyForTeacher" id="accessKeyForTeacher" placeholder="Access Key" autocomplete="off" >
        </div>
        <#-- <div class="custom-file">
             <input type="file" class="custom-file-input" id="file">
             <label class="custom-file-label" for="file">Choose file</label>
         </div>-->
        <input  name="file" type="file">


        <div>
            <div class="g-recaptcha" data-sitekey="6Lc7jIcUAAAAAJDybby4pHe_06m8kACP-jdY5CGG"></div>
            <#--Error Message-->
            <div id="reCaptchaLabel" class="alert alert-danger" role="alert" style="display: none; margin: 0px">
                Please fill reCaptcha
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <#--registration.js on click run the function-->
        <div><input id="registerSubmit" type="button" value="Submit"></div>

    </form>
</#macro>