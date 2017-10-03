<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Assets</title>
</head>
<body class="container">
<#include "*/header.ftl">

<div class="container">
    <h1 align="center">Assets list</h1>
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
<#if "${selectUserName}" != "">
    <div class="row">
        <div class="col-sm-3">
            <#include "addAsset.ftl">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <#include "withdraw.ftl">
        </div>
    </div>
</#if>
    <div class="row">
        <div class="col-sm-3">
        <#include "showAsset.ftl">
        </div>
    </div>
</div>
</body>
</html>