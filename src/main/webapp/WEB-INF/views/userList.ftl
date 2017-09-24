<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "templates/header.ftl">
<div class="table-responsive" style="background-color: aqua">
    <caption>Users list</caption>
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>login</th>
            <th>password</th>
            <th>fio</th>
            <th>Actions</th>
        </tr>
    <#list users as user>
        <tr>
            <td><a href="/user/${user.id}">${user.id}</a></td>
            <td>${user.loginName}</td>
            <td>${user.password}</td>
            <td>${user.fio}</td>
            <td>
                <form action="/deleteUserById" method="post" name="user" class="form-group">
                    <input title="id" type="hidden" name="id" value="${user.id}"/>
                    <input type="submit" title="OK" value="Delete"/>
                </form>
            </td>
        </tr>
    </#list>
    </table>
</div>
<#include "templates/createUserForm.ftl"/>
</body>
</html>