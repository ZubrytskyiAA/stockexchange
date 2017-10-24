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


<@security.authorize access="hasRole('ROLE_TRADER')">

<table class="" style="display: inline-table; margin-left: 100px;  width:400px" border="1">
    <thead>
    <tr>
        <th colspan="4" style="text-align: center"><@spring.message "yourAsset"/></th>
    </tr>
    </thead>
    <tbody valign="top" style="text-align: center">
    <tr>
        <td width="25%"><@spring.message "tiker"/></td>
        <td width="25%"><@spring.message "freeAssets"/></td>
        <td width="25%"><@spring.message "blockAssets"/></td>
        <td width="25%"><@spring.message "Total"/></td>
    </tr>
    <tr>
        <td colspan="4">

            <table class="table-striped" style="width:100%">
                <tbody>

                    <#if assetListOnlyMoney??>
                        <#list assetListOnlyMoney as assetOnlyMoney>
                        <tr>
                            <td width="25%">${assetOnlyMoney.issueId.name}</td>
                            <td width="25%">${assetOnlyMoney.free}</td>
                            <td width="25%">${assetOnlyMoney.blocked}</td>
                            <td width="25%">${assetOnlyMoney.blocked + assetOnlyMoney.free }</td>
                        </tr>
                        </#list>
                    <#else>
                    <tr>
                        <td width="25%">UAH</td>
                        <td width="25%">0.00</td>
                        <td width="25%">0.00</td>
                        <td width="25%">0.00</td>
                    </tr>

                    </#if>

                    <#if assetListOnlyIssue??>
                        <#list assetListOnlyIssue as assetOnlyIssue>
                        <tr>
                            <td width="25%">${assetOnlyIssue.issueId.name}</td>
                            <td width="25%">${assetOnlyIssue.free}</td>
                            <td width="25%">${assetOnlyIssue.blocked}</td>
                            <td width="25%">${assetOnlyIssue.blocked + assetOnlyIssue.free }</td>
                        </tr>
                        </#list>
                    </#if>
                </tbody>
            </table>
        </td>
    </tr>

    </tbody>
</table>
</@security.authorize>






<#if selectedIssueName??>


<table border="1" width="400" style="float: left;">
    <thead>
    <tr>
        <th colspan="4" style="text-align:right">
            <form name="choseIssue" method="post">
                <select style="align-content: center" name="select1"
                        onchange="document.location=this.options[this.selectedIndex].value">
                    <option selected value=/qouteRetrieval/${selectedIssueName}>${selectedIssueName}</option>
                    <#list listIssue?sort as issueName>
                        <#if "${selectedIssueName}"  != "${issueName}" && "${issueName}" != "UAH">
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
<h1><@spring.message "noIssue"/></h1>
</#if>
</body>
</html>