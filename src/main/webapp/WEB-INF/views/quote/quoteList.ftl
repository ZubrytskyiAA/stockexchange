<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QuoteData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive" style="background-color: antiquewhite">
    <caption>Quotes list</caption>
    <table class="table table-striped">
        <tr>
            <th>Номер заявки</th>
            <th>Клиент</th>
            <th>Название актива</th>
            <th>Дата создания</th>
            <th>Цена</th>
            <th>Количество</th>
            <th>Сумма</th>
            <th>Действия</th>

        </tr>


    <#list quotes?sort_by("id") as quote>
        <tr>
            <td>${quote.id}</td>
            <td>${quote.userId.loginName}</td>
            <td>${quote.issueId.name}</td>

            <td>${quote.createMoment}</td>
            <td>${quote.price}</td>
            <td>${quote.qty}</td>
            <td>${quote.qty * quote.price}</td>
            <td>
                <a href="/quote/edit/${quote.id}">Edit</a>
                <br>
                <a href="/quote/delete/${quote.id}">Delete</a>
            </td>
        </tr>
    </#list>
    </table>
</div>

</body>
</html>