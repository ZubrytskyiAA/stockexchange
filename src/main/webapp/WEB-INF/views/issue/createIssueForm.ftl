<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body class="container">
<#include "*/header.ftl">

<#if errors??>
EROOR:
    <#list errors as error>
    <h1>error</h1><br>
    </#list>
</#if>


<form action="/issue/newIssue" method="post" name="issue" class="form-group">

    <td><input title="name" type="text" name="name" required></td>

    <td><input title="full_name" type="text" name="fullName" required></td>
    <td>
        <select name="active">
            <option value=1>Активный</option>
            <option value=0>Деактивированый</option>
        </select>

    </td>
    <td></td>
    <td><input type="submit" title="submit" value="Добавить"/></td>
</form>


<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 boxStyle"
             style="padding-right: 0px!important;padding-left: 0px!important;">
            <div class="panel-body" style="padding-right: 4px!important;padding-left: 4px!important;">
                <form method="post" name="challenge" class="form-horizontal" role="form" action="/issue/newIssue"
                      onSubmit="return submitForm()" AUTOCOMPLETE="off">
                    <fieldset class="landscape_nomargin"
                              style="min-width: 0;padding:    .35em .625em .75em!important;margin:0 2px;border: 2px solid silver!important;margin-bottom: 10em;">
                        <legend style="border-bottom: none;width: inherit;!important;padding:inherit;" class="legend">
                        <@spring.message "registerForm.Registration"/>
                        </legend>


                        <div class="form-group">
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                            <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel"
                                 style=" padding-top: 7px; text-align: right;">
                            <@spring.message "registerForm.firstName"/>  :
                            </div>

                            <div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad"
                                 style="font-weight:600;">

                                <input style="border-radius: 4px!important;" type="text" class="form-control"
                                       name="name" id="name" placeholder="AZST">

                            </div>
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                            <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel"
                                 style=" padding-top: 7px; text-align: right;">
                            <@spring.message "registerForm.lastName"/> :
                            </div>

                            <div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad"
                                 style="font-weight:600;">

                                <input style="border-radius: 4px!important;" type="text" class="form-control"
                                       name="fullName" id="fullName" placeholder="Azov Stal LTD">

                            </div>
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                            <div class="col-sm-11 col-md-11 col-lg-11 col-xs-10" style="text-align:center;">
                                <button id="valuser" type="submit" class="btn btn-success">
                                <@spring.message "Send"/>
                                </button>
                            </div>

                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                        </div>

                    </fieldset>

                </form>
            </div>
        </div>

    </div>
</div>

</body>
</html>