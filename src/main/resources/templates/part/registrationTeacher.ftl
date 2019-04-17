<#macro registrationTeacher>


    <form  id="formRegistrationTeacher">

        <div>
            <div class="invalid-feedback" id="loginLabelTEACHER" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Login</b></label>
            <input type="text" class="form-control"  name="login" id="loginTEACHER" placeholder="Name" autocomplete="off" value="T"/>
        </div>

        <div>
            <div class="invalid-feedback" id="emailLabelTEACHER" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Email</b></label>
            <input type="email" class="form-control"  name="email" id="emailTEACHER" placeholder="pewe@email-host.info" autocomplete="off" value="pewe@email-host.info"/>
        </div>


        <div>
            <div class="invalid-feedback" id="passwordLabelTEACHER" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Password</b></label>
            <input type="password" class="form-control"  name="password" id="passwordTEACHER" placeholder="Password" value="1"/>
        </div>


        <div>
            <div class="invalid-feedback" id="passwordConfirmLabelTEACHER" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Repeat password</b></label>
            <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirmTEACHER" placeholder="Confirm" autocomplete="off" value="1">
        </div>


        <div>
            <div class="invalid-feedback" id="firstNameLabelTEACHER" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>First Name</b></label>
            <input type="text" class="form-control" name="firstName" id="firstNameTEACHER" placeholder="FirstName" autocomplete="off" value="Kolya">
        </div>

        <div>
            <div class="invalid-feedback" id="lastNameLabelTEACHER" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Last Name</b></label>
            <input type="text" class="form-control" name="lastName" id="lastNameTEACHER" placeholder="LastName" autocomplete="off" value="Derkach">
        </div>

        <div>
            <div class="invalid-feedback" id="patronymicLabelTEACHER" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Patronymic</b></label>
            <input type="text" class="form-control" name="patronymic" id="patronymicTEACHER" placeholder="Patronymic" autocomplete="off" value="Volodumirovuch">
        </div>
        <div>
            <div class="invalid-feedback" id="accessKeyForTeacherLabelTEACHER"  style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Access Key</b></label>
            <input type="text" class="form-control" name="accessKeyForTeacher" id="accessKeyForTeacherTEACHER" placeholder="Access Key" value="unicorn" autocomplete="off" >
        </div>

        <div class="content">
            <div >
                <input type="file" name="file" id="fileTeacher" class="inputfile inputfile-1" data-multiple-caption="{count} files selected" multiple />
                <label for="fileTeacher"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
            </div>
        </div>


        <div>
            <div class="g-recaptcha" data-sitekey="6Lc7jIcUAAAAAJDybby4pHe_06m8kACP-jdY5CGG"></div>
            <#--Error Message-->
            <div id="reCaptchaLabelTEACHER" class="alert alert-danger" role="alert" style="display: none; margin: 0px">
                Please fill reCaptcha
            </div>
        </div>

        <input type="hidden" name="role" value="TEACHER">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <#--registration.js on click run the function-->
        <div><input <#--id="registerSubmit"--> onclick="userRegistration('formRegistrationTeacher','TEACHER')" type="button" value="Submit"></div>

    </form>
</#macro>