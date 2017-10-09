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
    <table class="table table-striped" style="text-align: center">
        <tr>

        <@security.authorize access="hasRole('ROLE_ADMIN')">
            <th>Номер сделки</th>
        </@security.authorize>
            <th>Название бумаги</th>
            <th>Покупатель</th>
            <th>Продавец</th>
            <th>Цена</th>
            <th>Количество</th>
            <th>Объем</th>
            <th>Тип</th>
            <th>Состояние</th>
            <th>Дата заключения</th>

        </tr>


    <#list trades as trade>
        <tr>
            <@security.authorize access="hasRole('ROLE_ADMIN')">
                <td>#${trade.id?c}</td>
            </@security.authorize>
            <td><a href="/issue/${trade.issue.name}">${trade.issue.name}</a></td>
            <td>
                <#switch  "${trade.initAction}" >
                    <#case "P">
                        <a href="/users/${trade.userInit.id?c}">${trade.userInit.loginName}</a>
                        <#break>
                    <#case "S">
                        <a href="/users/${trade.userConf.id?c}">${trade.userConf.loginName}</a>
                        <#break>
                </#switch>
            </td>
            <td>
                <#switch "${trade.confAction}" >
                    <#case "P">
                        <a href="/users/${trade.userInit.id?c}">${trade.userInit.loginName}</a>
                        <#break>
                    <#case "S">
                        <a href="/users/${trade.userConf.id?c}">${trade.userConf.loginName}</a>
                        <#break>
                </#switch>
            </td>
            <td>${trade.price}</td>
            <td>${trade.qty}</td>
            <td>${trade.volume}</td>

            <td>
                <#switch  "${trade.type}" >
                    <#case "A">
                        Аукционнная
                        <#break>
                    <#case "B">
                        Договорная
                        <#break>
                    <#default>
                        Неопознанный Тип
                </#switch>
            </td>


            <td>
                <#switch  "${trade.status}" >
                    <#case "1">
                        Ждет подтверждения
                        <#break>
                    <#case "10">
                        Исполнена
                        <#break>
                    <#default>
                        Неопознанный статус
                </#switch>
            </td>
            <td>${trade.tradeMoment}</td>

        </tr>
    </#list>
    </table>
</div>

<div style="text-align: center">
    <ul class="pagination">
    <#list listLinks as listLink>
        <#if "${listLink}" != "${currentPage}">
            <li><a href="/trade/${listLink}">${listLink + 1}</a></li>
        <#else>
            <li class="active"><a href="/trade/${listLink}">${listLink + 1}</a>
            </li>

        </#if>
    </#list>
    </ul>
</div>


<#--<#include "templates/createUserForm.ftl"/>-->
</body>
</html>