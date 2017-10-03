<div class="form-group col-sm-5">
<#if  "${selectUserName}" = "">

<#elseif listAssetsByUserName??>
    <table class="table table-striped col-sm-5">
        <thead>
        <tr>
            <th>Название инструмента</th>
            <th>Доступные средства</th>
            <th>Заблокированные средства</th>
        </tr>
        </thead>
        <tbody>
            <#list listAssetsByUserName as assets>
            <tr>
                <td><a href="/issue/${assets.issueId.name}">${assets.issueId.name}</a></td>
                <td>${assets.free}</td>
                <td>${assets.blocked}</td>
            </tr>
            </#list>
        </tbody>
    </table>

<#else >


    <p>
    <h3>There isn't any assets</h3>
    </p>
</#if>

</div>

