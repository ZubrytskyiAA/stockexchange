<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive" style="background-color: antiquewhite">
    <caption>Trades list</caption>
    <table class="table table-striped">
        <tr>
            <th>Название клиента</th>
            <th>Название инструмента</th>
            <th>Доступные средства</th>
            <th>Заблокированные средства</th>

        </tr>


    <#list assets as asset>
        <tr>

            <td>${asset.userId.loginName}</td>
            <td>${asset.issueId.name}</td>

            <td>${asset.free}</td>
            <td>${asset.blocked}</td>


        </tr>
    </#list>
    </table>
</div>

</body>
</html>