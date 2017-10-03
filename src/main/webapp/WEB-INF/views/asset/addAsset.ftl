<#if listIssueNamesActive??>
<form class="form-group" action="/asset/addAsset" method="post" name="addAssetForm">
    <input name="userName" type="hidden" value="${selectUserName}">
    <label class="control-label" for="price"> Добавить актив </label>
    <select class="form-control" name="issueName" required>
        <option selected></option>
        <#list listIssueNamesActive?sort as issueNames>
            <option value=${issueNames}>${issueNames}</option>
        </#list>
    </select>
    <input title="quantity" type="number" name="qtyAdd" required>
    <input type="submit" value="пополнить">
</form>
</#if>

