<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QuoteRetrieval</title>


</head>
<body class="container">
<#include "*/header.ftl">

<caption>QuoteRetrieval sheet</caption>
<table border="1" width="300" style="row-span: 1" class="">
    <tr>
        <form name="choseIssue" method="post">
            <select name="select1" onchange="document.location=this.options[this.selectedIndex].value">

            <#if "${selectedIssueName}"  == "">
                <option selected value=/qouteRetrieval/1></option>
            <#else >
                <option selected value=/qouteRetrieval/${selectedIssueId}>${selectedIssueName}</option>
            </#if>

            <#list listIssue as issues>
                <#if "${selectedIssueName}"  != "${issues.name}">
                    <option value=/qouteRetrieval/${issues.id}>${issues.name}</option>
                </#if>

            </#list>
            </select>

        </form>
    </tr>

    <tr>
        <th colspan="4">Покупка</th>
        <th colspan="4">Продажа</th>

    </tr>

    <tr>
        <td>

            <table>
                <tr>
                    <th>цена</th>
                    <th>объем</th>
                </tr>


            <#list quotes as quote>
                <#if "${quote.type}" == "P">
                    <tr>
                        <td>${quote.price}</td>
                        <td>${quote.qty}</td>
                    </tr>
                </#if>
            </#list>


            </table>

        </td>


        <td>
            <table>
                <tr>
                    <th>цена</th>
                    <th>объем</th>
                </tr>
            <#list quotes as quote>
                <#if "${quote.type}" == "S">
                    <tr>
                        <td>${quote.price}</td>
                        <td>${quote.qty}</td>
                    </tr>
                </#if>
            </#list>


            </table>
        </td>
    </tr>

</table>


</body>
</html>