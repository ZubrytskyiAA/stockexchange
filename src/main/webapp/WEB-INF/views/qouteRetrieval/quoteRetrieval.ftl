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

<caption>QuoteRetrieval sheet</caption>
<br>
<br>

<#--<#if "${errorMsg}"??>-->
<#--<h1>${errorMsg}</h1>-->
<#if "${selectedIssueName}"??>

<div>
    <div>
        <div></div>
        <div class="col-sm-7 pull-right">
            <form name="choseIssue" method="post">
                <select  name="select1" onchange="document.location=this.options[this.selectedIndex].value">

                <#--<#if "${selectedIssueName}"??>-->
                <#--<option selected value=/qouteRetrieval/1></option>-->
                <#--<#else >-->
                    <option selected value=/qouteRetrieval/${selectedIssueName}>${selectedIssueName}</option>
                <#--</#if>-->

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
        <div>Покупка</div>
        <div>Продажа</div>

    </div>
    <div>
        <#include "quoteRetrievalBuyPart.ftl">
        <#include "quoteRetrievalSellPart.ftl">
    </div>
</div>

    <#include "tradeForm1.ftl">
<#else>
<h1>Нету не одной активной бумаги в торгах</h1>
</#if>
</body>
</html>