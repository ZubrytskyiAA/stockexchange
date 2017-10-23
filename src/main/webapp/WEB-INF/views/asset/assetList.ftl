<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Assets</title>
</head>
<body class="container">
<#include "*/header.ftl">

<div class="container">

    <div class="row">
        <div class="col-sm-3">
            <label class="control-label" for="price"> Клиент:</label>
            <select class="form-control" name="userName"
                    onchange="document.location=this.options[this.selectedIndex].value">
            <#if "${selectUserName}" = "">
                <option selected value=""></option>
            <#else >
                <option selected value=/asset/${selectUserName}>${selectUserName}</option>
            </#if>
            <#list listNamesAllUsers as userNames>
                <option value=/asset/${userNames}>${userNames}</option>
            </#list>
            </select>
        </div>
    </div>


    <div class="container">
        <br>
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#replenish">Бумаги</a></li>
            <li><a data-toggle="tab" href="#withdraw">Деньги</a></li>

        </ul>

        <div class="tab-content">
            <div id="replenish" class="tab-pane fade in active">

            <#if "${selectUserName}" != "">
                <div class="row">
                    <div class="col-sm-3">
                        <#include "showAssetIssue.ftl">
                    </div>
                </div>
            </#if>
            </div>
            <div id="withdraw" class="tab-pane fade">

            <#if "${selectUserName}" != "">
                <div class="row">
                    <div class="col-sm-3">
                        <#include "showAssetMoney.ftl">
                    </div>
                </div>
            </#if>
            </div>

        </div>
    </div>



    <#--<div class="row">-->
        <#--<div class="col-sm-3">-->
        <#--<#include "showAsset.ftl">-->
        <#--</div>-->
    <#--</div>-->
</div>
</body>
</html>