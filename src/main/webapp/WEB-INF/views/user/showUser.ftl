<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Account</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive">
    <caption align="center"><@spring.message "userInfo"/></caption>
    <table class="table-striped" width="400px">
        <tr>
            <td>ID</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td><@spring.message "Username"/></td>
            <td>${user.loginName}</td>
        </tr>
        <tr>
            <td><@spring.message "Password"/></td>
            <td>${user.password}</td>
        </tr>
        <tr>
            <td><@spring.message "registerForm.firstName"/></td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td><@spring.message "registerForm.lastName"/></td>
            <td>${user.lastName}</td>
        </tr>
        <tr>

            <td><@spring.message "registerForm.email"/></td>
            <td>${user.email}</td>
        </tr>
    </table>
</div>

<div class="table-responsive1" style="width: 200pt">

<#if listAssets??>
    <br>
    <br>
    <br>
    <br>
    <br>
    <caption><@spring.message "usersAsset"/></caption>
    <table class="table table-striped1">


        <tr>
            <td><@spring.message "issueName"/></td>
            <td><@spring.message "freeAssets"/></td>
            <td><@spring.message "blockAssets"/></td>

        </tr>
        <#list listAssets as assets>
            <tr>
                <td>${assets.issueId.name}</td>
                <td>${assets.free}</td>
                <td>${assets.blocked}</td>
            </tr>

        </#list>


    </table>


    <form class="table table-striped1" name="addIssue" action="/asset/${user.loginName}" method="get">
        <input type="hidden" name="userId" value=${user.id}>

        <#if listIssue??>
            <select name="select1">
                <#list listIssue as issues1>
                    <option value=${issues1.id}>${issues1.name}</option>

                </#list>
            </select>
        </#if>
        <#--<input type="submit" title=<@spring.message "changeAssets"/> value=<@spring.message "changeAssets"/>>-->

    </form>


<#else >
    <br>
    <br>
    <br>
    <br>
    <br>
    <h3><@spring.message "noAssets"/></h3>
</#if>

</div>
<a type="button" href="/users" class="button"><@spring.message "Back"/></a>
</body>
</html>