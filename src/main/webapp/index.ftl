<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Stock Exchange</title>

</head>
<body class="container">
<#include "WEB-INF/views/header.ftl" >

<@security.authorize access="isAuthenticated()">
<p style="text-align: center">
<h1>Hello, you are logged as <@security.authentication property="principal.username"/>.</h1>
</p>
</@security.authorize>


</body class="container">
</html>