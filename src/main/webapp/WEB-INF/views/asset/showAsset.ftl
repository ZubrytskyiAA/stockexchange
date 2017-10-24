<div class="form-group col-sm-5">
<#if  "${selectUserName}" = "">

<#elseif listAssetsByUserName??>
    <table class="table table-striped col-sm-5">
        <thead>
        <tr>
            <th><@spring.message "tiker"/></th>
            <th><@spring.message "freeAssets"/></th>
            <th><@spring.message "blockAssets"/></th>
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
    <h3><@spring.message "noAssets"/></h3>
    </p>
</#if>

</div>

