<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "../header.ftl">

<form action="/editUser" method="post" name="user" class="form-group">
    <input title="Id" type="number" name="id" value="${user.id}"/>
    <input title="fio" type="text" name="fio" value="${user.fio}"/>
    <input title="email" type="text" name="email" value="${user.email}"/>
    <input title="loginName" type="text" name="loginName" value="${user.loginName}"/>
    <input title="password" type="text" name="password" value="${user.password}"/>
    <input title="phoneNumber" type="text" name="phoneNumber" value="${user.phoneNumber}"/>
    <input type="submit" title="OK" value="Edit!"/>
</form>
<a type="button" href="/users" class="button">Back</a>
</body>
</html>

