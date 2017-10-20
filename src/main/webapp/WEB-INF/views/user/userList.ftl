<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive">

    <a href="/users/create" title="<@spring.message "users.addNewUser"/>"> <img src="/resources/images/addUser.png" alt="<@spring.message "users.addNewUser"/>" height="30" width="30" align="right"></a>


    <table class="table table-striped">
        <tr style="text-align: center">

            <th>Login</th>
            <th>Password</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Activities</th>
            <th>Actions</th>

        </tr>

        <#--<tr>-->

            <#--<form action="/users/newUser" method="post" name="user" class="form-group">-->

                <#--<td><input class="controls-pane col-sm-8" title="loginname" type="text" name="loginName" required/></td>-->

                <#--<td><input class="controls-pane col-sm-8" title="password" type="password" name="password" required/>-->
                <#--</td>-->

                <#--<td><input class="controls-pane col-sm-8" title="First Name" type="text" name="firstName" required/></td>-->

                <#--<td><input class="controls-pane col-sm-8" title="Last Name" type="text" name="lastName"/></td>-->

                <#--<td><input class="controls-pane col-sm-8" title="phonenumber" type="text" name="phoneNumber"/></td>-->
                <#--<td></td>-->
                <#--<td><input type="submit" title="OK" value="Добавить"/></td>-->
            <#--</form>-->

        <#--</tr>-->
    <#list users as user>
        <tr>
        <#--<td><a href="/user/${user.id}">${user.id}</a></td>-->
            <td><a href="/users/${user.id}">${user.loginName}</a></td>
            <td>${user.password}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.active?then("Активна","Деактивированный")}</td>
            <td>
                <#include "changeActivitiesUserForm.ftl">
                <#--<form action="/users/deleteUserById" method="post" name="user" class="form-group">-->
                    <#--<input title="id" type="hidden" name="id" value="${user.id}"/>-->
                    <#--<input type="submit" title="OK" value="Delete"/>-->
                <#--</form>-->
            </td>
        </tr>
    </#list>
    </table>
</div>
<#--<#include "templates/createUserForm.ftl"/>-->
</body>
</html>