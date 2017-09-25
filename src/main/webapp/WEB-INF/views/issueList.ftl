<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IssueData</title>
</head>
<body class="container">
<#include "templates/header.ftl">
<div class="table-responsive" style="background-color: antiquewhite">
    <caption>Issues list</caption>
    <table class="table table-striped">
        <tr>

            <th>name</th>
            <th>full_name</th>
            <#--<th>fio</th>-->
            <#--<th>email</th>-->
            <#--<th>Phonenumber</th>-->
            <#--<th>Actions</th>-->

        </tr>

        <tr>

            <form action="/newIssue" method="post" name="issue" class="form-group">

                <td><input title="name" type="text" name="name"/></td>

                <td><input title="full_name" type="text" name="fullName"/></td>

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
            <#--<td>${user.fio}</td>-->
            <#--<td>${user.email}</td>-->
            <#--<td>${user.phoneNumber}</td>-->
            <td>
                <form action="/deleteIssueById" method="post" name="issue" class="form-group">
                    <input title="id" type="hidden" name="id" value="${issue.id}"/>
                    <input type="submit"  value="Delete"/>
                </form>
            </td>
        </tr>
    </#list>
    </table>
</div>
<#include "templates/createIssueForm.ftl"/>
</body>
</html>