<#macro registrationSchoolKid>

   <#-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
<#--    SCHOOLKID at the end of each id as a ROLE, we send it as param
    onclick="userRegistration('formRegistrationSchoolKid','SCHOOLKID')"-->


    <form  id="formRegistrationSchoolKid">

        <div>
            <div class="invalid-feedback" id="loginLabelSCHOOLKID" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Login</b></label>
            <input type="text" class="form-control"  name="login" id="loginSCHOOLKID" placeholder="Name" autocomplete="off" value="T"/>
        </div>

        <div>
            <div class="invalid-feedback" id="emailLabelSCHOOLKID" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Email</b></label>
            <input type="email" class="form-control"  name="email" id="emailSCHOOLKID" placeholder="pewe@email-host.info" autocomplete="off" value="pewe@email-host.info"/>
        </div>


        <div>
            <div class="invalid-feedback" id="passwordLabelSCHOOLKID" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Password</b></label>
            <input type="password" class="form-control"  name="password" id="passwordSCHOOLKID" placeholder="Password" value="1"/>
        </div>


        <div>
            <div class="invalid-feedback" id="passwordConfirmLabelSCHOOLKID" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Repeat password</b></label>
            <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirmSCHOOLKID" placeholder="Confirm" autocomplete="off" value="1">
        </div>


        <div>
            <div class="invalid-feedback" id="firstNameLabelSCHOOLKID" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>First Name</b></label>
            <input type="text" class="form-control" name="firstName" id="firstNameSCHOOLKID" placeholder="FirstName" autocomplete="off" value="Kolya">
        </div>

        <div>
            <div class="invalid-feedback" id="lastNameLabelSCHOOLKID" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Last Name</b></label>
            <input type="text" class="form-control" name="lastName" id="lastNameSCHOOLKID" placeholder="LastName" autocomplete="off" value="Chernov">
        </div>

        <div>
            <div class="invalid-feedback" id="patronymicLabelSCHOOLKID" style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Patronymic</b></label>
            <input type="text" class="form-control" name="patronymic" id="patronymicSCHOOLKID" placeholder="Patronymic" autocomplete="off" value="Volodumirovuch">
        </div>
        <div>
            <div class="invalid-feedback" id="accessKeyForSchoolKidLabelSCHOOLKID"  style="display: none">
                <#--Error Message-->
            </div>
            <label><b>Access Key</b></label>
            <input type="text" class="form-control" name="accessKeyForSchoolKid" id="accessKeyForSchoolKidSCHOOLKID" placeholder="Access Key" value="robot" autocomplete="off" >
        </div>

        <div class="content">
            <div >
                <input type="file" name="file" id="fileSchoolKid" class="inputfile inputfile-1" data-multiple-caption="{count} files selected" multiple />
                <label for="fileSchoolKid"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17">
                        <path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/>
                    </svg>
                    <span>Choose a file&hellip;</span>
                </label>
            </div>
        </div>


        <div>
            <div class="g-recaptcha" data-sitekey="6Lc7jIcUAAAAAJDybby4pHe_06m8kACP-jdY5CGG"></div>
            <#--Error Message-->
            <div id="reCaptchaLabelSCHOOLKID" class="alert alert-danger" role="alert" style="display: none; margin: 0px">
                Please fill reCaptcha
            </div>
        </div>

        <input type="hidden" name="role" value="SCHOOLKID">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <#--registration.js on click run the function-->
        <div><input <#--id="registerSubmit"--> onclick="userRegistration('formRegistrationSchoolKid','SCHOOLKID')" type="button" value="Submit"></div>

    </form>
</#macro>