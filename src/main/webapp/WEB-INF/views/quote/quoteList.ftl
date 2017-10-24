<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quotes</title>

</head>
<body class="container">
<#include "*/header.ftl">
<#if listSize??>

<div class="table-responsive">
    <p style="text-align: center ;"><@spring.message "Total"/>: ${listSize} <@spring.message "header.quote"/>.</p>

    <table class="table table-striped" style="text-align: center">
        <tr>
            <@security.authorize access="hasRole('ROLE_ADMIN')">
                <th style="text-align: center"><@spring.message "quote.number"/></th>
                <th style="text-align: center"><@spring.message "quote.client"/></th>
            </@security.authorize>
            <th style="text-align: center"><@spring.message "quote.issueName"/></th>
            <th style="text-align: center"><@spring.message "createMoment"/></th>
            <th style="text-align: center"><@spring.message "Price"/></th>
            <th style="text-align: center"><@spring.message "Quantity"/></th>
            <th style="text-align: center"><@spring.message "Volume"/></th>
            <th style="text-align: center"><@spring.message "actions"/></th>
        </tr>

        <#list quotes?sort_by("id") as quote>
            <tr>
                <@security.authorize access="hasRole('ROLE_ADMIN')">
                    <td>${quote.id}</td>
                    <td><a href="/users/${quote.userId.id}">${quote.userId.loginName}</a></td>
                </@security.authorize>
                <td><a href="/issue/${quote.issueId.name}">${quote.issueId.name}</a></td>
                <td>${quote.createMoment}</td>
                <td>${quote.price}</td>
                <td>${quote.qty}</td>
                <td>${quote.qty * quote.price}</td>
                <td>
                    <a href="/quote/edit/${quote.id?c}"><@spring.message "Edit"/></a>
                    <br>
                    <a href="/quote/delete/${quote.id?c}"><@spring.message "Delete"/></a>
                </td>
            </tr>
        </#list>
    </table>
</div>


<div style="text-align: center">
    <ul class="pagination">
        <#list listLinks as listLink>
            <#if "${listLink}" != "${currentPage}">
                <li><a href="/quote/${listLink}">${listLink + 1}</a></li>
            <#else>
                <li class="active"><a href="/quote/${listLink}">${listLink + 1}</a>
                </li>

            </#if>
        </#list>
    </ul>
</div>
<#else >
<h1>You havan't any Quotes</h1>

</#if>
</body>
</html>