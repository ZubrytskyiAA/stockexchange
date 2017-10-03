<#if listAssetsByUserName??>
<form class="form-group" action="/asset/withdrawAsset" method="post" name="withdrawAssetForm">
    <input name="userName" type="hidden" value="${selectUserName}">
    <label class="control-label" for="price"> Вывести актив </label>
    <select class="form-control" name="issueName" required>
        <option selected></option>
        <#list listAssetsByUserName?sort as assets>
            <option value=${assets.issueId.name}>${assets.issueId.name}</option>
        </#list>
    </select>
    <input title="full_name" type="number" name="qtyWithdraw" required>
    <input type="submit" value="Вывести">
</form>
</#if>