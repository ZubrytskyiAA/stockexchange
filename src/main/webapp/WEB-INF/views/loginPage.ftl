<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body class="container">
<#import "/spring.ftl" as spring/>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
<script src="http://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>


<div class="container " style=" padding-top: 10%">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login ">
                <div class="panel-heading">
                    <div class="row text-center">


                        <div class="container-fluid" style=" padding-left: 90%">
                            <div class="row">

                                <div class="col-sm-1  col-md-1" style="border: none;">
                                    <button class="btn" type="button" style="background-color: rgba(245, 245, 245, 0);"
                                            data-toggle="dropdown"><@spring.message "header.language"/>
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="/login?mylocale=ua" title="UKRAINE">
                                                <img src="/ua.gif" alt="UA" height="12" width="20" border="0"> -
                                                Українська
                                            </a>
                                        </li>
                                        <li>
                                            <a href="/login?mylocale=ru" title="RUSSIAN">
                                                <img src="/resources/images/flags/ru.gif" alt="RU" height="12"
                                                     width="20" border="0"> - Русский
                                            </a>
                                        </li>
                                        <li>
                                            <a href="/login?mylocale=en" title="ENGLISH">
                                                <img src="/resources/images/flags/en.gif" alt="EN" height="12"
                                                     width="20" border="0"> - English
                                            </a>
                                        </li>
                                        <li>
                                            <a href="/login?mylocale=de" title="DEUTSCH">
                                                <img src="/resources/images/flags/de.gif" alt="DE" height="12"
                                                     width="20" border="0"> - Deutsch
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>


                    <@spring.message "TradeSite"/>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="login-form" action="/loginPage" method="post" role="form"
                                  style="display: block;">
                                <div class="form-group">
                                    <input type="text" name="loginName" id="loginName" tabindex="1" class="form-control"
                                           placeholder="<@spring.message "Username"/>" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2"
                                           class="form-control" placeholder="<@spring.message "Password"/>">
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input style="background-color:#46b8da" type="submit" name="login-submit" id="login-submit" tabindex="3"
                                                   class="form-control btn btn-primary"
                                                   value="<@spring.message "Login"/>">
                                        </div>
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <p><a href="/users/create" style=" background-color: #2e6da4"  class="btn btn-info btn-block">Yes please, register now!</a></p>
                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>