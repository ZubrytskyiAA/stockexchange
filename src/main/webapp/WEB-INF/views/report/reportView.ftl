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
    <@spring.message "tiker"/>:
<select name="active" onchange="document.location=this.options[this.selectedIndex].value">
    <#if "${selectedIssueName}" = "" >
        <option selected disabled hidden value=></option>
    <#else >
        <option selected value="/report/${selectedIssueName}">${selectedIssueName}</option>
    </#if>
    <#list uniqNames as h>
        <#if "${selectedIssueName}" != "${h}" >
            <option value="/report/${h}">${h}</option>
        </#if>
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
<!-- График -->
<script>
    $(document).ready(function () {
        $("#chart").shieldChart({
            theme: "light",
            primaryHeader: {
                text: <@spring.message "report.changingPrice"/>
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
                    </#list>]
            }]
        });
    });
</script>
<!-- /.График -->


<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">


            <div id="chart">
                <!-- График -->
            </div>
        </div>
    </div>
</div>



</#if>




<#--<div class="container col-md-10  col-md-offset-1"  style="width: 100%; height: 500px">-->
<#--<h2>Modal Example</h2>-->
<#--<!-- Trigger the modal with a button &ndash;&gt;-->
<#--<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#chart">Open Modal</button>-->

<#--<!-- Modal &ndash;&gt;-->
<#--<div class="modal fade" id="chart" role="dialog"  style="margin-left: 10%; margin-top: 5%;width: 100%; height: 100%">-->
<#--<div class="modal-dialog">-->

<#--<!-- Modal content&ndash;&gt;-->
<#--<div class="modal-content">-->
<#--<div class="modal-header">-->
<#--<button type="button" class="close" data-dismiss="modal">&times;</button>-->
<#--<h4 class="modal-title">Modal Header</h4>-->
<#--</div>-->
<#--<div class="modal-body" id="chart">-->
<#--</div>-->
<#--<div class="modal-footer">-->
<#--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
<#--</div>-->
<#--</div>-->

<#--</div>-->
<#--</div>-->

<#--</div>-->






<#--<div id="users"></div>-->
<#--<button onclick="update()">Refresh<button>-->
<#--<#include "/WEB-INF/dod/ss.ftl">-->

</body>
</html>
