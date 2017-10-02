<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<#--<link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>-->
    <link type="text/css" rel="StyleSheet" href="http://bootstraptema.ru/plugins/2016/shieldui/style.css"/>
    <script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
    <script src="http://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>
</head>
<body class="container">


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Trade Site</a>
        </div>
        <ul class="nav nav-tabs nav-justified">
            <li><a href="/qouteRetrieval">Qoute Retrieval</a></li>
            <li><a href="/users">Users</a></li>
            <li><a href="/quote">Quotes</a></li>
            <li><a href="/issue">Issues</a></li>
            <li><a href="/report">Reports</a></li>
            <li><a href="/asset">Assets</a></li>
            <li><a href="/trade/alltrades">Trades</a></li>
            <li><a href="/login">Login</a></li>

        </ul>
    </div>
</nav>


<#--<#include "*/header.ftl">-->
<br><br><br>
<!-- Single button -->

<#if "${selectedIssueName}"??>
<select name="active" onchange="document.location=this.options[this.selectedIndex].value">
    <#if "${selectedIssueName}" = "" >
        <option selected disabled hidden value=></option>
    <#else >
        <option selected  value="/report/${selectedIssueName}">${selectedIssueName}</option>
    </#if>
    <#list uniqNames as h>

        <option value="/report/${h}">${h}</option>

    </#list>
</select>

<#else >
<h1>еще небыло не одной сделки!!!!</h1>
</#if>
<#--<select name="active">-->
<#--<option value="1">Активный</option>-->
<#--<option value="0">Деактивированый</option>-->
<#--</select>-->

<#if "${selectedIssueName}" != "">
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <!-- График -->
            <div id="chart">

                <script>
                    $(document).ready(function () {
                        $("#chart").shieldChart({
                            theme: "light",
                            primaryHeader: {
                                text: "Обзор Сделок по Бумаге"
                            },
                            exportOptions: {
                                image: false,
                                print: false
                            },
                            axisX: {
                                categoricalValues: []
                            },
                            tooltipSettings: {
                                chartBound: true,
                                axisMarkers: {
                                    enabled: true,
                                    mode: 'xy'
                                }
                            },
                            dataSeries: [{
                                seriesType: 'line',
                                collectionAlias: "Цена в грн",
                                data: [
                                    <#list trades as trade>
                                    ${trade.price?c}<#sep>,
                                    </#list>

//                                    1, 320.86, 453, 234, 553, 665, 345, 123, 432, 545, 654, 345, 332, 456, 2340
                                ]
                            }]
                        });
                    });
                </script><!-- /.График -->

            </div><!-- /.col-md-8 col-md-offset-2 -->
        </div><!-- /.row -->
    </div><!-- /.container -->

</#if>
</body>
</html>
