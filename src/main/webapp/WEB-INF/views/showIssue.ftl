<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IssueData</title>
</head>
<body class="container">
<#include "templates/header.ftl">
<div class="table-responsive">
    <caption>Issue info</caption>
    <table class="table table-striped">
        <tr>
            <td>Id</td>
            <td>${issue.id}</a></td>
        </tr>
        <tr>
            <td>full_name</td>
            <td>${issue.fullName}</td>
        </tr>
        <tr>
            <td>name</td>
            <td>${issue.name}</td>
   
    </table>
</div>

<div class="table-responsive">
    <caption>Issue goods</caption>
    <table class="table table-striped">
        <tr>
            <td>Id</td>
            <td>Name</a></td>
            <td>Price</a></td>
        </tr>
    <#--<#list user.goodsList as goods>-->
        <#--<tr>-->
            <#--<td>${goods.id}</td>-->
            <#--<td>${goods.name}</td>-->
            <#--<td>${goods.price}</td>-->
        <#--</tr>-->
    <#--<#else>-->
        <#--<h1>Empty goods</h1>-->
    <#--</#list>-->

    </table>
</div>
<a type="button" href="/issues" class="button">Back</a>
</body>
</html>