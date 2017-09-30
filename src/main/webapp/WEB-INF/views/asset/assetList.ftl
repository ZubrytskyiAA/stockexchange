<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UserData</title>
</head>
<body class="container">
<#include "*/header.ftl">
<div class="table-responsive" style="background-color: antiquewhite">
    <caption>Assets list</caption>

<#include "changeAssetsTMPL.ftl">


    <table class="table table-striped">
        <tr>

            <th>Название инструмента</th>
            <th>Доступные средства</th>
            <th>Заблокированные средства</th>

        </tr>

    <#include "showAsset.ftl">

    </table>
</div>


</body>
</html>