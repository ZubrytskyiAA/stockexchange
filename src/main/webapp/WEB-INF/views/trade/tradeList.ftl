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
            <th>Номер сделки</th>
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

            <td>#${trade.id}</td>
            <td><a href="/trade/user/${trade.id}">
                <#switch  "${trade.initAction}" >
                     <#case "P">
                ${trade.userInit.loginName}
                    <#break>
                    <#default>
                    ${trade.userConf.loginName}


                </#switch>
            </a></td>
            <td><a href="/trade/user/${trade.id}">
                <#switch "${trade.confAction}" >
                    <#case "S">
                ${trade.userConf.loginName}
                    <#break>
                    <#default>
                    ${trade.userInit.loginName}
                </#switch>
            </a></td>
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
<#--<#include "templates/createUserForm.ftl"/>-->
</body>
</html>