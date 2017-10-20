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
    <@spring.message "WelcomeMsg"/><@security.authentication property="principal.username"/>.
</p>
</@security.authorize>


</body>
</html>