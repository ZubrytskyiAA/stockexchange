<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="container">

<#--<form action="/loginPage" method="post" class="form-group">-->
    <#--Name-->
    <#--<input title="Name" type="text" name="loginName">-->
    <#--Password-->
    <#--<input title="Password" type="text" name="password">-->
    <#--<input type="submit" value="Login">-->
<#--</form>-->



<div class="container " style=" padding-top: 10%">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login ">
                <div class="panel-heading">
                    <div class="row text-center">
                        Trade site Logo
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
                                           placeholder="Username" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2"
                                           class="form-control" placeholder="Password">
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                                                   class="form-control btn btn-login" value="Log In">
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