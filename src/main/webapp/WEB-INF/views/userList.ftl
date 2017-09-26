<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "templates/header.ftl">
<div class="table-responsive" style="background-color: antiquewhite">
    <caption>Users list</caption>
    <table class="table table-striped">
        <tr>

            <th>login</th>
            <th>password</th>
            <th>fio</th>
            <th>email</th>
            <th>Phonenumber</th>
            <th>Actions</th>

        </tr>

        <tr>

            <form action="/newUser" method="post" name="user" class="form-group">

                <td><input title="loginname" type="text" name="loginName"/></td>

                <td><input title="password" type="password" name="password"/></td>

                <td><input title="fio" type="text" name="fio"/></td>

                <td><input title="email" type="text" name="email"/></td>

                <td><input title="phonenumber" type="text" name="phoneNumber"/></td>

                <td><input type="submit" title="OK" value="Добавить"/></td>
            </form>

        </tr>
    <#list users as user>
        <tr>
        <#--<td><a href="/user/${user.id}">${user.id}</a></td>-->
            <td><a href="/user/${user.id}">${user.loginName}</a></td>
            <td>${user.password}</td>
            <td>${user.fio}</td>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
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
<#--<#include "templates/createUserForm.ftl"/>-->
</body>
</html>