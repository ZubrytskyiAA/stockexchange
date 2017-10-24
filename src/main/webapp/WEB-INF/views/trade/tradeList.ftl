<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive">
    <caption><@spring.message "tradesList"/></caption>

<#if trades??>
    <table class="table table-striped" style="text-align: center">
        <tr>

            <@security.authorize access="hasRole('ROLE_ADMIN')">
                <th style="text-align:center"><@spring.message "dealNumber"/></th>
            </@security.authorize>
            <th style="text-align:center"><@spring.message "issueName"/></th>
            <th style="text-align:center"><@spring.message "buyer"/></th>
            <th style="text-align:center"><@spring.message "seller"/></th>
            <th style="text-align:center"><@spring.message "Price"/></th>
            <th style="text-align:center"><@spring.message "Quantity"/></th>
            <th style="text-align:center"><@spring.message "Volume"/></th>
            <th style="text-align:center"><@spring.message "DealType"/></th>
            <th style="text-align:center"><@spring.message "State"/></th>
            <th style="text-align:center"><@spring.message "tradeMoment"/></th>

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
                    ${trade.userInit.loginName}
                        <#break>
                        <#case "S">
                        ${trade.userConf.loginName}
                            <#break>
                    </#switch>
                </td>
                <td>
                    <#switch "${trade.confAction}" >
                    <#case "P">
                    ${trade.userInit.loginName}
                        <#break>
                        <#case "S">
                        ${trade.userConf.loginName}
                            <#break>
                    </#switch>
                </td>
                <td>${trade.price}</td>
                <td>${trade.qty}</td>
                <td>${trade.volume}</td>

                <td>
                    <#switch  "${trade.type}" >
                        <#case "A">
                        <@spring.message "auctionsDeal"/>
                        <#break>
                        <#case "B">
                            <@spring.message "Negotiated"/>
                            <#break>
                        <#default>
                            <@spring.message "unidentifiedType"/>
                    </#switch>
                </td>


                <td>
                    <#switch  "${trade.status}" >
                        <#case "1">
                        <@spring.message "waitingConf"/>
                        <#break>
                        <#case "10">
                            <@spring.message "Executed"/>
                            <#break>
                        <#default>
                            <@spring.message "unidentifiedType"/>
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

</#if>
<#--<#include "templates/createUserForm.ftl"/>-->
</body>
</html>