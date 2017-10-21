<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
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


<div class="table-responsive">

    <a href="/users/create" title="<@spring.message "users.addNewUser"/>">
        <img src="/resources/images/addUser.png" alt="<@spring.message "users.addNewUser"/>" height="30" width="30"
             align="right" style="margin-right:5%">
    </a>


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


    <table class="table table-striped" style="text-align: center" width="400px  ">
        <tr>
            <td><a href="/users?order=loginName&prevOrder=${prevOrder}&prevOrderType=${prevOrderType}">Login</a></td>
            <td><a href="/users?order=firstName&prevOrder=${prevOrder}&prevOrderType=${prevOrderType}">First Name</a>
            </td>
            <td><a href="/users?order=lastName&prevOrder=${prevOrder}&prevOrderType=${prevOrderType}">Last Name</a></td>
            <td><a href="/users?order=email&prevOrder=${prevOrder}&prevOrderType=${prevOrderType}">Email</a></td>
            <td><a href="/users?order=active&prevOrder=${prevOrder}&prevOrderType=${prevOrderType}">Activities</a></td>
            <td>Actions</td>
        </tr>

        <tbody id="myTable">
        <#list users as user>
        <tr>

            <td><a href="/users/${user.id}">${user.loginName}</a></td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.active?then("Активна","Деактивированный")}</td>
            <td>
                <#include "changeActivitiesUserForm.ftl">

            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
<#--<#include "templates/createUserForm.ftl"/>-->
</body>
</html>