function registrationFunction(form) { // onDomReady

    // reset handler that clears the form
    $('form[name="registrationform"] input:reset').click(function () {
        $('form[name="registrationform"]')
            .find('textarea, :text, :password,select').value(" ")

        return false;
    });

};
$("registrationId").trigger('reset');