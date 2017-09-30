
<div class="form-group">

<#if listAssetsByUserName??>

        <#list listAssetsByUserName as assets>
            <tr>
                <td>${assets.issueId.name}</td>
                <td>${assets.free}</td>
                <td>${assets.blocked}</td>
            </tr>

        </#list>



<#else >
    <br>
    <br>
    <br>
    <br>
    <br>
    <h3>There isn't any assets</h3>
</#if>

</div>

