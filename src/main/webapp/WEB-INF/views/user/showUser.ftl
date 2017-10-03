<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive">
    <caption align="center">User info</caption>
    <table class="table table-striped">
        <tr>
            <td>Id</td>
            <td>${user.id}</a></td>
        </tr>
        <tr>
            <td>loginName</td>
            <td>${user.loginName}</td>
        </tr>
        <tr>
            <td>password</td>
            <td>${user.password}</td>
        </tr>
        <tr>
            <td>fio</td>
            <td>${user.fio}</td>
        </tr>
        <td>phoneNumber</td>
        <td>${user.phoneNumber}</td>
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
    <caption>User's assets</caption>
    <table class="table table-striped1">


        <tr>
            <td>Название Актива</td>
            <td>Свободно средств</a></td>
            <td>Заблокировано средств</a></td>

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
        <input type="submit" title="add" value="Change assets"/>

    </form>


<#else >
    <br>
    <br>
    <br>
    <br>
    <br>
    <h3>There isn't any assets</h3>
</#if>

</div>
<a type="button" href="/users" class="button">Back</a>
</body>
</html>