<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Stock Exchange</title>
</head>
<body class="container" onload="init();">
<#include "WEB-INF/views/header.ftl" >

<@security.authorize access="isAuthenticated()">
<p style="text-align: center">
<h1>Hello, you are logged as <@security.authentication property="principal.username"/>.</h1>
<a href="/?mylocale=en">English </a> | <a href="/?mylocale=ua">Ukraine </a>| <a href="/?mylocale=ru">Russion </a>
</p>
</@security.authorize>


</body>
</html>