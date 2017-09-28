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

            <form action="/newIssue" method="post" name="issue" class="form-group">

                <td><input title="name" type="text" name="name"/></td>

                <td><input title="full_name" type="text" name="fullName"/></td>
                <td></td>
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
            <td>${issue.active?then("Активна","Деактивирована")}</td>
            <td>${issue.createMoment}</td>


            <td>
                <form action="/deleteIssueById" method="post" name="issue" class="form-group">
                    <input title="id" type="hidden" name="id" value="${issue.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
                <form action="/setActivities" method="post" name="activities" class="form-group">
                    <input title="id" type="hidden" name="id" value=${issue.active?then("false","true")}/>
                    <input type="submit" value=${issue.active?then("SET_OFF","SET_ON")}>
                </form>
            </td>
        </tr>
    </#list>
    </table>
</div>
<#include "createIssueForm.ftl"/>
</body>
</html>