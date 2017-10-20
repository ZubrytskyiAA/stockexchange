$(document).ready(function () {
    $("#view_button3").bind("mousedown touchstart", function () {
        $("#password").attr("type", "text");
    }), $("#view_button3").bind("mouseup touchend", function () {
        $("#password").attr("type", "password");
    }), $("#view_button4").bind("mousedown touchstart", function () {
        $("#verifypassword").attr("type", "text");
    }), $("#view_button4").bind("mouseup touchend", function () {
        $("#verifypassword").attr("type", "password")
    })
});

function passwordChecker() {
    $('#verifypassword').val('');
    $('#message1').html('');
    $('#message8').html('');
    $('#message10').html('');
    $('#message').html('');
    $('#message2').html('');
    $('#message3').html('');
    $('#message4').html('');
    $('#message5').html('');
    $('#message6').html('');
    $('#message7').html('');
    if ($('#password').val().length >= 4) {
        if (newValPassPoilcy() === true) {
            $('#message').css('color', 'green');
            $('#message').html('<@spring.message "registerForm.strongPassword"/>');
            if ($('#password').val().length >= 9) {
                $('#message').html('');
                $('#message1').html('');
            }
            return true;
        }
    }


}

function NumAndWordRep() {

    return true;
}

function userNameAsPass() {
    var password = $('#password').val().toLowerCase();
    var uname = $('#username').val().toLowerCase();

    var uname1 = new RegExp(uname);
    if (null !== uname && '' !== uname) {
        if (uname1.test(password)) {

            $('#message6').css('color', 'red');
            $('#message6').html('<@spring.message "registerForm.passwordContainLogin"/>');
            return false;
        }
    }
    else {
        $('#message6').html('');
        $('#message10').css('color', 'red');
        $('#message10').css('font-weight', 'bold');
        $('#message10').html('<@spring.message "registerForm.loginFirst"/>');
        return false;
    }
    return true;

}


function newValPassPoilcy() {

    var password = $('#password').val();
    if (!password.match(/^(?=.{6,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&_+=\\*\\-\\(\\)\\{\\}\\:\\;\\<\\>\\|\\,\\.\\?\\/\\'\\"]).*$/) || userNameAsPass() === false || NumAndWordRep() === false) {

        $('#message8').css('color', 'red');
        $('#message8').html('<@spring.message "registerForm.passwordMustContain"/>');
        if (!password.match(/^(?=.{6,}).*$/)) {
            $('#message').css('color', 'red');
            $('#message').html('<@spring.message "registerForm.minimumChaster"/>');

        }
        if (!password.match(/^(?=.*[0-9]).*$/)) {
            $('#message2').css('color', 'red');
            $('#message2').html('<@spring.message "registerForm.oneNumber"/>');

        }
        if (!password.match(/^(?=.*[a-z]).*$/)) {
            $('#message3').css('color', 'red');
            $('#message3').html('<@spring.message "registerForm.lowercaseCharacter"/>');

        }
        if (!password.match(/^(?=.*[A-Z]).*$/)) {
            $('#message4').css('color', 'red');
            $('#message4').html('<@spring.message "registerForm.uppercase"/>');

        }
        if (!password.match(/^(?=.*[!@#$%^&_+=\\*\\-\\(\\)\\{\\}\\:\\;\\<\\>\\|\\,\\.\\?\\/\\'\\"]).*$/)) {

            $('#message5').css('color', 'red');
            $('#message5').html('<@spring.message "registerForm.specialCharacter"/>');

        }
        if (userNameAsPass() === false) {
            if (password.match(/^(?=.{6,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&_+=\\*\\-\\(\\)\\{\\}\\:\\;\\<\\>\\|\\,\\.\\?\\/\\'\\"]).*$/)) {
                $('#message8').html('');
            }

        }
        if (NumAndWordRep() === false) {
            if (password.match(/^(?=.{6,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&_+=\\*\\-\\(\\)\\{\\}\\:\\;\\<\\>\\|\\,\\.\\?\\/\\'\\"]).*$/)) {
                $('#message8').html('');
            }

        }
        return false;
    }
    else {

        return true;
    }

}

function submitForm1(obj) {

    if (document.getElementById("username").value.trim() === "" && document.getElementById("username").value !== null) {
        $('#message1').css('color', 'red');
        $('#message1').html('<@spring.message "registerForm.enterLogin"/>');
    }
    else if (document.getElementById("yourEmail").value.trim() === "" && document.getElementById("yourEmail").value !== null) {
        $('#message1').css('color', 'red');
        $('#message1').html('<@spring.message "registerForm.enterEmail"/>');
    }
    else if (checkEmail() === false) {
        $('#message1').css('color', 'red');
        $('#message1').html('<@spring.message "registerForm.enterValidEmail"/>');

    }
    else if (newValPassPoilcy() === false) {
    }
    else if (document.getElementById("password").value.trim() === "" && document.getElementById("password").value !== null) {
        $('#message1').css('color', 'red');
        $('#message1').html('<@spring.message "registerForm.enterPassword"/>');
    }
    else if (document.getElementById("verifypassword").value.trim() === "" && document.getElementById("verifypassword").value !== null) {
        $('#message1').css('color', 'red');
        $('#message1').html('<@spring.message "registerForm.confPassword"/>');
    }
    else if ($('#password').val() != $('#verifypassword').val()) {
        $('#message1').css('color', 'red');
        $('#message1').html('<@spring.message "registerForm.samePassword"/>');
        return false;
    }
    else {

        if (obj == "true") {
            $('#message1').css('color', 'red');
            $('#message1').html('<@spring.message "registerForm.loginExist"/>');
            return false;
        }
        else {
            $('#message1').css('color', 'green');
            $('#message1').html('<@spring.message "registerForm.success"/>');

            return true;
        }

    }

}


function submitForm() {

    var login = document.getElementById("username").value.trim();
    var password = document.getElementById("password").value.trim();
    var firstName = document.getElementById("fname").value.trim();
    var lastName = document.getElementById("lname").value.trim();
    var email = document.getElementById("yourEmail").value.trim();


    $.ajax({
        method: "GET",
        url: "http://localhost:8080/values?login=" + login + "&password=" + password + "&fname=" + firstName + "&lname=" + lastName + "&email=" + email,
        success: function (data) {
            submitForm1(data);
        }
    });


}


function checkEmail() {
    var email = $('#yourEmail').val();
    if ((email.indexOf(".") > 2) && (email.indexOf("@") > 0)) {
        return true;
    }
    else {
        return false;
    }

}

