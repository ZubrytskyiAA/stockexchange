<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IssueData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive">
    <caption><@spring.message "issueInfo"/></caption>
    <table class="table table-striped">
        <tr>
            <td><@spring.message "quote.number"/></td>
            <td>#${issue.id}</a></td>
        </tr>
        <tr>
            <td><@spring.message "issueName"/></td>
            <td>${issue.name}</td>
        </tr>
        <tr>
            <td><@spring.message "fullName"/></td>
            <td>${issue.fullName}</td>
        </tr>
        <tr>
            <td><@spring.message "activities"/></td>
            <td>${issue.active?then("On","Off")}</td>
        </tr>
        <tr>
            <td><@spring.message "createMoment"/></td>
            <td>${issue.createMoment}</td>
        </tr>
   
    </table>
</div>


</body>
</html>