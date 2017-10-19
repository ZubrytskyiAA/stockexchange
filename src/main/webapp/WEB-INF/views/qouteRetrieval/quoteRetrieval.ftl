<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QuoteRetrieval</title>
    <style type="text/css">
        body > div {
            display: table;
            border: solid 1px black;
            width: 300pt;
        }

        body > div div {
            display: table-row;

        }

        body > div div div {
            display: table-cell;

        }

        select {
            width: 70px;
        }


    </style>

</head>
<body class="container">
<#include "*/header.ftl">


<br>
<br>


<#if "${selectedIssueName}"??>

<div>
    <div>
        <div></div>
        <div class="col-sm-7 pull-right">
            <form name="choseIssue" method="post">
                <select name="select1" onchange="document.location=this.options[this.selectedIndex].value">
                    <option selected value=/qouteRetrieval/${selectedIssueName}>${selectedIssueName}</option>
                    <#list listIssue?sort as issueName>
                        <#if "${selectedIssueName}"  != "${issueName}">
                            <option value=/qouteRetrieval/${issueName}>${issueName}</option>
                        </#if>
                    </#list>
                </select>
            </form>
        </div>

    </div>
    <div style="text-align: center;">
        <div><@spring.message "Purchase"/></div>
        <div><@spring.message "Sell"/></div>

    </div>
    <div>
        <#include "quoteRetrievalBuyPart.ftl">
        <#include "quoteRetrievalSellPart.ftl">
    </div>
</div>
    <@security.authorize access="hasRole('ROLE_TRADER')">
        <#include "tradeForm1.ftl">
    </@security.authorize>
<#else>
<h1>Нету не одной активной бумаги в торгах</h1>
</#if>
</body>
</html>