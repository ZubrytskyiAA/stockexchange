<div class="form-group">

<#if listAssetsByUserName??>

    <table class="table table-striped">
        <tr>

            <th>Название инструмента</th>
            <th>Доступные средства</th>
            <th>Заблокированные средства</th>

        </tr>

        <#list listAssetsByUserName as assets>
            <tr>
                <td><a href="/issue/${assets.issueId.name}">${assets.issueId.name}</a></td>
                <td>${assets.free}</td>
                <td>${assets.blocked}</td>
            </tr>

        </#list>

    </table>

<#else >

    <h3>There isn't any assets</h3>
</#if>

</div>

