
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IssueData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive" style="background-color: antiquewhite">
    <caption>Issues list</caption>
    <table class="table table-striped">
        <tr>
            <th>Тикер</th>
            <th>Полное название</th>
            <th>Состояние</th>
            <th>Дата создания</th>
            <th>Действия</th>
        </tr>
        <tr>
        <#include "createIssueForm.ftl">
        </tr>
    <#list issues as issue>
        <tr>
            <td><a href="/issue/${issue.name}">${issue.name}</a></td>
            <td>${issue.fullName}</td>
            <td>${issue.active?then("Активна","Деактивированный")}</td>
            <td>${issue.createMoment}</td>
            <td><#include "changeActivitiesForm.ftl"></td>
        </tr>
    </#list>
    </table>
</div>
</body>
</html>