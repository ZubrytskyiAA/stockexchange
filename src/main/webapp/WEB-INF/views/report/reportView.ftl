<!DOCTYPE html>
<html lang="en">
<head>
    <title>Reports</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<#--<link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>-->

</head>
<body class="container">
<#include "*/header.ftl">
<br><br><br>

<#if "${selectedIssueName}"??>
<select name="active" onchange="document.location=this.options[this.selectedIndex].value">
    <#if "${selectedIssueName}" = "" >
        <option selected disabled hidden value=></option>
    <#else >
        <option selected value="/report/${selectedIssueName}">${selectedIssueName}</option>
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
                                text: "Обзор изменения цен за весь период "
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
                                collectionAlias: "${selectedIssueName}",
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





<#--<div id="users"></div>-->
<#--<button onclick="update()">Refresh<button>-->
<#--<#include "/WEB-INF/dod/ss.ftl">-->

</body>
</html>
