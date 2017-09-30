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

<div style="background: chartreuse;">
    <div>
        <div></div>
        <div style="text-align: right">
            Название инструмента
            <form name="choseIssue" method="post">
                <select name="select1" onchange="document.location=this.options[this.selectedIndex].value">

                <#--<#if "${selectedIssueName}"??>-->
                <#--<option selected value=/qouteRetrieval/1></option>-->
                <#--<#else >-->
                    <option selected value=/qouteRetrieval/${selectedIssueName}>${selectedIssueName}</option>
                <#--</#if>-->

                    <#list listIssue as issueName>
                        <#if "${selectedIssueName}"  != "${issueName}">
                            <option value=/qouteRetrieval/${issueName}>${issueName}</option>
                        </#if>

                    </#list>
                </select>
            </form>
        </div>

    </div>
    <div style="text-align: center">
        <div>Покупка</div>
        <div>Продажа</div>

    </div>
    <div style="height: 150pt">
        <div style="text-align: center">

            <table width="100%" border="1">
                <tbody valign="top">
                <tr>
                    <th style="text-align: center">цена</th>
                    <th style="text-align: center">объем</th>
                </tr>
                    <#list quotes as quote>
                        <#if "${quote.type}" == "P">
                        <tr>
                            <td>${quote.price}</td>
                            <td>${quote.qty}</td>
                        </tr>
                        </#if>
                    </#list>

                </tbody>
            </table>


        </div>
        <div style="text-align: center">
            <table width="100%" border="1">
                <tbody valign="top">
                <tr>
                    <th style="text-align: center">цена</th>
                    <th style="text-align: center">объем</th>
                </tr>
                    <#list quotes as quote>
                        <#if "${quote.type}" == "S">
                        <tr>
                            <td>${quote.price}</td>
                            <td>${quote.qty}</td>
                        </tr>
                        </#if>
                    </#list>

                </tbody>
            </table>
        </div>
    </div>
</div>

    <#include "tradeForm1.ftl">
<#else>
<h1>Нету не одной активной бумаги в торгах</h1>
</#if>
</body>
</html>