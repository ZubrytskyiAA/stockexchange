<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "templates/header.ftl">
<div class="table-responsive">
    <caption>User info</caption>
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

<div class="table-responsive1">
    <caption>User issues</caption>
    <table class="table table-striped1">
    <#list  user.issueList as ifNotNull>
        <tr>
            <td>Id</td>
            <td>Name</a></td>
            <td>Price</a></td>
        </tr>
        <#list user.issueList as issues>
            <tr>
                <td>${issues.id}</td>
                <td>${issues.name}</td>
                <td>${issues.fullName}</td>
            </tr>

        </#list>
        <#break>
    <#else>
        <h1>Empty goods</h1>
    </#list>
    </table>


    <form class="table table-striped1" name="addIssue" action="/addIssueToUser" method="post">
<input type="hidden" name="userId" value=${user.id}>
        <select name="select1">
        <#list listIssue as issues1>
            <option  value=${issues1.id}>${issues1.name}</option>

        </#list>
        </select>

        <input type="submit" title="add" value="ADD ISSUE"/>

    </form>

</div>
<a type="button" href="/users" class="button">Back</a>
</body>
</html>