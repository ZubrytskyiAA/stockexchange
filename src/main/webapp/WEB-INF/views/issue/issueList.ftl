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

            <form action="/issue/newIssue" method="post" name="issue" class="form-group">

                <td><input title="name" type="text" name="name"/></td>

                <td><input title="full_name" type="text" name="fullName"/></td>
                <td>
                    <select name="active">
                        <option value=1>Активный</option>
                        <option value=0>Деактивированый</option>
                    </select>

                </td>
                <td></td>

            <#--<td><input title="fio" type="text" name="fio"/></td>-->

            <#--<td><input title="email" type="text" name="email"/></td>-->

            <#--<td><input title="phonenumber" type="text" name="phoneNumber"/></td>-->

                <td><input type="submit" title="OK" value="Добавить"/></td>
            </form>

        </tr>
    <#list issues as issue>
        <tr>
        <#--<td><a href="/user/${user.id}">${user.id}</a></td>-->
            <td><a href="/issue/${issue.id}">${issue.name}</a></td>
            <td>${issue.fullName}</td>
            <td>${issue.active?then("Активна","Деактивированный")}</td>
            <td>${issue.createMoment}</td>


            <td>
                <form action="/issue/deleteIssueById" method="post" name="issue" class="form-group">
                    <input title="id" type="hidden" name="id" value="${issue.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
                <form action="/issue/setActivities" method="post" name="setActive" class="form-group">
                    <input title="id" type="hidden" name="id" value="${issue.id}">
                    <input title="active" type="hidden" name="active" value=${issue.active?then("0","1")}>
                    <input type="submit" value=${issue.active?then("Деактивировать","Активировать")}>
                </form>
            </td>
        </tr>
    </#list>
    </table>
</div>
<#include "createIssueForm.ftl"/>
</body>
</html>