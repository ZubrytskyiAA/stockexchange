<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IssueData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive">
    <caption>Issue info</caption>
    <table class="table table-striped">
        <tr>
            <td>Идентификатор</td>
            <td>#${issue.id}</a></td>
        </tr>
        <tr>
            <td>Имя</td>
            <td>${issue.name}</td>
        </tr>
        <tr>
            <td>Полное имя</td>
            <td>${issue.fullName}</td>
        </tr>
        <tr>
            <td>Активность</td>
            <td>${issue.active?then("Активна","Деактивированный")}</td>
        </tr>
        <tr>
            <td>Дата создания</td>
            <td>${issue.createMoment}</td>
        </tr>
   
    </table>
</div>


</body>
</html>