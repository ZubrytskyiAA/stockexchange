<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IssueData</title>
</head>
<body class="container">
<#include "*/header.ftl">


<script>
    $(document).ready(function () {
        $("#myInput").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>


<#if message??>

<script>
    alert("${message}");
</script>
</#if>


<div class="table-responsive">

<@security.authorize access="hasRole('ROLE_ADMIN')">
    <a href="/issue/create" title="<@spring.message "users.addNewUser"/>">
        <img src="/resources/images/addIssue.png" alt="<@spring.message "users.addNewUser"/>" height="30" width="30"
             align="right" style="margin-right:5%">
    </a>

</@security.authorize>




    <div class="form-group">
        <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
        <div class="col-sm-1 col-md-3 col-lg-2 col-xs-10 mobileLabel"
             style=" padding-top: 7px; ">
            Quickly search:
        </div>

        <div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad"
             style="font-weight:400;">

            <input class="form-control" id="myInput" type="text" placeholder="Search..">

        </div>
        <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
    </div>


    <div class="table-responsive">

        <table class="table table-striped">
            <tr>
                <th>Тикер</th>
                <th>Полное название</th>
                <th>Состояние</th>
                <th>Дата создания</th>
                <th>Действия</th>
            </tr>
            <tr>

            </tr>

            <tbody id="myTable">
            <#list issues as issue>
            <tr>
                <td><a href="/issue/${issue.name}">${issue.name}</a></td>
                <td>${issue.fullName}</td>
                <td>${issue.active?then("Активна","Деактивированный")}</td>
                <td>${issue.createMoment}</td>
                <td><#include "changeActivitiesForm.ftl"></td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</body>
</html>