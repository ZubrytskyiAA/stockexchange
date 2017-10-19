<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QuoteRetrieval</title>


    <style>
        table {
            width: 300px;
        }

        .container1 {
            overflow-y: scroll;
            height: 300px;
        }

        td {
            text-align: center;
        }


    </style>


</head>
<body class="container">
<#include "*/header.ftl">


<br>
<br>


<#if "${selectedIssueName}"??>


<table border="1" width="400">
    <thead>
    <tr>
        <th colspan="4" style="text-align:right">
            <form name="choseIssue" method="post">
                <select style="align-content: center" name="select1"
                        onchange="document.location=this.options[this.selectedIndex].value">
                    <option selected value=/qouteRetrieval/${selectedIssueName}>${selectedIssueName}</option>
                    <#list listIssue?sort as issueName>
                        <#if "${selectedIssueName}"  != "${issueName}">
                            <option value=/qouteRetrieval/${issueName}>${issueName}</option>
                        </#if>
                    </#list>
                </select>
            </form>
        </th>
    </tr>
    </thead>

    <tbody align="center">
    <tr>
        <td colspan="2"><@spring.message "Purchase"/></td>
        <td colspan="2"><@spring.message "Sell"/></td>
    </tr>
    <tr>
        <td width="25%"><@spring.message "Price"/></td>
        <td width="25%"><@spring.message "Quantity"/></td>
        <td width="25%"><@spring.message "Price"/></td>
        <td width="25%"><@spring.message "Quantity"/></td>
    </tr>
    <tr>
        <td colspan="2" valign="top"><#include "quoteRetrievalBuyPart.ftl"></td>
        <td colspan="2" valign="top"><#include "quoteRetrievalSellPart.ftl"></td>
    </tr>

        <@security.authorize access="hasRole('ROLE_TRADER')">
        <tr>
            <td colspan="4"> <#include "tradeForm1.ftl"></td>
        </tr>
        </@security.authorize>


    </tbody>
</table>


<#else>
<h1>Нету не одной активной бумаги в торгах</h1>
</#if>
</body>
</html>